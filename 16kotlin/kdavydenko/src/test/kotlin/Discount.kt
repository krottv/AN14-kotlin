data class Discount(val name: String, val percent: Double, val price: Int) {


}

fun <T> List<T>.average(lambda: (T) -> Int): Double {
    var sum: Double = 0.0
    for (i in this)
        sum += lambda(i)

    return sum / this.size
}