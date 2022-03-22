package Lesson14.Shape
import Lesson14.Interface.IShape
import kotlin.math.PI

data class Circle(val radius: Int) : IShape {
    class Circle constructor(radius: Int)


    override fun square(): Int {
        return (PI * radius * radius).toInt()
    }

    override fun toString(): String {
        return return println("Площадь кргуа: ${square()}").toString()
    }
}






