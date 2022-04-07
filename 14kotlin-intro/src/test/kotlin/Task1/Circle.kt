package Task1

import kotlin.math.pow

data class Circle(val radius: Int) : Shape {
    override fun square(): Int {
        return (Math.PI * radius.toFloat().pow(2).toInt()).toInt()
    }
}