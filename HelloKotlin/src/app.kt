/*
    многострочный комментарий
    Функция main -
    точка входа в программу
*/
fun main(){ // начало функции main
    println("Привет, Kotlin!")

    println("Kotlin on Metanit.com")
    println("Hello Kotlin")
    println("Kotlin is a fun")

    // если инструкции располагаются на одной строке, то чтобы их отделить друг от друга,
    // надо указывать после инструкции точку с запятой:
    println("Kotlin on Metanit.com");println("Hello Kotlin");println("Kotlin is a fun")


    // Формальное определение переменной:
    // val|var имя_переменной: тип_переменной

    //  val определяется неизменяемая переменная (immutable variable).
    val age: Int
    age = 23        // здесь норм - первое присвоение
    // age = 56        // здесь ошибка - переопределить значение переменной нельзя
    println(age)

    var age2: Int
    age2 = 23
    println(age2)
    age2 = 56
    println(age2)


    val a0: Byte = -10
    val b0: Short = 45
    val c0: Int = -250
    val d0: Long = 30000
    println(a0) // -10
    println(b0) // 45
    println(c0) // -250
    println(d0) // 30000

    // Шестнадцатеричная запись числа начинается с 0x, затем идет набор символов от 0 до F, которые представляют число:
    val address: Int = 0x0A1    // 161
    println(address) // 161

    // Двоичная запись числа предваряется символами 0b, после которых идет последовательность из нулей и единиц:
    val a2: Int = 0b0101    // 5
    val b2: Int = 0b1011     // 11
    println(a2)      // 5
    println(b2)      // 11

    val height: Double = 1.78
    val pi: Float = 3.14F
    println(height)      // 1.78
    println(pi)         // 3.14

    val d2: Double = 23e3
    println(d2)      // 23 000

    val g: Double = 23e-3
    println(g)      // 0.023

    val a3: Boolean = true
    val b3: Boolean = false

    val a4: Char = 'A'
    val b4: Char = 'B'
    val c4: Char = 'T'

    val name: String = "Eugene"
    println(name)

    val text: String = """
                        SALT II was a series of talks between United States
                        and Soviet negotiators from 1972 to 1979.
                        It was a continuation of the SALT I talks.
                    """
    println(text)


    val firstName = "Tom"
    val lastName = "Smith"
    val welcome = "Hello, $firstName $lastName"
    println(welcome)    // Hello, Tom Smith

    val name3 = "Tom"
    val age3 = 22
    val userInfo = "Your name: $name3  Your age: $age3"

    val sum1 = 45L
    val sum2 = 45U

    // Однако в Kotlin также есть тип Any, который позволяет присвоить переменной данного типа любое значение:
    var name5: Any = "Tom"
    println(name5)   // Tom
    name5 = 6758
    println(name5)   // 6758


    // Ввод с консоли
    //Для ввода с консоли применяется встроенная функция readLine().
    // Она возвращает введенную строку. Стоит отметить, что результат этой функции всегда представляет объект типа String.
// Соответственно введеную строку мы можем передать в переменную типа String:
    //print("Введите имя: ")
    //val name6 = readLine()
    //println("Ваше имя: $name6")

    // inv: логическое отрицание или инверсия - инвертирует биты числа
    val b7 = 11  // 1011
    val c7 = b7.inv()
    println(c7)      // -12
}
