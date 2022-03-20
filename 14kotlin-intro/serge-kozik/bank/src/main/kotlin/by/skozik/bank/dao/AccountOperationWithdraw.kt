package by.skozik.bank.dao

import by.skozik.bank.STATUS_OK
import by.skozik.bank.WITHDRAW_REPORT_FORMAT
import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.transaction.ClientTransactionResult

class AccountOperationWithdraw(val account: String, val amount: CurrencyAmount) : IAccountOperation {
    override fun execute(): ClientTransactionResult {
        AccountDao.instance!!.withdraw(account, amount)
        return ClientTransactionResult(STATUS_OK, WITHDRAW_REPORT_FORMAT.format(account, amount))
    }
}