package by.skozik.bank.dao

import by.skozik.bank.DEPOSIT_REPORT_FORMAT
import by.skozik.bank.STATUS_OK
import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.transaction.ClientTransactionResult

class AccountOperationDeposit(val account: String, val amount: CurrencyAmount) : IAccountOperation {
    override fun execute(): ClientTransactionResult {
        AccountDao.instance!!.deposit(account, amount)
        return ClientTransactionResult(STATUS_OK, DEPOSIT_REPORT_FORMAT.format(account, amount))
    }
}