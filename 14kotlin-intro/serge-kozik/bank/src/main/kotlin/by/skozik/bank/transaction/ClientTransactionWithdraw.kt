package by.skozik.bank.transaction

import by.skozik.bank.currency.CurrencyAmount

class ClientTransactionWithdraw(val account: String, val currencyAmount: CurrencyAmount):
    AbstractTransaction(ClientTransactionType.WITHDRAW) {
}