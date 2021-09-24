//fun(x: Int, y: Int): Int = x + y
//
//fun(x: Int, y: Int): Int{
//    return x + y
//}

fun main() {

    val message = fun()=println("Hello")
    message()

    val sum = fun(x: Int, y: Int): Int = x + y
    val result = sum(5, 4)
    println(result)     // 9

    // Анонимную функцию можно передавать в функцию, если параметр соответствует типу этой функции:
    doOperation(9,5, fun(x: Int, y: Int): Int = x + y )     // 14
    doOperation(9,5, fun(x: Int, y: Int): Int = x - y)      // 4

    val op = fun(x: Int, y: Int): Int = x * y
    doOperation(9, 5, op)       // 45

    val action1 = selectAction6(1)
    val result1 = action1(4, 5)
    println(result1)        // 9

    val action2 = selectAction6(3)
    val result2 = action2(4, 5)
    println(result2)        // 20

    val action3 = selectAction6(9)
    val result3 = action3(4, 5)
    println(result3)        // 0
}

fun doOperation(x: Int, y: Int, op: (Int, Int) ->Int){

    val result = op(x, y)
    println(result)
}

fun selectAction6(key: Int): (Int, Int) -> Int{
    // определение возвращаемого результата
    when(key){
        1 -> return fun(x: Int, y: Int): Int = x + y
        2 -> return fun(x: Int, y: Int): Int = x - y
        3 -> return fun(x: Int, y: Int): Int = x * y
        else -> return fun(x: Int, y: Int): Int = 0
    }
}