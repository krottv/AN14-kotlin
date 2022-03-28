package TMSTasks.Lesson14.Shape.Shapes

import TMSTasks.Lesson14.Shape.Exceptions.GeometryException
import TMSTasks.Lesson14.Shape.Interfaces.IShape

data class Triangle constructor(private var firstSide: Int, private var secondSide: Int, private var thirdSide: Int, private var name: String): AShape(name), IShape{
    private var square: Int = 0

    override fun square(): Int {
        square = -1
        return -1
    }

    override fun printShape(shape: AShape) {
        try {
            println("Square of triangle $name = $square")
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
