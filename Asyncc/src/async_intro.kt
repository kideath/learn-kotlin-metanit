package async_intro

import kotlinx.coroutines.*

//suspend fun main() = coroutineScope{
//
//    launch {
//        getUsers().forEach { user -> println(user) }
//    }
//}
//
//suspend fun getUsers(): List<String> {
//    delay(1000L)  // имитация продолжительной работы
//    return listOf("Tom", "Bob", "Sam")
//}

import kotlinx.coroutines.flow.*

suspend fun main(){
    getUsers().collect { user -> println(user) }

    getNumbers().collect { number -> println(number) }

    val numberFlow= getNumbers2()       // поток создан, но не запущен
    println("numberFlow has created")
    println("launch collect function")
    numberFlow.collect { number -> println(number) }   // запуск потока
}

fun getUsers(): Flow<String> = flow {
    val database = listOf("Tom", "Bob", "Sam")  // условная база данных
    var i = 1;
    for (item in database){
        delay(400L) // имитация продолжительной работы
        println("Emit $i item")
        emit(item) // емитируем значение  // передаем значение в поток
        i++
    }
}

fun getNumbers(): Flow<Int> = flow{
    for(item in 1..5){
        emit(item * item)
    }
}

fun getNumbers2() = flow{
    println("numberFlow has started")
    for(item in 1..5){
        emit(item * item)
    }
}