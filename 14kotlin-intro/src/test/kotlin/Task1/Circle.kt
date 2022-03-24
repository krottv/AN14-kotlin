package Task1

data class Circle(var radius: Int) : Shape, ShapePrinter {
    override fun square(): Int {
        return radius * radius
    }

}