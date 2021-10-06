package dispetcher

import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    launch(Dispatchers.Default) {
        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Поток корутины (до остановки): ${Thread.currentThread().name}")
        delay(500L)
        println("Поток корутины (после остановки): ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("Custom Thread")) {
        println("Поток корутины: ${Thread.currentThread().name}")
    }

    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
}