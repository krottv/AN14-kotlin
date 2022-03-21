package by.skozik.bank.office

import by.skozik.bank.office.CashierCommandFactory.getCommand
import by.skozik.bank.transaction.IClientTransaction

class CashierTask(val officeManager: OfficeManager) : Runnable {
    var isActive: Boolean = true

    override fun run() {
        while (isActive) {
            try {
                val clientTransaction: IClientTransaction? = officeManager.getClientTask()
                clientTransaction?.putResult(
                    getCommand(clientTransaction.getType())?.let { it(clientTransaction) }
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}