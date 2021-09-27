package data

data class Person(val name: String, val age: Int)
class Person1(val name: String, val age: Int)

data class Person2(val name: String, val age: Int){
    override fun toString(): String {
        return "Name: $name  Age: $age"
    }
}

fun main() {
    val alice1: Person1 = Person1("Alice", 24)
    println(alice1.toString())

    val alice: Person = Person("Alice", 24)
    println(alice.toString())

    val alice2: Person2 = Person2("Alice", 24)
    val kate2 = alice2.copy(name = "Kate")
    println(alice2.toString())   // Person(name=Alice, age=24)
    println(kate2.toString())    // Person(name=Kate, age=24)

    // Декомпозиция data-классов
    val alice3: Person = Person("Alice", 24)
    val (username, userage) = alice3
    println("Name: $username  Age: $userage") // Name: Alice  Age: 24
}