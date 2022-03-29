package Lesson14.Shape

import Lesson14.Interface.IShape

data class Rectangle(var width: Int, var height: Int) : IShape {
    class Rectangle constructor(width: Int, height: Int)

    override fun square(): Int {
        return width * height
    }

    override fun toString(): String {
        return return println("Площадь прямоугольника: ${square()}").toString()
    }
}
