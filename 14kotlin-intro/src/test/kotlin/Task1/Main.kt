package Task1

import org.junit.Test

class Main {
    val shapePrinterImpl = ShapePrinterImpl()

    @Test
    fun start() {
        shapePrinterImpl.printShape(Circle(3))
        shapePrinterImpl.printShape(Square(3))
        shapePrinterImpl.printShape(Rectangle(2, 3))
        shapePrinterImpl.printShape(Triangle(2, 2, 2))

        val predefinedCollection =
            listOf<Shape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10), Rectangle(10, 9))
        for (i in predefinedCollection)
            shapePrinterImpl.printShape(i)
    }
}