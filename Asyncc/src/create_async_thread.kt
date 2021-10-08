package create_async_thread

import kotlinx.coroutines.flow.*

suspend fun main(){

    val numberFlow = getNumbers()
    numberFlow.collect{n -> println(n)}

    // Определять поток в виде отдельной функции, как в примере выше, необязательно. Например:
    val userFlow = flow {
        val usersList = listOf("Tom", "Bob", "Sam")
        for (item in usersList){
            emit(item)
        }
    }
    userFlow.collect({user -> println(user)})


    // Специальная функция-строитель flowOf() создает поток из набора переданных в функцию значений.
    val numberFlow2 : Flow<Int> = flowOf(1, 2, 3, 5, 8)
    numberFlow2.collect{n -> println(n)}




    // преобразование последовательности в поток
    val numberFlow3 : Flow<Int> = (1..5).asFlow()
    numberFlow3.collect{n -> println(n)}

    // преобразование коллекции List<String> в поток
    val userFlow3 = listOf("Tom", "Sam", "Bob").asFlow()
    userFlow3.collect({user -> println(user)})
}

fun getNumbers() = flow{
    for(item in 1..5){
        emit(item * item)
    }
}

