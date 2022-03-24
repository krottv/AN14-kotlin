import org.junit.Test

data class Discount(val name: String, val percent: Double, val price: Int)

class Lesson_16 {
    @Test
    fun test() {
        val disc = listOf(Discount("d1", 13.1,4), Discount("d2", 10.5,55), Discount("d3", 43.1,65), Discount("d4", 65.0,70), Discount("d5", 16.3,45),
            Discount("d6", 33.7,12), Discount("d7", 7.6,90), Discount("d8", 53.1,35), Discount("d9", 16.66,78), Discount("d10", 23.1,100))
        println (disc.average { discount -> discount.price })
    }
    @Test
    fun <T> List<T>.average(lambda: (T) -> Int): Int = this.sumOf(lambda) / this.size
}