package by.skozik.shapes.impl

import by.skozik.shapes.api.GeometryException
import by.skozik.shapes.api.Shape

class Triangle(val firstSide : Int, val secondSide: Int, val thirdSide: Int) : Shape {
    override fun square(): Int {
        throw GeometryException("Not enough data to calculate square.")
    }
}