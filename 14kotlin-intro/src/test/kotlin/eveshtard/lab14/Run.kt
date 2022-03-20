package eveshtard.lab14

fun main() {

    val predefinedCollection = listOf(Square(10, ""), Circle(4), Triangle(1, 1, 1),
        Rectangle(2, 10), Rectangle(10, 9))

    val shapePrinterImpl = ShapePrinterImpl()
    predefinedCollection.forEach { shape -> shapePrinterImpl.printShape(shape) }
}