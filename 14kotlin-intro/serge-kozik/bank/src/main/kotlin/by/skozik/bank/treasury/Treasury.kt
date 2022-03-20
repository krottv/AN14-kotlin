package by.skozik.bank.treasury

import by.skozik.bank.TREASURY_CHECK_JOB_PERIOD_SEC
import by.skozik.bank.common.BankUtil
import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.currency.CurrencyType
import by.skozik.bank.userinterface.printMessage
import java.math.BigDecimal
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

class Treasury {
    val amounts: ConcurrentMap<CurrencyType, AtomicReference<BigDecimal>> = ConcurrentHashMap()
    private val scheduler = Executors.newScheduledThreadPool(1)

    companion object {
        var instance: Treasury? = null
            private set

        fun initTreasury() {
            instance = Treasury()
            instance?.startJob()
        }
    }

    private fun startJob() {
        scheduler.scheduleAtFixedRate(
            CheckTreasuryJob(),
            0,
            TREASURY_CHECK_JOB_PERIOD_SEC.toLong(),
            TimeUnit.SECONDS
        )
    }

    fun stopJob() {
        try {
            scheduler.shutdown()
            scheduler.awaitTermination(TREASURY_CHECK_JOB_PERIOD_SEC.toLong(), TimeUnit.SECONDS)
        } catch (e: Exception) {
            printMessage(e.message)
        } finally {
            scheduler.shutdownNow()
        }
    }

    fun releaseCash(amount: CurrencyAmount) {
        val currentAmount: AtomicReference<BigDecimal> = amounts
            .computeIfAbsent(amount.currencyType) {
                AtomicReference(
                    BigDecimal.ZERO
                )
            }
        BankUtil.getAndSubtractAtomicReference(currentAmount, amount.amount)
    }

    fun storeCash(amount: CurrencyAmount) {
        val currentAmount: AtomicReference<BigDecimal> = amounts.computeIfAbsent(amount.currencyType) {
            AtomicReference(
                BigDecimal.ZERO
            )
        }
        BankUtil.getAndAddAtomicReference(currentAmount, amount.amount)
    }

    fun getCurrencyAmount(type: CurrencyType): AtomicReference<BigDecimal> {
        return amounts.computeIfAbsent(type) {
            AtomicReference(
                BigDecimal.ZERO
            )
        }
    }
}