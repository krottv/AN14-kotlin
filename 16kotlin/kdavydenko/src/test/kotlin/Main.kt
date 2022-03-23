import org.junit.Test

class Main {

    @Test
    fun Start() {
        val discount: MutableList<Discount> = mutableListOf(
            Discount("a", 10.0, 10),
            Discount("b", 11.0, 30),
            Discount("c", 12.0, 50),
            Discount("d", 13.0, 70),
            Discount("e", 14.0, 90),
            Discount("f", 15.0, 80),
            Discount("g", 16.0, 60),
            Discount("h", 17.0, 40),
            Discount("j", 18.0, 20),
            Discount("k", 19.0, 5),
        )

        println(discount.average { it.price })
    }
}