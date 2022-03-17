import org.junit.jupiter.api.Test

private fun String.lengthInSquare(): Int = this.length*this.length

class Sample {

    fun task1() {
            val string= "sdf"
            println(string.lengthInSquare())
    }

    @Test
    fun task2() {
        val a = 5
        val lambda: (Int) -> String = {"$it is your number"}
        println(lambda(a))
    }
}