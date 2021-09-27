package override

open class Person0(val name: String){
    open var age: Int = 1
}

// Если свойство определяется через первичный конструктор, то также перед его определением ставится аннотация open:
open class Person(val name: String, open var age: Int = 1){
}

// В производном классе для переопределения свойства перед ним указывается аннотация override.
open class Employee(name: String): Person(name){
    override var age: Int = 18
}

// Также переопределить свойство можно сразу в первичном конструкторе:
open class Employee2(name: String, override var age: Int = 18): Person(name, age){}

// Применение:
fun main() {

    val tom = Person("Tom")
    println("Name: ${tom.name}  Age: ${tom.age}")

    val bob = Employee("Bob")
    println("Name: ${bob.name}  Age: ${bob.age}")

    // ----------------
    val tomg = PersonGetterSetter("Tom")
    tomg.age = 14
    println(tomg.fullInfo)

    val bobg = EmployeeGetterSetter("Bob")
    bobg.age = 14
    println(bobg.fullInfo)

    //----------------------
    val tomm = PersonMethod("Tom")
    tomm.display()       // Name: Tom

    val bobm = EmployeeMethod("Bob", "JetBrains")
    bobm.display()       // Name: Bob  Company: JetBrains
}


// Переопределение геттеров и сеттеров
open class PersonGetterSetter(val name: String){

    open val fullInfo: String
        get() = "Person $name - $age"

    open var age: Int = 1
        set(value){
            if(value > 0 && value < 110)
                field = value
        }
}
open class EmployeeGetterSetter(name: String): PersonGetterSetter(name){

    override val fullInfo: String
        get() = "Employee $name - $age"

    override var age: Int = 18
        set(value){
            if(value > 17 && value < 110)
                field = value
        }
}

open class PersonMethod(val name: String){
    open fun display(){
        println("Name: $name")
    }
}
class EmployeeMethod(name: String, val company: String): PersonMethod(name){

    override fun display() {
        println("Name: $name    Company: $company")
    }
}

// final
open class PersonFinal(val name: String){
    open fun display(){
        println("Name: $name")
    }
}
open class EmployeeFinal(name: String, val company: String): PersonFinal(name){

    final override fun display() {
        println("Name: $name    Company: $company")
    }
}
class ManagerFinal(name: String, company: String):EmployeeFinal(name, company){
    // теперь функцию нельзя переопределить
    /*override fun display() {
        println("Name: $name Company: $company  Position: Manager")
    }*/
}

// super
open class PersonSuper(val name: String){

    open val fullInfo: String
        get() = "Name: $name"

    open fun display(){
        println("Name: $name")
    }
}
open class EmployeeSuper(name: String, val company: String): PersonSuper(name){

    override val fullInfo: String
        get() = "${super.fullInfo} Company: $company"

    final override fun display() {
        super.display()
        println("Company: $company")
    }
}