import org.junit.Test

class Main {

    @Test
    fun start() {
        val customArrayList = CustomArrayListImpl<Int>()
        for (i in 0..25)
            customArrayList.add(i)
        customArrayList.removeLast()
        customArrayList.trimToSize()
        for (i in 0..customArrayList.list.size - 1)
            print("${customArrayList.get(i)} ")
    }
}