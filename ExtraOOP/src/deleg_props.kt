package deleg_props
// После типа данных свойства идет ключевое слово by, после которого указывается выражение.
// Выражение представляет класс, который условно называется делегатом. Делегаты свойств могут не применять никаких интерфейсов,
// однако они должны предоставлять функции getValue() и setValue(). А выполнение методов доступа get() и set(),
// которые есть у свойства, делегируется функциям getValue() и setValue() класса делегата.

import kotlin.reflect.KProperty

fun main() {

    val tom = Person()
    println(tom.name)   // Tom

    val bob = Person()
    println(bob.name)   // Tom

    // case 2
    val tom2 = Person2("Tom")
    println(tom2.name)

    val bob2 = Person2("Bob")
    println(bob2.name)



    //Изменяемые свойства
    val tom3 = Person3("Tom", 37)
    println(tom3.age)    //37
    tom3.age = 38
    println(tom3.age)    //38
    tom3.age = -139
    println(tom3.age)    //38
}
class Person{
    val name: String by LoggerDelegate()
}

class LoggerDelegate {
    operator fun getValue(thisRef: Person, property: KProperty<*>): String {
        println("Запрошено свойство: ${property.name} - ${property.returnType}")
        return "Tom"
    }
}


// Теперь первичный конструктор Person принимает устанавливаемое значение для свойства name.
// Далее оно передается в конструктор классу LoggerDelegate, который использует его для логгирования на консоль.
// И в конце возвращает его в качестве значения свойства name.
class Person2(_name: String){
    val name: String by LoggerDelegate2(_name)
}
class LoggerDelegate2(val personName: String) {
    operator fun getValue(thisRef: Person2, property: KProperty<*>): String {
        println("Запрошено свойство ${property.name}")
        println("Устанавливаемое значение: $personName")
        return personName
    }
}



// Изменяемые свойства
class Person3(val name: String, _age: Int){
    var age: Int by LoggerDelegate3(_age)
}
class LoggerDelegate3(private var personAge: Int) {
    operator fun getValue(thisRef: Person3, property: KProperty<*>): Int{
        return personAge
    }
    operator fun setValue(thisRef: Person3, property: KProperty<*>, value: Int){
        println("Устанавливаемое значение: $value")
        if(value > 0 && value < 110) personAge = value
    }
}