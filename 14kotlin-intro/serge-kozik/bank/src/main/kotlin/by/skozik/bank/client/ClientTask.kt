package by.skozik.bank.client

import by.skozik.bank.exception.BankException
import by.skozik.bank.office.OfficeManager
import by.skozik.bank.transaction.IClientTransaction
import by.skozik.bank.userinterface.printMessage

class ClientTask(
    val id: String,
    val clientTransaction: IClientTransaction,
    val officeManager: OfficeManager
) : Runnable {
    override fun run() {
        try {
            officeManager.produce(clientTransaction)
            val transactionResult = clientTransaction.getResult()
            printMessage(id, clientTransaction.getType().name, transactionResult.toString())
        } catch (e: BankException) {
            printMessage(id, clientTransaction.getType().name, e.message)
        }
    }
}