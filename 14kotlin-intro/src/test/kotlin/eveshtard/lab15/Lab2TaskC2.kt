package eveshtard.lab15

object Lab2TaskC2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val number = 5467
        val result = 0
        sumDigitInNumber(number, result)
    }

    private fun sumDigitInNumber(num: Int, sum: Int) {
        var sum = sum
        if (num != 0) {
            sum += num % 10
            sumDigitInNumber(num / 10, sum)
        } else println(sum)
    }
}