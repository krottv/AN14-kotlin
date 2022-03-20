package eveshtard.lab15

//Ввести n слов с консоли. Найти слово, состоящее только из различных символов.
// Если таких слов несколько, найти первое из них.

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object Lab4Task7 {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        println("Введите число слов:")
        val numberOfWords = reader.readLine().toInt()
        val arrayString = arrayOfNulls<String>(numberOfWords)
        for (i in arrayString.indices) {
            println("Введите слово номер " + (i + 1))
            arrayString[i] = reader.readLine()
        }
        val uniqueLettersWord = findByUniqueLetters(arrayString)
        println(uniqueLettersWord)
    }

    private fun findByUniqueLetters(arrayString: Array<String?>): String? {
        for (i in arrayString.indices) {
            val charsOfCurrentWord = arrayString[i]!!.toCharArray()
            var tempWordOfUniqueLetters = ""
            for (j in charsOfCurrentWord.indices) {
                tempWordOfUniqueLetters += if (!tempWordOfUniqueLetters.contains(charsOfCurrentWord[j].toString())) {
                    charsOfCurrentWord[j]
                } else {
                    break
                }
            }
            if (arrayString[i] == tempWordOfUniqueLetters) {
                return tempWordOfUniqueLetters
            }
        }
        return null
    }
}