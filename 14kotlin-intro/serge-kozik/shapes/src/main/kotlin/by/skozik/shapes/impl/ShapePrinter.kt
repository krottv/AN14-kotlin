package by.skozik.shapes.impl

import by.skozik.shapes.api.GeometryException
import by.skozik.shapes.api.IShapePrinter
import by.skozik.shapes.api.Shape

class ShapePrinter : IShapePrinter {
    override fun printShape(shape: Shape): String {
        return try {
            shape.toString()
        } catch (e: GeometryException) {
            e.message ?: "Geometry exception"
        }
    }
}