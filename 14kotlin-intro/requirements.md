## Консольные домашние задания. Каждая задача - новый класс в папке тест. Исполняемый метод помечаем аннотацией @Test


### Консольное вычисление площади фигур и вывод

У нас есть:

``` kotlin
interface Shape {
	fun square(): Int
}
```

Надо создать 4 иммутабельных data класса: Square(height), Rectangle(width, height), Circle(radius), Triangle(firstSide, secondSide, thirdSide)

Каждый класс должен реализовать интерфейс Shape. Метод square должен вычислять площадь фигуры. Кроме Triangle. У triangle нам нужно выбросить GeometryException("Не достаточно данных для вычисления"). GeometryException нужно создать и унаследовать от Exception

Далее есть 

``` kotlin 
interface ShapePrinter {
	fun printShape(shape: Shape)
}
```

Его нужно реализовать и при помощи интерполяции строк вывести площадь фигулы или словить GeometryException и напечатать новое сообщение


В финальном методе нужно проитерировать данную коллекцию и при помощи ShapePrinterImpl вывести всё в консоль.

``` kotlin 
val predefinedCollection = listOf<Shape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10), Rectangle(10, 9))
```

### Релизовать интерфейс ArrayList 

``` kotlin
interface CustomArrayList<Element> {
	fun get(position: Int)
	fun add(element: Element)
	fun removeLast()
	fun trimToSize()
}
```


### Реализовать интерфейсы Set, Map упрощённым способом.

Внутри можно использовать List или посложнее Array. Надо помнить, что ключи map и элементы set уникальны должны быть. Можно делать очень неоптимизированный алгоритм, главное сделать.

``` kotlin
interface SimplifiedSet<Element> {
	fun put(element: Element)
	fun toString(): String
}

interface SimplifiedMap<Key, Value> {
	fun put(key: Key, value: Value)
	fun get(key: Key): Value
	fun toString(): String
}
```

### Реализовать собственный LinkedList

``` kotlin
interface LinkedList<Element> {
	fun get(position: Int)
	fun set(position: Int, element: Element)
	fun add(element: Element)
	fun remove(position: Int)
}
```


Пост подробно про то, как устроен ArrayList - https://habr.com/ru/post/128269/








