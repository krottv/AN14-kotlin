package Task1

class Main
fun shapePrinterImpl(){
    val predefinedCollection = listOf<Shape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10), Rectangle(10, 9))
    for(i in predefinedCollection){
        printShape(i)
    }
}


fun main(args: Array<String>) {
    val predefinedCollection = listOf<Shape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10), Rectangle(10, 9))
    var i = Circle(9)
    var r = Triangle(10,20,30)
    var t = Square(10)
    printShape(i)
    shapePrinterImpl()
}




