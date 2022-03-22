package Lesson14.Shape

import Lesson14.Exceptoin.GeometryException
import Lesson14.Interface.IShape
import Lesson14.Interface.IShapePrinter

open class PrinterShape : IShapePrinter {
    override fun printShape(shape: IShape): String {
        return try {
            shape.toString()
        } catch (e: GeometryException) {
            e.message ?: "Geometry exception"
        }
    }
}