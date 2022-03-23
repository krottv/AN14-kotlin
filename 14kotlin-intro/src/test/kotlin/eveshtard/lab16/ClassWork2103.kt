package eveshtard.lab16

import org.junit.Test

data class Car(val speed: Int)


class ClassWork2103 {
    val cars = listOf(Car(10), Car(20), Car(5), Car(30))

    @Test
    fun sumOFSample() {
        for (i in 10 downTo 1) print("$i ")
        println()
        for (i in 1..10 step 2) print("$i ")
        println()
        for (i in 1..10) print("$i ")
        println()
        for (i in 1 until 10) print("$i ")
        println()

        when (5) {
            in 1..10 -> print("5 is in the range")
            else -> println("5 isn't in the range")
        }
        println()
        println(cars.sumCustom { it.speed })
    }

    private inline fun <T> List<T>.sumCustom(predicate: (T) -> Int): Int {
        var sum = 0
        for (car in this)
            sum += predicate(car)
        return sum
    }

    override fun toString(): String {
        return "ClassWork2103(cars=$cars)"
    }


}
