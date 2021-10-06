package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

suspend fun main() = coroutineScope{

    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            // отправляем данные через канал
            channel.send(n)
            delay(500L)
        }
    }

    // получаем данные из канала
    repeat(5) {
        val number = channel.receive()
        println(number)
    }
    println("End")


    val channel2 = Channel<String>()
    launch {
        val users = listOf("Tom", "Bob", "Sam")
        for (user in users) {
            println("Sending $user")
            channel2.send(user)
            delay(500L)
        }
    }

    repeat(3) {
        val user = channel2.receive()
        println("Received: $user")
    }
    println("End")


    val channel3 = Channel<String>()
    launch {
        val users = listOf("Tom", "Bob", "Sam")
        for (user in users) {
            channel3.send(user)  // Отправляем данные в канал
        }
        channel3.close()  // Закрытие канала
        println("Channel closed")
    }

    for(user in channel3) {  // Получаем данные из канала
        println(user)
    }
    println("End")

    val users = getUsers()
    users.consumeEach { user -> println(user) }
}


fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce{
    val users = listOf("Tom", "Bob", "Sam")
    for (user in users) {
        send(user)
    }
}