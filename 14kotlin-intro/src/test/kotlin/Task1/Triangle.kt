package Task1

data class Triangle(val firstSide: Int, val secondSide: Int, val thirdSide: Int) : Shape {
    override fun square(): Int {
        throw GeometryException("Не достаточно данных для вычисления")
    }
}