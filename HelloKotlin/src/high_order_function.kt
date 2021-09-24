fun main() {

    displayMessage(::morning)
    displayMessage(::evening)

    action(5, 3, ::sum5)         // 8
    action(5, 3, ::multiply5)    // 15
    action(5, 3, ::subtract5)    // 2

    val action1 = selectAction(1)
    println(action1(8,5))    // 13

    val action2 = selectAction(2)
    println(action2(8,5))    // 3
}
fun displayMessage(mes: () -> Unit){
    mes()
}
fun morning(){
    println("Good Morning")
}
fun evening(){
    println("Good Evening")
}

fun action (n1: Int, n2: Int, op: (Int, Int)-> Int){
    val result = op(n1, n2)
    println(result)
}
fun sum5(a: Int, b: Int): Int{
    return a + b
}
fun subtract5(a: Int, b: Int): Int{
    return a - b
}
fun multiply5(a: Int, b: Int): Int{
    return a * b
}


fun selectAction(key: Int): (Int, Int) -> Int{
    // определение возвращаемого результата
    when(key){
        1 -> return ::sum5
        2 -> return ::subtract5
        3 -> return ::multiply5
        else -> return ::empty
    }
}
fun empty (a: Int, b: Int): Int{
    return 0
}