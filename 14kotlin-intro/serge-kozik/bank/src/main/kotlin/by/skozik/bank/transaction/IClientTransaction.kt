package by.skozik.bank.transaction

import by.skozik.bank.exception.BankException

interface IClientTransaction {
    @Throws(BankException::class)
    fun getResult(): ClientTransactionResult?

    @Throws(BankException::class)
    fun putResult(result: ClientTransactionResult?)
    fun getType(): ClientTransactionType
}