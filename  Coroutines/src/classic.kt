package classic

import kotlinx.coroutines.*

// И чтобы использовать внутри функции main функцию delay(), функция main предваряется модификатром suspend.
suspend fun main(){
    for(i in 0..5){
        delay(400L)
        println(i)
    }

    println("Hello Coroutines")
}