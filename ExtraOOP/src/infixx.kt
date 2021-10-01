package infixx

fun main() {

    val acc = Account(1000)
    acc put 150
    acc put2 150
    // равноценно вызову
    acc.put(150)
    acc.printSum()  // 1300

    val hello = "hello world"
    val lCount = hello wordCount 'l'
    val oCount = hello wordCount 'o'
    println(lCount)   // 3
    println(oCount)   // 2
}
class Account(var sum: Int) {

    infix fun put(amount: Int){
        sum = sum + amount
    }
    fun printSum() = println(sum)
}

// в виде функции расширения:
infix fun Account.put2(amount: Int){
    this.sum = this.sum + amount
}

infix fun String.wordCount(c: Char) : Int{
    var count = 0
    for(n in this){
        if(n == c) count++
    }
    return count
}