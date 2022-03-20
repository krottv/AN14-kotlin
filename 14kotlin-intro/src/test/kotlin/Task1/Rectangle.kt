package Task1

data class Rectangle(val width: Int, val height: Int) : Shape {
    override fun square(): Int {
        return width * height
    }
}