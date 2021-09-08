fun logicNotEq() {
    val a = 11
    val b = 12
    val c = a != b      // true
    val d = b != 12     // false
}

fun logicOr() {
    val a = true
    val b = false
    val c = a or b                          // true
    val d = (11 < 5) or (9 > 10)     // false
    println(d)
}

fun logicNot() {
    val a = true
    val b = !a  // false
    val c = !b  // true

    val d = a.not()  // false
    val f = b.not()  // true
}

fun logicSequence() {
    // in: возвращает true, если операнд имеется в некоторой последовательности.
    val a = 5
    val b = a in 1..6       // true - число 5 входит в последовательность от 1 до 6

    val c = 4
    val d = c in 11..15     // false - число 4 НЕ входит в последовательность от 11 до 15
}

fun logicIf() {
    val a = 10
    if(a == 10) {
        println("a равно 10")
    }
    else if(a == 9){
        println("a равно 9")
    }
    else if(a == 8){
        println("a равно 8")
    }
    else{
        println("a имеет неопределенное значение")
    }
}

fun logicIfCode() {
    val a = 10
    val b = 20
    val c = if (a > b){
        println("a = $a")
        a
    } else {
        println("b = $b")
        b
    }


}

fun logicWhen() {
    val isEnabled = true
    when (isEnabled) {
        false -> println("isEnabled off")
        true -> println("isEnabled on")
    }

    var a = 30
    val b = 5
    when (a) {
        10 -> {
            println("a = 10")
            a *= 2
        }
        20 -> println("a = 20")
        // Можно определить одни и те же действия сразу для нескольких значений. В этом случае значения перечисляются через запятую
        30, 40 -> println("a = 30 или a = 40")
        in 21..29 -> println("a в диапазоне от 21 до 29")
        !in 11..19 -> println("a вне диапазона от 11 до 19")
        // Выражение в when также может сравниваться с динамически вычисляемыми значениями:
        b + 5 -> println("a = b + 5")
        else -> println("неопределенное значение")
    }

    when{
        (b > 10) -> println("b больше 10")
        (a > 10) -> println("a больше 10")
        else -> println("и a, и b меньше или равны 10")
    }

    val sum = 1000
    val rate = when(sum){
        in 100..999 -> 10
        in 1000..9999 -> 15
        else -> 20
    }
    println(rate)       // 15

}

fun logicFor() {
    println("logicFor()")
    for(n in 1..9){
        print("${n * n} \t")
    }
    println()

    for(i in 1..9){
        for(j in 1..9){
            print("${i * j} \t")
        }
        println()
    }

    var i = 10
    while(i > 0){
        println(i*i)
        i--;
    }

    i = -1
    do{
        println(i*i)
        i--;
    }
    while(i > 0)


    for(n in 1..8){
        if(n == 5) continue;
        println(n * n)
    }


}

fun testSequence() {
    val range11 = 1..5    // последовательность [1, 2, 3, 4, 5]
    val range21 =  "a".."d"
    println(range11)

    val range1 =  1..5      // 1 2 3 4 5
    val range2 =  5 downTo 1    // 5 4 3 2 1

    val range12 = 1..10 step 2           // 1 3 5 7 9
    val range22 = 10 downTo 1 step 3     // 10 7 4 1

    // Еще одна функция until позволяет не включать верхнюю границу в саму последовательность:
    val range13 = 1 until 9          // 1 2 3 4 5 6 7 8
    val range23 = 1 until 9 step 2   // 1 3 5 7
}

fun testArray() {
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val n = numbers[1]  // получаем второй элемент  n=2
    numbers[2] = 7      // переустанавливаем третий элемент
    println("numbers[2] = ${numbers[2]}") // numbers[2] = 7

    // Также инициализировать массив значениями можно следующим способом:
    val numbers5 = Array(3, {5}) // [5, 5, 5]
    println(numbers5.toString())

    var i = 1;
    val numbers2 = Array(3, { i++ * 2}) // [2, 4, 6]

    // перебор
    for(number in numbers){
        print("$number \t")
    }

    val people = arrayOf("Tom", "Sam", "Bob")
    for(person in people){
        print("$person \t")
    }

    i = 0
    while( i in people.indices){
        println(people[i])
        i++;
    }

    // Для упрощения создания массива в Kotlin определены дополнительные типы BooleanArray, ByteArray, ShortArray,
    // IntArray, LongArray, CharArray, FloatArray и DoubleArray,

    val numbers3: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val doubles3: DoubleArray = doubleArrayOf(2.4, 4.5, 1.2)

    val table: Array<Array<Int>> = Array(3, { Array(5, {0}) })
    // В данном случае двухмерный массив будет иметь три элемента - три строки.
    // /Каждая строка будет иметь по пять элементов, каждый из которых равен 0.

    val table2 = Array(3, { Array(3, {0}) })
    table2[0] = arrayOf(1, 2, 3)     // первая строка таблицы
    table2[1] = arrayOf(4, 5, 6)     // вторая строка таблицы
    table2[2] = arrayOf(7, 8, 9)     // третья строка таблицы

    val table3: Array<Array<Int>> = Array(3, { Array(3, {0}) })
    table3[0] = arrayOf(1, 2, 3)
    table3[1] = arrayOf(4, 5, 6)
    table3[2] = arrayOf(7, 8, 9)
    for(row in table3){

        for(cell in row){
            print("$cell \t")
        }
        println()
    }
}

fun main() {

    println("Azaza")
    //logicOr()
    logicIfCode()
    logicWhen()
    logicFor()
    testSequence()
    testArray()
}