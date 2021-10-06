package jobb

import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    val job = launch{
        for(i in 1..5){
            println(i)
            delay(400L)
        }
    }

    println("Start")
    job.join() // ожидаем завершения корутины
    println("End")

    // Теперь применим отложенное выполнение:
    // корутина создана, но не запущена
    val job2 = launch(start = CoroutineStart.LAZY) {
        delay(200L)
        println("Coroutine has started")
    }

    delay(1000L)
    job2.start() // запускаем корутину
    println("Other actions in main method")

}