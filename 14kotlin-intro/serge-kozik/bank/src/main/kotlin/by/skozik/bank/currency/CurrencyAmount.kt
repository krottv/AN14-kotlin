package by.skozik.bank.currency

import java.math.BigDecimal

data class CurrencyAmount(var amount: BigDecimal, val currencyType: CurrencyType) {
    override fun toString(): String {
        return amount.toString() + currencyType.shortName
    }
}