import Lesson14.Interface.IShape
import Lesson14.Shape.*

fun main(args: Array<String>) {
    val print = PrinterShape()
    val predefinedCollection = listOf<IShape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10))
    predefinedCollection.forEach() {
        print.printShape(it)
    }
}

