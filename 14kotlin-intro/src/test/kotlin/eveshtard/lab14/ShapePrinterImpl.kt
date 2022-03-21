package eveshtard.lab14

class ShapePrinterImpl : IShapePrinter {

    override fun printShape(shape: IShape) {
        try {
            println(shape.toString())
        } catch (e: GeometryException) {
            println(e.message.toString())
        }
    }
}
