package nulll

import ext_function.square

fun main() {
    println(6.square())

    // Однако переменным стандартных типов, например, типа Int или String или любых других классов, мы не можем просто
    // взять и присвоить значение null:

    // val n : Int = null   // ! Ошибка, переменная типа Int допускает только числа
    //var s : String = null   // ! Ошибка,

    // val n : Int = null  //! ошибка, Int не допускает значение null
    val d : Int? = null // норм, Int? допускает значение null

    var age : Int? = null
    age = 34              // Int? допускает null и числа
    var name : String? = null
    name = "Tom"        // String? допускает null и строки

    // Nullable-типы могут представлять и создаваемые разработчиком классы:
    var bob: Person = Person("Bob")
    // bob = null // ! Ошибка - bob представляет тип Person и не допускает null
    var tom: Person? = Person("Tom")
    tom = null  // норм - tom представляет тип Person? и допускает null


    // В то же время надо понимать, что String? и Int? - это не то же самое, что и String и Int. Nullable типы имеют ряд ограничений:
    //Значения nullable-типов нельзя присвоить напрямую переменным, которые не допускают значения null
    var message : String? = "Hello"
    //val hello: String = message     // ! Ошибка - hello не допускает значение null

    // У объектов nullable-типов нельзя вызвать напрямую те же функции и свойства, которые есть у обычных типов
    //var message : String? = "Hello"
// у типа String свойство length возвращает длину строки
    //println("Message length: ${message.length}")    // ! Ошибка

    var name2 : String?  = "Tom"
    val userName2: String = name2 ?: "Undefined"  // если name = null, то присваивается "Undefined"

    var age2: Int? = 23
    val userAge2: Int = age2 ?:0  // если age равно null, то присваивается число

    //То есть это все равно, если бы мы написали:
    var name3 : String?  = "Tom"
    val userName3: String
    if(name3!=null){
        userName3 = name3
    }

    var message4 : String? = null //"Hello"
    val length4: Int? = message4?.length
    println("len4 = ${length4}") // null
    val length5: Int = message4?.length ?:0
    println("len5 = ${length5}") // 0

    // Если переменная message вдруг равна null, то переменная length получит значение null. Если переменная name содержит
// строку, то возвращается длина этой строки. По сути выражение val length: Int? = message?.length эквивалентно следующему коду:
    var message41 : String? = "Hello"
    val length41: Int?
    if(message41 != null)
        length41 = message41.length
    else
        length41 = null


    var tom2: Person2? = Person2("Tom")
    val tomName: String? = tom?.name?.uppercase()
    println(tomName)        // TOM

    var bob2: Person2? = null
    val bobName: String? = bob2?.name?.uppercase()
    println(bobName)        // null

    var sam2: Person2? = Person2(null)
    val samName: String? = sam2?.name?.uppercase()
    println(samName)        // null


    try {
        val name : String?  = null //"Tom"
        val id: String = name!!
        println(id)
    } catch (e: Exception) { println("error" + e.message)}

    // Поскольку данный оператор возвращает объект, который не представляет nullable-тип,
// то после применения оператора мы можем обратиться к методам и свойствам этого объекта:
    val name6 : String?  = null
    val length6 :Int = name6!!.length
    println(length6)

}

class Person(val name: String)

class Person2(val name: String?)