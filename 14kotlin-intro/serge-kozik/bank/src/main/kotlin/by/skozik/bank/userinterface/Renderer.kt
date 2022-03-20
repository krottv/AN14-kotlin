package by.skozik.bank.userinterface

import by.skozik.bank.CLIENT_TRANSACTION_REPORT_FORMAT

fun printMessage(clientId: String?, transactionType: String?, transactionResult: String?) {
    println(CLIENT_TRANSACTION_REPORT_FORMAT.format(clientId, transactionType, transactionResult))
}

fun printMessage(message: String?) {
    println(message)
}