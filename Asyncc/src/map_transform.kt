package map_transform

import kotlinx.coroutines.flow.*

suspend fun main(){

    val peopleFlow = listOf(
        Person("Tom", 37),
        Person("Sam", 41),
        Person("Bob", 21)
    ).asFlow()

    peopleFlow.map{ person -> person.name }
        .collect { personName -> println(personName) }

    peopleFlow//.map{ person -> person.name }
        .collect { personName -> println(personName) }




    val peopleFlow2 = listOf(
        Person("Tom", 37),
        Person("Bill", 5),
        Person("Sam", 14),
        Person("Bob", 21),
    ).asFlow()

    peopleFlow2.map{ person -> object{
        val name = person.name
        val isAdult = person.age > 17
    }}.collect { user -> println("name: ${user.name}   adult:  ${user.isAdult} ")}






    val peopleFlow3 = listOf(
        Person("Tom", 37),
        Person("Bill", 5),
        Person("Sam", 14),
        Person("Bob", 21),
    ).asFlow()

    peopleFlow3.transform{ person ->
        if(person.age > 17){
            emit(person.name)
        }
    }.collect { personName -> println(personName)}




}

data class Person(val name: String, val age: Int)