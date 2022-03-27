package Lesson14.Shape

import Lesson14.Interface.IShape

data class Square(var height: Int) : IShape {
    class Square constructor(height: Int)

    override fun square(): Int {
        return height * height
    }

    override fun toString(): String {
        return return println("Площадь квадрата: ${square()}").toString()
    }
}
