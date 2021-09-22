// Переменное количество параметров. Vararg

fun printStrings(vararg strings: String){
    for(str in strings)
        println(str)
}
fun main() {

    printStrings("Tom", "Bob", "Sam")
    printStrings("Kotlin", "JavaScript", "Java", "C#", "C++")

    sum(1, 2, 3, 4, 5)
    sum(1, 2, 3, 4, 5, 6, 7, 8, 9)

    printUserGroup(3, "Tom", "Bob", "Alice")

    printUserGroup2("KT-091", "Tom", "Bob", "Alice", count=3)

    val nums = intArrayOf(1, 2, 3, 4)
    changeNumbers(*nums, koef=2)
}

// Другой пример - подсчет суммы неопределенного количества чисел:
fun sum(vararg numbers: Int){
    var result=0
    for(n in numbers)
        result += n
    println("Сумма чисел равна $result")
}

// Однако это необязательно, но если после vararg-параметра идут еще какие-нибудь параметры, то при вызове функции
// значения этим параметрам передаются через именованные аргументы:
fun printUserGroup(count:Int, vararg users: String){
    println("Count: $count")
    for(user in users)
        println(user)
}

fun printUserGroup2(group: String, vararg users: String, count:Int){
    println("Group: $group")
    println("Count: $count")
    for(user in users)
        println(user)
}

// Оператор * (spread operator) (не стоит путать со знаком умножения) позволяет передать параметру в качестве значения
// элементы из массива:
fun changeNumbers(vararg numbers: Int, koef: Int){
    for(number in numbers)
        println(number * koef)
}