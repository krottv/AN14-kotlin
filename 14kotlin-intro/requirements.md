## Консольные домашние задания. Каждая задача - новый класс в папке тест. Исполняемый метод помечаем аннотацией @Test


### Консольное вычисление площади фигур и вывод

У нас есть:

``` kotlin
interface Shape {
	fun square(): Int
}
```

Надо создать 3 иммутабельных data класса: Square(height), Rectangle(width, height), Circle(radius), Triangle(firstSide, secondSide, thirdSide)

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


### Задача со звёздочкой, будет полезно для собеседований, про устройство массива спрашивают постоянно

Реализовать собственный динамический массив - ArrayList, с методами 

``` kotlin
interface CustomArrayList<Element> {
	fun get(position: Int)
	fun set(position: Int, element: Element)
	fun remove(position: Int)
	fun removeMultiple(positions: IntRange).
}
```

Суть задачи в том, чтобы реализовать оптимизированное удаление из массива. Удаление одного элемента происходит при помощи System.arraycopy()

Пост подробно про то, как устроен ArrayList - https://habr.com/ru/post/128269/








