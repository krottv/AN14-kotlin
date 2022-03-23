package eveshtard.lab16

import org.junit.Test

data class Discount(val name: String, val percent: Double, val price: Int)
class DiscountAverageValue {

    private val discountValue = listOf(
        Discount("1", 5.0, 100),
        Discount("2", 4.0, 110),
        Discount("3", 3.0, 120),
        Discount("4", 2.0, 130),
        Discount("5", 3.0, 140),
        Discount("6", 4.0, 150),
        Discount("7", 5.0, 160),
        Discount("8", 4.0, 170),
        Discount("9", 3.0, 180),
        Discount("10", 2.0, 190),
    )

    @Test
    fun sumOFSample() {
        println(discountValue.average { it.price })
    }

    private fun <T> List<T>.average(lambda: (T) -> Int): Int {
        var sum = 0
        var count = 0
        for (discount in this) {
            sum += lambda(discount)
            count++
        }
        return (sum / count)
    }
}