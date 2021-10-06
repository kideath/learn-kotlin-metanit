package cancel


import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    val downloader: Job = launch{
        println("Начинаем загрузку файлов")
        for(i in 1..5){
            println("Загружен файл $i")
            delay(500L)
        }
    }
    delay(800L)     // установим задержку, чтобы несколько файлов загрузились
    println("Надоело ждать, пока все файлы загрузятся. Прерву-ка я загрузку...")
    //downloader.cancel()    // отменяем корутину
    //downloader.join()      // ожидаем завершения корутины

    downloader.cancelAndJoin()    // отменяем корутину и ожидаем ее завершения
    println("Работа программы завершена")




    val downloader2: Job = launch{
        try {
            println("Начинаем загрузку файлов")
            for(i in 1..5){
                println("Загружен файл $i")
                delay(500L)
            }
        }
        catch (e: CancellationException ){
            println("Загрузка файлов прервана")
        }
        finally{
            println("Загрузка завершена")
        }
    }
    delay(800L)
    println("Надоело ждать. Прерву-ка я загрузку...")
    downloader2.cancelAndJoin()    // отменяем корутину и ожидаем ее завершения
    println("Работа программы завершена")





    // создаем и запускаем корутину
    val message = async {
        getMessage()
    }
    // отмена корутины
    message.cancelAndJoin()

    try {
        // ожидаем получение результата
        println("message: ${message.await()}")
    }
    catch (e:CancellationException){
        println("Coroutine has been canceled")
    }
    println("Program has finished")

}


suspend fun getMessage() : String{
    delay(500L)
    return "Hello"
}