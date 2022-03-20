package Task1

class ShapePrinterImpl : ShapePrinter {
    override fun printShape(shape: Shape) {
        try {
            val value = shape.square()
            println("Площадь равна $value")
        } catch (e: Exception) {
            println(e.message)
        }
    }

}