package reduce_fold

import kotlinx.coroutines.flow.*

fun main(){

    // Например, у нас есть поток чисел, найдем сумму всех чисел в потоке:
    val numberFlow = listOf(1, 2, 3, 4, 5)
    val reducedValue = numberFlow.reduce{ a, b -> a + b }
    println(reducedValue)   // 15

    val userFlow2 = listOf("Tom", "Bob", "Kate", "Sam", "Alice") //.asFlow()
    val reducedValue2 = userFlow2.reduce{ a, b -> a + " " + b }
    println(reducedValue2)   // Tom Bob Kate Sam Alice

    // Функция fold также сводит все элементы потока в один. Но в отличие от оператора reduce оператор fold в
// качестве первого параметра принимает начальное значение:
    val userFlow3 = listOf("Tom", "Bob", "Kate", "Sam", "Alice") // .asFlow()
    val foldedValue3 = userFlow3.fold("Users:", { a, b -> a + " " + b })
    println(foldedValue3)   // Users: Tom Bob Kate Sam Alice
}