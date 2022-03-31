package Task1

data class Rectangle(var width: Int, var height: Int) : Shape{
    override fun square(): Int {
        return width * height
    }

}