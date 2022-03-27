package Lesson14.Shape

import Lesson14.Exceptoin.GeometryException
import Lesson14.Interface.IShape

data class Triangle(val firstSide: Int, var secondSide: Int, var thirdSide: Int) : IShape {
    class Triangle constructor(firstSide: Int, secondSide: Int, thirdSide: Int)

    override fun square(): Int {
        throw GeometryException("Не достаточно данных для вычисления")
    }

    override fun toString(): String {
        return println("Треугольник: первая сторона= $firstSide, вторая сторона= $secondSide, третья сторона= $thirdSide").toString()
    }
}
