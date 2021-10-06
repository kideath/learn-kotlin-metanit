package coroutinesscopee

// Запуск нескольких корутин

import kotlinx.coroutines.*

suspend fun main()= coroutineScope{

    launch{
        for(i in 0..5){
            delay(400L)
            println(i)
        }
    }
    launch{
        for(i in 6..10){
            delay(400L)
            println(i)
        }
    }

    // Вложенные корутины
    launch{
        println("Outer coroutine")
        launch{
            println("Inner coroutine")
            delay(400L)
        }
    }

    println("Hello Coroutines")
}