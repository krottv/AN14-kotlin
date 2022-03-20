package by.skozik.bank.office

import by.skozik.bank.dao.deposit
import by.skozik.bank.dao.withdraw
import by.skozik.bank.transaction.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

object CashierCommandFactory {
    private val commands: ConcurrentMap<ClientTransactionType, (IClientTransaction) -> ClientTransactionResult> =
        ConcurrentHashMap()

    init {
        commands[ClientTransactionType.WITHDRAW] = { transaction ->
            withdraw(
                transaction as ClientTransactionWithdraw
            )
        }

        commands[ClientTransactionType.DEPOSIT] = { transaction ->
            deposit(
                transaction as ClientTransactionDeposit
            )
        }
    }

    fun getCommand(type: ClientTransactionType?): ((IClientTransaction) -> ClientTransactionResult)? {
        return commands[type]
    }
}