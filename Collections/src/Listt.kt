package listt

fun main() {
    // Для создания объекта List применяется метод listOf():
    var numbers1 = listOf(1, 2, 3, 4, 5, null)
    var numbers2: List<Int> = listOf(5, 6, 7)

    val numbers : List<Int> = listOf(1, 2, 3, 4, 5)

    // перебор списка
    for (n in numbers){
        print(n)
    }
    println()

    println(numbers.get(1))         // 2
    println(numbers.indexOf(2))     // 1
    println(numbers.lastIndexOf(3)) // 2
    println(numbers.first())        // 1
    println(numbers.last())         // 5
    println(numbers.size)           //5
    println(numbers.contains(4))    // true
    println(numbers.elementAt(1))   // 2
    println(numbers.elementAtOrNull(9))  // null

    var numbers_mute : ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5)
    var numbers2_mute: MutableList<Int> = mutableListOf(5, 6, 7)

    val numbers1m : ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5)
    numbers1m.add(4)
    numbers1m.clear()

    val numbers2m: MutableList<Int> = mutableListOf(5, 6, 7)

    numbers2m.add(12)
    numbers2m.add(0, 23)
    numbers2m.addAll(0, listOf(-3, -2, -1))
    numbers2m.removeAt(0)
    numbers2m.remove(5)

    for (n in numbers2m){ print("${n}, ") }
    println()
}