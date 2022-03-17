package TMSTasks.Lesson14.Shape.Shapes

import TMSTasks.Lesson14.Shape.Exceptions.GeometryException
import TMSTasks.Lesson14.Shape.Interfaces.IShape
//import org.junit.jupiter.api.Test

data class Square constructor(private var height: Int, private var name: String): AShape(name), IShape {
    private var square: Int = 0

    override fun square(): Int {
        square = height * height
        return square
    }

    override fun printShape(shape: AShape) {
        try {
            println("Square of square $name = $square")
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
