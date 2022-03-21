package by.skozik.bank.common

import by.skozik.bank.MAX_COINS_NUMBER
import by.skozik.bank.client.ClientTask
import by.skozik.bank.client.ClientTaskBuilder
import by.skozik.bank.currency.CurrencyType
import by.skozik.bank.dao.AccountDao
import by.skozik.bank.office.OfficeManager
import by.skozik.bank.transaction.ClientTransactionType
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicReference
import kotlin.random.Random

object BankUtil {
    private val random = Random

    fun getAndAddAtomicReference(currentAmount: AtomicReference<BigDecimal>, augend: BigDecimal) {
        var oldVal: BigDecimal
        do {
            oldVal = currentAmount.get()
        } while (!currentAmount.compareAndSet(oldVal, oldVal.add(augend)))
    }

    fun getAndSubtractAtomicReference(currentAmount: AtomicReference<BigDecimal>, subtrahend: BigDecimal) {
        var oldVal: BigDecimal
        do {
            oldVal = currentAmount.get()
        } while (!currentAmount.compareAndSet(oldVal, oldVal.subtract(subtrahend)))
    }

    fun generateClientTasks(
        numberOfTasks: Int,
        accounts: List<String>,
        maxAmount: Int,
        officeManager: OfficeManager?
    ): List<ClientTask> {
        val result: MutableList<ClientTask> = ArrayList()
        for (i in 0 until numberOfTasks) {
            val account = accounts[random.nextInt(accounts.size)]
            val amount = "%s.%s".format(random.nextInt(maxAmount), random.nextInt(MAX_COINS_NUMBER))
            val currency = AccountDao.instance!!.getAccountValue(account)?.currencyType ?: CurrencyType.TALENT
            val transactionType = ClientTransactionType.values()[random.nextInt(ClientTransactionType.values().size)]
            result.add(
                ClientTaskBuilder(officeManager!!)
                    .setClientId(i.toString())
                    .setAccount(account)
                    .setAmount(BigDecimal(amount))
                    .setCurrency(currency)
                    .setTransactionType(transactionType)
                    .build()
            )
        }
        return result
    }
}