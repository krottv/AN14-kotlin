package by.skozik.bank.office

import by.skozik.bank.CASHIER_POOL_STOP_WAIT_SEC
import by.skozik.bank.CASHIER_TASK_PERIOD_CHECK_MS
import by.skozik.bank.exception.BankException
import by.skozik.bank.exception.ExceptionCode
import by.skozik.bank.transaction.IClientTransaction
import by.skozik.bank.userinterface.printMessage
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.TimeUnit

class OfficeManager(val numberOfCashier : Int) {
    private var transactionQueue:SynchronousQueue<IClientTransaction> = SynchronousQueue()
    private var cashierPool: ExecutorService? = null
    private val cashierTasks: MutableCollection<CashierTask> = mutableListOf()
    init {
        startCashierPool()
    }

    private fun startCashierPool() {
        cashierPool = Executors.newFixedThreadPool(numberOfCashier)
        for (i in 0 until numberOfCashier) {
            val task = CashierTask(this)
            cashierTasks.add(task)
            cashierPool?.submit(task)
        }
    }

    fun produce(transaction: IClientTransaction) {
        try {
            if (!transactionQueue.offer(transaction, 3, TimeUnit.SECONDS)) {
                throw BankException(ExceptionCode.BEM_0001)
            }
        } catch (e: InterruptedException) {
            throw BankException(ExceptionCode.BEM_0001, e)
        }
    }

    fun getClientTask(): IClientTransaction? {
        return try {
            transactionQueue.poll(CASHIER_TASK_PERIOD_CHECK_MS.toLong(), TimeUnit.MILLISECONDS)
        } catch (e: InterruptedException) {
            throw BankException(ExceptionCode.BEM_0002, e)
        }
    }

    fun stopCashierPool() {
        for (task in cashierTasks) {
            task.isActive = false
        }
        try {
            cashierPool?.shutdown()
            cashierPool?.awaitTermination(CASHIER_POOL_STOP_WAIT_SEC.toLong(), TimeUnit.SECONDS)
        } catch (e: Exception) {
            printMessage(e.message)
        } finally {
            cashierPool?.shutdownNow()
        }
    }
}