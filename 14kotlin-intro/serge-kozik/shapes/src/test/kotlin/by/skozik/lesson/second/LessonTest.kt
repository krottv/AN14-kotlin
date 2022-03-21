package by.skozik.lesson.second

import org.junit.Test
import kotlin.test.assertEquals

class LessonTest {

    val int2str: (Int) -> String = { number: Int ->
        var result = ""
        if (number == 25) {
            result = "twenty five"
        }
        result
    }

    val int2str2: (Int) -> String = { number: Int ->
        var result = ""
        if (number == 26) {
            result = "twenty six"
        }
        result
    }

    fun functionToTest(value: Int, lambda: (Int) -> String): String {
        return lambda(value)
    }

    @Test
    fun lambdaTest() {
        assertEquals("twenty five", functionToTest(25, int2str2))
    }
}