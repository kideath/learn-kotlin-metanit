package visibility;

class Person(){

    public var name = "Undefined"
    public var age = 18

    public fun printPerson(){
        println("Name: $name  Age: $age")
    }
}

open class PersonPrivate(private val name:String, _age: Int){

    private val age = _age

    fun printPerson(){
        printName()
        printAge()
    }

    protected fun printPersonProtected(){
        printName()
        printAge()
    }

    private fun printName(){
        println("Name: $name")
    }
    private fun printAge(){
        println("Age: $age")
    }
}

class Employee(name:String, age: Int) : PersonPrivate(name, age){

    fun printEmployee(){
        //println("Employee $name. Full information:")
        printPersonProtected()
        // printName() // нельзя - printName - private
        // println("Age: $age")    // нельзя age - private
    }
}

fun main() {

    val tom = PersonPrivate("Tom", 37)
    tom.printPerson()

    // println(tom.name)   // Ошибка! - свойство name - private
    // tom.printAge()  // Ошибка! - функция printAge - private
}