package by.skozik.bank

import java.math.BigDecimal

const val STATUS_ERROR = "error"
const val STATUS_OK = "ok"
const val WITHDRAW_REPORT_FORMAT = "Account %s withdraw %s"
const val DEPOSIT_REPORT_FORMAT = "Account %s deposit %s"
const val NOT_IMPLEMENTED_REPORT_FORMAT = "Operation %s is not implemented"
const val TREASURY_CHECK_JOB_PERIOD_SEC = 1
var CURRENCY_TALENT_MAX_TREASURY_LIMIT = BigDecimal(100)
var CURRENCY_TALENT_MIN_TREASURY_LIMIT = BigDecimal(10)
var CURRENCY_TALENT_TRANCHE_TREASURY = BigDecimal(50)
const val CLIENT_TRANSACTION_REPORT_FORMAT = "client %s %s %s\n"
const val TREASURY_ADD_JOB_REPORT = "Treasury job move from remote storage to Bank %s%s"
const val TREASURY_REMOVE_JOB_REPORT = "Treasury job move from Bank to remote storage %s%s"
const val TREASURY_JOB_START_REPORT = "Treasury job is running; treasury: %s"
const val CASHIER_TASK_PERIOD_CHECK_MS = 900
const val CASHIER_POOL_STOP_WAIT_SEC = 1
const val BANK_WORKING_TIME_SEC = 5
const val MAX_COINS_NUMBER = 99
const val NOT_ENOUGH_MONEY_ON_ACCOUNT_EXCEPTION_FORMAT = " account %s, amount %s"