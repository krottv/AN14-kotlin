package by.skozik.bank.transaction

import by.skozik.bank.STATUS_ERROR
import by.skozik.bank.exception.ExceptionCode
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

abstract class AbstractTransaction(private val clientTransactionType: ClientTransactionType) : IClientTransaction {
    val locker: ReentrantLock = ReentrantLock()
    val condition: Condition = locker.newCondition()
    var transactionResult: ClientTransactionResult? = null

    override fun getResult(): ClientTransactionResult? {
        locker.lock()
        try {
            while (transactionResult == null) {
                condition.await()
            }
        } catch (e: InterruptedException) {
            transactionResult = ClientTransactionResult(STATUS_ERROR, e.message ?: ExceptionCode.BEM_0003.msg)
        } finally {
            locker.unlock()
        }
        return transactionResult
    }

    override fun putResult(result: ClientTransactionResult?) {
        locker.lock()
        try {
            transactionResult = result
            condition.signalAll()
        } catch (e: Exception) {
            transactionResult = ClientTransactionResult(STATUS_ERROR, e.message ?: ExceptionCode.BEM_0003.msg)
        } finally {
            locker.unlock()
        }
    }

    override fun getType(): ClientTransactionType {
        return this.clientTransactionType
    }
}