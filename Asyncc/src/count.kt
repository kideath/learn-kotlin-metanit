package count

import kotlinx.coroutines.flow.*

suspend fun main(){

    val userFlow = listOf("Tom", "Bob", "Sam").asFlow()
    println("Count: ${userFlow.count()}")       // Count: 3

    // Также мы можем передать в функцию count() условие в виде функции, которая возвращает объект Boolean,
    // то есть true или false. Тогда функция count() возвратит количество элементов, которые соответствуют этому условию:
    val userFlow2 = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()
    val count = userFlow2.count{ username -> username.length > 3 }
    println("Count: $count")       // Count: 2

    // Оператор take ограничивает количество элементов в потоке.
// В качестве параметра она принимает количество элементов с начала потока, которые надо оставить в потоке:
    println("TAKE")
    userFlow2.take(3).collect{user -> println(user)}

    println("DROP")
    // Оператор drop удаляет из потока определенное количество элементов.
// В качестве параметра она принимает количество элементов с начала потока, которые надо убрать из потока:
    userFlow2.drop(3).collect{user -> println(user)}


    println("DROP 2")
    // Оператор drop удаляет из потока определенное количество элементов.
// В качестве параметра она принимает количество элементов с начала потока, которые надо убрать из потока:
    userFlow2.drop(1).collect{user -> println(user)}
}