package sett


fun main() {
    // Для создания неизменяемого (immutable) набора используется функция setOf().
    var numbers: Set<Int> = setOf(5, 6, 7)

    val items = setOf(1, 2, 3, 4, 5)
    println(items.size)          // 5
    println(items.contains(4))  // true
    println(items.isEmpty())    // false
    println(items.minus(3))     // [1, 2, 4, 5]
    println(items.plus(7))      //  [1, 2, 3, 4, 5, 7]

    for (n in items){ print(n) }    // 1 2 3 4 5

    // Для создания изменяемых (mutable) наборов применяется функция mutableSetOf()
    val numbers_m: MutableSet<Int> = mutableSetOf(35, 36, 37)

    val numbers1m: HashSet<Int> = hashSetOf(5, 6, 7)
    val numbers2m: LinkedHashSet<Int> = linkedSetOf(25, 26, 27)
    val numbers3m: MutableSet<Int> = mutableSetOf(35, 36, 37)

    val numbersmm: MutableSet<Int> = mutableSetOf(35, 36, 37)
    println(numbersmm.add(2))
    println(numbersmm.addAll(setOf(4, 5, 6)))
    println(numbersmm.remove(36))

    for (n in numbersmm){ print("${n}, ") }    // 35 37 2 4 5 6
    numbersmm.clear()

    println(numbers2m.add(2))
    println(numbers2m.add(2))
    println(numbers2m.add(2))
    for (n in numbers2m){ print("${n}, ") }
    //numbers2m.clear()

    val linkedHashSet: MutableSet<String> = LinkedHashSet()

    linkedHashSet.add("Бета")
    linkedHashSet.add("Aльфa")
    linkedHashSet.add("Этa")
    linkedHashSet.add("Гaммa")
    linkedHashSet.add("Эпсилон")
    linkedHashSet.add("Oмeгa")
    println()
    println(linkedHashSet)

    val hashSet: MutableSet<String> = HashSet()

    hashSet.add("Бета")
    hashSet.add("Aльфa")
    hashSet.add("Этa")
    hashSet.add("Гaммa")
    hashSet.add("Эпсилон")
    hashSet.add("Oмeгa")

    println(hashSet)
}