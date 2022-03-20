package by.skozik.bank.dao

import by.skozik.bank.transaction.ClientTransactionResult

interface IAccountOperation {
    fun execute(): ClientTransactionResult
}