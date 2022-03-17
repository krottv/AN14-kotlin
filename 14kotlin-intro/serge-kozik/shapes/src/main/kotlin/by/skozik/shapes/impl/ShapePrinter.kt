package by.skozik.shapes.impl

import by.skozik.shapes.api.GeometryException
import by.skozik.shapes.api.IShapePrinter
import by.skozik.shapes.api.Shape

class ShapePrinter : IShapePrinter {
    override fun printShape(shape: Shape) : String {
        val shapeName = when (shape) {
            is Circle -> "Circle radius = ${shape.radius}"
            is Rectangle -> "Rectangle ${shape.height}x${shape.width}"
            is Square -> "Square side = ${shape.height}"
            is Triangle -> "Triangle sides = ${shape.firstSide}; ${shape.secondSide}; ${shape.thirdSide}"
            else -> "Unknown shape"
        }
        val area : String? = try {
            "${shape.square()}"
        } catch (e: GeometryException) {
            e.message
        }
        return "Shape $shapeName area = $area"
    }
}