package by.skozik.bank.exception

class BankException: Exception {
    val code: ExceptionCode

    constructor(code: ExceptionCode) : super(code.msg) {
        this.code = code
    }

    constructor(code: ExceptionCode, throwable: Throwable): super(code.msg, throwable) {
        this.code = code
    }

    constructor(code: ExceptionCode, message: String) : super(code.msg + message) {
        this.code = code
    }
}