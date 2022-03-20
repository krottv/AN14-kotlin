package by.skozik.bank.transaction

import by.skozik.bank.currency.CurrencyAmount

class ClientTransactionDeposit(val account: String, val currencyAmount: CurrencyAmount):
    AbstractTransaction(ClientTransactionType.DEPOSIT)