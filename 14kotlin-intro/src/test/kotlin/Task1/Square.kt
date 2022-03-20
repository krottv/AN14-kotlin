package Task1

import kotlin.math.pow

data class Square(val height: Int) : Shape {

    override fun square(): Int {
        return height.toFloat().pow(2).toInt()
    }
}