package by.skozik.bank.treasury

import by.skozik.bank.*
import by.skozik.bank.common.BankUtil
import by.skozik.bank.currency.CurrencyType
import by.skozik.bank.userinterface.printMessage
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicReference
import java.util.stream.Collectors

class CheckTreasuryJob : Runnable {
    companion object {
        var maxLimits: MutableMap<CurrencyType, BigDecimal> = mutableMapOf()
        var minLimits: MutableMap<CurrencyType, BigDecimal> = mutableMapOf()

        init {
            maxLimits[CurrencyType.TALENT] = CURRENCY_TALENT_MAX_TREASURY_LIMIT
            minLimits[CurrencyType.TALENT] = CURRENCY_TALENT_MIN_TREASURY_LIMIT
        }
    }

    override fun run() {
        printMessage(TREASURY_JOB_START_REPORT.format(treasury2String()))
        checkForMinimumLimits()
        checkForMaximumLimits()
    }

    private fun treasury2String(): String? {
        return Treasury.instance?.amounts?.entries?.stream()
            ?.map { e: Map.Entry<CurrencyType, AtomicReference<BigDecimal>> ->
                "%s%s".format(
                    e.value.get(),
                    e.key.shortName
                )
            }
            ?.collect(Collectors.joining(","))
    }

    private fun checkForMinimumLimits() {
        for ((key, value) in minLimits) {
            val currentAmount: AtomicReference<BigDecimal> = Treasury.instance?.getCurrencyAmount(key)
                ?: AtomicReference(BigDecimal.ZERO)
            val oldVal = currentAmount.get()
            if (oldVal < value) {
                moveCashFromRemoteStorageToTreasury(
                    currentAmount, CURRENCY_TALENT_TRANCHE_TREASURY,
                    key.shortName
                )
            }
        }
    }

    private fun moveCashFromRemoteStorageToTreasury(
        currentAmount: AtomicReference<BigDecimal>,
        amount: BigDecimal,
        currencyCode: String
    ) {
        BankUtil.getAndAddAtomicReference(currentAmount, amount)
        printMessage(TREASURY_ADD_JOB_REPORT.format(amount, currencyCode))
    }

    private fun checkForMaximumLimits() {
        for ((key, value) in maxLimits) {
            val currentAmount: AtomicReference<BigDecimal> = Treasury.instance?.getCurrencyAmount(key)
                ?: AtomicReference(BigDecimal.ZERO)
            val oldVal = currentAmount.get()
            if (oldVal > value) {
                val difference = oldVal.subtract(value)
                moveCashFromTreasuryAway(currentAmount, difference, key.shortName)
            }
        }
    }

    private fun moveCashFromTreasuryAway(
        currentAmount: AtomicReference<BigDecimal>,
        amount: BigDecimal,
        currencyCode: String
    ) {
        BankUtil.getAndSubtractAtomicReference(currentAmount, amount)
        printMessage(TREASURY_REMOVE_JOB_REPORT.format(amount, currencyCode))
    }
}