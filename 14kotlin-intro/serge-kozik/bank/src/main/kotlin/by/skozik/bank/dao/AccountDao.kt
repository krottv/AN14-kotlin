package by.skozik.bank.dao

import by.skozik.bank.NOT_ENOUGH_MONEY_ON_ACCOUNT_EXCEPTION_FORMAT
import by.skozik.bank.common.LockChannel
import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.exception.BankException
import by.skozik.bank.exception.ExceptionCode
import by.skozik.bank.treasury.Treasury
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.Lock

class AccountDao(accounts: Map<String, CurrencyAmount>) {
    companion object {
        var instance: AccountDao? = null
            private set

        fun initAccountDao(accounts: Map<String, CurrencyAmount>) {
            instance = AccountDao(accounts)
        }
    }

    private var bankAccounts: ConcurrentHashMap<String, CurrencyAmount> = ConcurrentHashMap<String, CurrencyAmount>()
    private val lockChannel: LockChannel = LockChannel("Dao-lockchannel")

    init {
        for ((key, value) in accounts) {
            bankAccounts[key] = value
        }
    }

    fun withdraw(account: String, amount: CurrencyAmount) {
        val lock: Lock = lockChannel.getLock(account)
        lock.lock()
        try {
            val currentAmount: CurrencyAmount = validateAccountAndGet(account)
            validateCurrency(currentAmount, amount)
            if (currentAmount.amount < amount.amount) {
                throw BankException(
                    ExceptionCode.BEM_0006,
                    NOT_ENOUGH_MONEY_ON_ACCOUNT_EXCEPTION_FORMAT.format(account, amount)
                )
            }
            Treasury.instance?.releaseCash(amount)
            currentAmount.amount = currentAmount.amount.subtract(amount.amount)
        } finally {
            lock.unlock()
        }
    }

    fun deposit(account: String, amount: CurrencyAmount) {
        val lock: Lock = lockChannel.getLock(account)
        lock.lock()
        try {
            val currentAmount: CurrencyAmount = validateAccountAndGet(account)
            validateCurrency(currentAmount, amount)
            Treasury.instance?.storeCash(amount)
            currentAmount.amount = currentAmount.amount.add(amount.amount)
        } finally {
            lock.unlock()
        }
    }

    fun getAccountValue(account: String?): CurrencyAmount? {
        return bankAccounts[account]
    }

    private fun validateAccountAndGet(account: String): CurrencyAmount {
        return bankAccounts.get(account)
            ?: throw BankException(ExceptionCode.BEM_0004)
    }

    private fun validateCurrency(currentAmount: CurrencyAmount, amount: CurrencyAmount) {
        if (currentAmount.currencyType != amount.currencyType) {
            throw BankException(ExceptionCode.BEM_0005)
        }
    }
}