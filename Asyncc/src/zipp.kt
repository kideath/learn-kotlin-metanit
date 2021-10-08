package zzip

import kotlinx.coroutines.flow.*

suspend fun main(){

    val english = listOf("red", "yellow", "blue").asFlow()
    val russian = listOf("красный", "желтый", "синий").asFlow()
    english.zip(russian) { a, b -> "$a: $b" }
        .collect { word -> println(word) }

    // в реальности объединяемые потоки могут представлять разные данные, а возвращаемый поток - еще один тип данных:
    val names = listOf("Tom", "Bob", "Sam").asFlow()
    val ages = listOf(37, 41, 25).asFlow()
    names.zip(ages) { name, age -> Person(name, age) }
        .collect { person -> println("Name: ${person.name}   Age: ${person.age}") }
}

data class Person(val name: String, val age: Int)
