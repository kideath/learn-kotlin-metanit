import email.Message
import email.send

fun main() {


    //val tom: Person
    val bob: Person
    val alice: Person

    // По умолчанию для класса компилятор генерирует пустой конструктор, который мы можем использовать:
    val tom0: Person = Person()

    val bob2: Person2 = Person2()  // создаем объект
    println(bob2.name)       // Undefined
    println(bob2.age)        // 18

    bob2.name = "Bob"
    bob2.age = 25

    println(bob2.name)       // Bob
    println(bob2.age)        // 25

    val tom = Person2()
    tom.name = "Tom"
    tom.age = 37

    tom.sayHello()
    tom.go("the shop")
    println(tom.personToString())

    val tom3 = Person3("Tom")
    val bob3 = Person3("Bob")
    val alice3 = Person3("Alice")

    println(tom3.name)   // Tom
    println(bob3.name)   // Bob
    println(alice3.name) // Alice

    // Первичный конструктор также может использоваться для определения свойств:
    val bob4: Person4 = Person4("Bob", 23)
    println("Name: ${bob4.name}  Age: ${bob4.age}")


    val tom5: Person5 = Person5("Tom")
    val bob5: Person5 = Person5("Bob", 45)
    println("Name: ${tom5.name}  Age: ${tom5.age}")
    println("Name: ${bob5.name}  Age: ${bob5.age}")

    send(Message("asd"), "addr")
}

// Если класс не имеет тела, то фигурные скобки можно опустить. Например, определим класс, который представляет человека:
class Person
// либо можно так
//class Person { }

class Person2 {
    var name: String = "Undefined"
    var age: Int = 18

    fun sayHello(){
        println("Hello, my name is $name")
    }

    fun go(location: String){
        println("$name goes to $location")
    }

    fun personToString() : String{
        return "Name: $name  Age: $age"
    }
}

class Person3(_name: String){
    val name: String
    init{
        name = _name
    }
}

class Person4(val name: String, var age: Int){
}

// Вторичные конструкторы
//Класс также может определять вторичные конструкторы. Они применяются в основном, чтобы определить дополнительные параметры,
// через которые можно передавать данные для инициализации объекта.
//
//Вторичные конструкторы определяются в теле класса. Если для класса определен первичный конструктор, то вторичный конструктор
// должен вызывать первичный с помощью ключевого слова this:
class Person5(_name: String){
    val name: String = _name
    var age: Int = 0

    constructor(_name: String, _age: Int) : this(_name){
        age = _age
    }
}