fun main() {

    val message: () -> Unit
    message = ::hello4 // Чтобы передать функцию, перед названием функции ставится оператор ::
    message() // message имеет тип () -> Unit

    // operation указывает на функцию sum
    var operation: (Int, Int) -> Int = ::sum4
    val result = operation(3, 5)
    println(result) // 8

    // operation указывает на функцию subtract
    operation = ::subtract
    val result2 = operation(14, 5)
    println(result2) // 9
}

fun hello4(){
    println("Hello Kotlin")
}

fun sum4(a: Int, b: Int): Int{
    return a + b
}

fun subtract(a: Int, b: Int): Int{
    return a - b
}