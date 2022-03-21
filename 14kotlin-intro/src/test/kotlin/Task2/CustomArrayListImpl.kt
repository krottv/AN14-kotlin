class CustomArrayListImpl<Element> : CustomArrayList<Element> {

    var list = arrayOfNulls<Any?>(5)
    var size = 0

    override fun get(position: Int): Any? {
        return list.get(position)
    }

    override fun add(element: Element) {
        if (size == list.size) {
            val newList = arrayOfNulls<Any?>(list.size * 2)
            for (i in list.indices)
                newList[i] = list[i]
            list = newList
            list[size] = element
            size++
        } else {
            list[size] = element
            size++
        }
    }

    override fun removeLast() {
        list[size - 1] = null
        size--
    }

    override fun trimToSize() {
        val newList = arrayOfNulls<Any?>(size)
        for (i in 0..size - 1)
            newList[i] = list[i]
        list = newList
    }

}