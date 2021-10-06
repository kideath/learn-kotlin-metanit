package coroutiness

import kotlinx.coroutines.*

//suspend fun main() = coroutineScope{
//    launch{
//        for(i in 0..5){
//            delay(400L)
//            println(i)
//        }
//    }
//
//    println("Hello Coroutines")
//}

suspend fun main()= coroutineScope{
    launch{ doWork() }

    println("Hello Coroutines")
}
suspend fun doWork(){
    for(i in 0..5){
        println(i)
        delay(400L)
    }
}
