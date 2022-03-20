package eveshtard.lab15

import java.util.*

object Lab2TaskB2 {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Введите три числа, используя клавишу \"ввод\", пожалуйста.")
        val scanner = Scanner(System.`in`)
        val d = scanner.nextInt()
        val e = scanner.nextInt()
        val f = scanner.nextInt()
        val dis = dis(d, e, f)
        println("Discriminant: $dis")
        if (dis > 0) {
            val x = disOverZero(dis, d, e)
            println(x)
        } else if (dis == 0.0) {
            val z = zeroDis(d, e)
            println(z)
        } else {
            System.err.println("Отрицательный дискриминант")
        }
    }

    private fun dis(a: Int, b: Int, c: Int): Double {
        return (b * b - 4 * a * c).toDouble()
    }

    private fun zeroDis(a: Int, b: Int): Double {
        return -(b.toDouble() / (2 * a))
    }

    private fun disOverZero(dis: Double, a: Int, b: Int): String {
        val j = -b + Math.sqrt(dis) / (2 * a)
        val y = -b - Math.sqrt(dis) / (2 * a)
        return "$j $y"
    }
}