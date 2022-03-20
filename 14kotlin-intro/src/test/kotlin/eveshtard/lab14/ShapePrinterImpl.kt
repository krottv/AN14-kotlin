package eveshtard.lab14

class ShapePrinterImpl : IShapePrinter {

    override fun printShape(shape: IShape) {
        println(shape.view())
    }
}
