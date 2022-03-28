package TMSTasks.Lesson14.Shape.Shapes

import TMSTasks.Lesson14.Shape.Exceptions.GeometryException
import TMSTasks.Lesson14.Shape.Interfaces.IShape

data class Circle constructor(private var radius: Int, private var name: String): AShape(name), IShape {
    private var square: Int = 0
    private val pi: Double = 3.14

    override fun square(): Int {
        square = (pi * radius * radius).toInt()
        return square
    }

    override fun printShape(shape: AShape) {
        try {
            println("Square of circle $name = $square")
            if (square == -1) {
                throw GeometryException()
            }
        } catch (e: GeometryException){
            println("Geometry Exception: $e")
        }
    }

    override fun getName(): String{return name}
    override fun setName(value: String){
        name = value
    }
}