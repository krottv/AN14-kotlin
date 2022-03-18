package by.skozik.shapes.impl

import by.skozik.shapes.api.Shape

class Square(val height : Int) : Shape {
    override fun square(): Int {
        return height * height
    }

    override fun toString(): String {
        return "Square(height=$height, area=${square()})"
    }


}