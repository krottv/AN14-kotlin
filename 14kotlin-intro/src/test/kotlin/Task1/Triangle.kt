package Task1

import Task1.GeometryException as GeometryException

data class Triangle(var firstSide: Int, var secondSide: Int, var thirdSide: Int) : Shape {
    override fun square(): Int {
            throw throw GeometryException("Не достаточно данных для вычисления")
        }

    }
