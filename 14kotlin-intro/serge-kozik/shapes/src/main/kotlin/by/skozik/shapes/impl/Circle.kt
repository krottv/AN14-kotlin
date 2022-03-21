package by.skozik.shapes.impl

import kotlin.math.PI
import by.skozik.shapes.api.Shape

class Circle(val radius : Int) : Shape {
    override fun square(): Int {
        return (radius * radius * PI).toInt()
    }

    override fun toString(): String {
        return "Circle(radius=$radius, area=${square()})"
    }


}