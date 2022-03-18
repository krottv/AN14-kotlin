package by.skozik.shapes.impl

import by.skozik.shapes.api.Shape

class Rectangle(val width : Int, val height : Int): Shape {
    override fun square(): Int {
        return width * height
    }

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height, area=${square()})"
    }


}