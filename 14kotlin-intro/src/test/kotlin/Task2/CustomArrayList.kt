interface CustomArrayList<Element> {
    fun get(position: Int) : Any?
    fun add(element: Element)
    fun removeLast()
    fun trimToSize()
}