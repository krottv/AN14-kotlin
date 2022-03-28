package TMSTasks.Lesson14.Shape.Shapes

import TMSTasks.Lesson14.Shape.Exceptions.GeometryException
import TMSTasks.Lesson14.Shape.Interfaces.IShapePrinter

abstract class AShape constructor(private var name: String): IShapePrinter, GeometryException() {

    override fun printShape(shape: AShape) {
        println()
    }

    open fun getName(): String{return name}
    open fun setName(value: String){
        name = value
    }
}