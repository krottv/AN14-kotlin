package eveshtard.lab14

import java.lang.Math.PI

class Circle(val radius: Int) : IShape {
    override fun square(): Int {
        return (PI * (radius * radius)).toInt()
    }

    override fun view(): String {
        return "Circle: radius=${radius}, square=${square()}"
    }
}





