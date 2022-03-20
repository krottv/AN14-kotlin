package by.skozik.bank.exception

enum class ExceptionCode(val msg : String) {
    BEM_0001("Failed to dispatch client transaction to queue."),
    BEM_0002("Failed to take client transaction from queue."),
    BEM_0003("Failed to obtain result of client transaction from queue."),
    BEM_0004("Account does not exist."),
    BEM_0005("Currency does not exist."),
    BEM_0006("Not enough money to withdraw."),
    BEM_0007("Unknown Account DAO exception")
}