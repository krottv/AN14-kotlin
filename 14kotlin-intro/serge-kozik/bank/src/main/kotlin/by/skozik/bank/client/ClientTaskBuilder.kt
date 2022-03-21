package by.skozik.bank.client

import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.currency.CurrencyType
import by.skozik.bank.office.OfficeManager
import by.skozik.bank.transaction.ClientTransactionDeposit
import by.skozik.bank.transaction.ClientTransactionType
import by.skozik.bank.transaction.ClientTransactionWithdraw
import by.skozik.bank.transaction.IClientTransaction
import java.math.BigDecimal

class ClientTaskBuilder(val officeManager: OfficeManager) {
    private var id: String = ""
    private var account: String = ""
    private var transactionType: ClientTransactionType? = null
    private var amount: BigDecimal = BigDecimal.ZERO
    private var currency: CurrencyType = CurrencyType.TALENT

    fun setClientId(id: String): ClientTaskBuilder {
        this.id = id
        return this
    }

    fun setAccount(account: String): ClientTaskBuilder {
        this.account = account
        return this
    }

    fun setTransactionType(transactionType: ClientTransactionType?): ClientTaskBuilder {
        this.transactionType = transactionType
        return this
    }

    fun setAmount(amount: BigDecimal): ClientTaskBuilder {
        this.amount = amount
        return this
    }

    fun setCurrency(currency: CurrencyType): ClientTaskBuilder {
        this.currency = currency
        return this
    }

    fun build(): ClientTask {
        var clientTransaction: IClientTransaction? = null
        when (transactionType) {
            ClientTransactionType.DEPOSIT -> clientTransaction = ClientTransactionDeposit(
                account, CurrencyAmount(amount, currency)
            )
            ClientTransactionType.WITHDRAW
            -> clientTransaction = ClientTransactionWithdraw(
                account, CurrencyAmount(amount, currency)
            )
        }
        return ClientTask(
            id,
            clientTransaction!!,
            officeManager
        )
    }
}