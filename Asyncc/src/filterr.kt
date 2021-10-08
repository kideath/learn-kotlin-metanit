package filterr
import kotlinx.coroutines.flow.*

suspend fun main(){

    val peopleFlow = listOf(
        Person("Tom", 37),
        Person("Alice", 32),
        Person("Bill", 5),
        Person("Sam", 14),
        Person("Bob", 21),
    ).asFlow()

    println("filter")
    peopleFlow.filter{ person -> person.age > 17}
        .collect { person -> println("name: ${person.name}   age:  ${person.age} ")}

    println("takeWhile")
    peopleFlow.takeWhile{ person -> person.age > 17}
        .collect { person -> println("name: ${person.name}   age:  ${person.age} ")}

    println("dropWhile")
    peopleFlow.dropWhile{ person -> person.age > 17}
        .collect { person -> println("name: ${person.name}   age:  ${person.age} ")}
}

data class Person(val name: String, val age: Int)