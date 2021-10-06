import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    val message: Deferred<String> = async{ getMessage()}
    println("message: ${message.await()}")
    println("Program has finished")

    val numDeferred1 = async{ sum(1, 2)}
    val numDeferred2 = async{ sum(3, 4)}
    val numDeferred3 = async{ sum(5, 6)}
    val num1 = numDeferred1.await()
    val num2 = numDeferred2.await()
    val num3 = numDeferred3.await()

    println("number1: $num1  number2: $num2  number3: $num3")

    // корутина создана, но не запущена
    val sum = async(start = CoroutineStart.LAZY){ sum(1, 2)}

    delay(1000L)
    println("Actions after the coroutine creation")
    println("sum: ${sum.await()}")   // запуск и выполнение корутины


    // корутина создана, но не запущена
    val sum2 = async(start = CoroutineStart.LAZY){ sum(1, 2)}

    delay(1000L)
    println("Actions after the coroutine creation")
    // Если необходимо, чтобы корутина еще до метода await() начала выполняться, то можно вызвать метод start():
    sum2.start()                      // запуск корутины
    println("sum: ${sum2.await()}")   // получаем результат
}
suspend fun getMessage() : String{
    delay(500L)  // имитация продолжительной работы
    return "Hello"
}


suspend fun sum(a: Int, b: Int) : Int{
    delay(500L) // имитация продолжительной работы
    return a + b
}