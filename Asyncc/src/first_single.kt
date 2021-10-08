package single

import kotlinx.coroutines.flow.*

suspend fun main(){

    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()
    val firstUser = userFlow.first()
    println("First User: $firstUser")       // First User: Tom

    val firstUser2 = userFlow.first{ name-> name.length > 3}
    println("First User: $firstUser2")       // First User: Kate

    val userFlow3 = listOf<String>().asFlow()
    // val firstUser3 = userFlow3.first() // exception

    // В обоих случаях при работе программы вылетит исключение. В этом случае мы, конечно, может обрабатывать исключение
// с помощью try..catch. Однако, в качестве альтернативы Kotlin предоставляет метод firstOrNull(), который возвращает null,
// если поток пуст или ни один из его элементов не соответствуют условию:
    val firstUser13 = userFlow3.firstOrNull()
    val firstUser23 = userFlow3.firstOrNull{ name-> name.length > 3}

    if(firstUser13 == null)
        println("User not found")
    else
        println("First User: $firstUser13")

    val lastUser = userFlow.last()
    println("Last User: $lastUser")       // Last User: Sam

    // single / singleOrNull
    //Функция single() возвращает единственный элемент потока, если поток содержит только один элемент.
// Если поток не содержит элементов генерируется исключение NoSuchElementException, а если в потоке больше
// одного элемента - исключение IllegalStateException.
    val userFlow4 = listOf("Tom").asFlow()
    try {
        val singleUser4 = userFlow4.single()
        println("Single User: $singleUser4")
    }
    catch(e:Exception) { println(e.message)  }

    // В качестве альтернативы можно использовать метод singleOrNull(), который возвращает null,
// если поток пуст или если в потоке больше одного элемента.
    val userFlow5 = listOf("Tom", "Bob").asFlow()
    val singleUser = userFlow5.singleOrNull()
    if(singleUser!=null)
        println("Single User: $singleUser")
    else
        println("Not found")

}