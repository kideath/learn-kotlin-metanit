package ext_function


fun main() {

    val hello: String = "hello world"
    println(hello.wordCount('l'))   // 3
    println(hello.wordCount('o'))   // 2
    println(4.square())                 // 16
    println(6.square())                 // 36
}

fun String.wordCount(c: Char) : Int{
    var count = 0
    for(n in this){
        if(n == c) count++
    }
    return count
}
fun Int.square(): Int{
    return this * this
}