package by.skozik.bank.dao

import by.skozik.bank.STATUS_ERROR
import by.skozik.bank.exception.ExceptionCode
import by.skozik.bank.transaction.ClientTransactionDeposit
import by.skozik.bank.transaction.ClientTransactionResult
import by.skozik.bank.transaction.ClientTransactionWithdraw

fun withdraw(clientTransaction: ClientTransactionWithdraw): ClientTransactionResult {
    return processTransaction(
        AccountOperationWithdraw(
            clientTransaction.account,
            clientTransaction.currencyAmount
        )
    )
}

fun deposit(clientTransaction: ClientTransactionDeposit): ClientTransactionResult {
    return processTransaction(
        AccountOperationDeposit(
            clientTransaction.account,
            clientTransaction.currencyAmount
        )
    )
}

private fun processTransaction(operation: IAccountOperation): ClientTransactionResult {
    return try {
        operation.execute()
    } catch (e: Exception) {
        ClientTransactionResult(STATUS_ERROR, e.message ?: ExceptionCode.BEM_0007.msg)
    }
}
