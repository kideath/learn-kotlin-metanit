package change_types

fun main() {
    val s: String = "12"
    val d: Int = s.toInt()
    println(d)

    // Однако надо учитывать, что значение не всегда может быть преобразовано к определенному типу. И в этом случае
// генерируется исключение. Соответственно в таких случаях желательно отлавливать исключение:
    val s2: String = "tom"
    try {
        val d2: Int = s2.toInt()
        println(d2)
    }
    catch(e: Exception){
        println(e.message)
    }

    val tom = Person("Tom")
    val bob = Employee("Bob", "JetBrains")

    checkEmployment(tom)    // Tom does not have a job
    checkEmployment(bob)    // Bob works in JetBrains

    checkEmployment2(tom)    // Tom does not have a job
    checkEmployment2(bob)    // Bob works in JetBrains


    val hello: String? = "Hello Kotlin"
    val message: String = hello as String
    println(message)

    val hello2: String? = null
    val message2: String? = hello2 as? String
    println(message2)

    val s3: String? = "8"
    val d3: Int? = s3?.toInt() as? Int
    println(d3)

    try {
        val s4: String = "8"
        //val d4: Int = s4 as Int
        //println(d4)
    }
    catch (exx: Exception) {
        exx.printStackTrace()
    }

    checkCompany4(tom)
    checkCompany4(bob)


    println("THE END!")
}


fun checkEmployment(person: Person){
    // println("${person.name} works in ${person.company}")    // Ошибка - у Person нет свойства company

    // Причем даже если значение представляет тип Employee, то до применения оператора is оно тем не менее принадлежит
    // типу Person. И только применение оператора is преобразует значение из типа Person в тип Employee.
    if(person is Employee){
        println("${person.name} works in ${person.company}")
    }
    else{
        println("${person.name} does not have a job")
    }
}
open class Person(val name: String)
//class Employee(name: String, val company: String): Person(name)
open class Employee(name: String, val company: String): Person(name)
class Manager(name: String, company: String): Employee(name, company)

fun identifyPerson(person: Person){
    when(person){
        is Manager -> println("${person.name} is a manager")
        is Employee -> println("${person.name} is an employee")
        is Person -> println("${person.name} is just a person")
    }
}

// Также можно применять другую форму оператора - !is. Она возвращает true, если значение НЕ представляет указанный тип данных:
fun checkEmployment2(person: Person){
    // println("${person.name} works in ${person.company}")    // Ошибка - у Person нет свойства company
    if(person !is Employee){
        println("${person.name} does not have a job")
    }
    else{
        println("${person.name} works in ${person.company}")
    }
}

// Однако, что, если свойство company имеет пустую строку, например, val bob = Employee("Bob", ""), то есть фактически
// компания не указана. А мы хотим выводить компанию, если это свойство имеет какое-нибудь содержимое. В этом случае мы
// можем выполнить проверку на длину строку сразу же после применения оператора is:
fun checkEmployment3(person: Person){
    if(person is Employee && person.company.length > 0){
        println("${person.name} works in ${person.company}")
    }
    else{
        println("${person.name} does not have a job")
    }
}

fun checkCompany4(person: Person){
    val employee = person as? Employee
    if (employee!=null){
        println("${employee.name} works in ${employee.company}")
    }
    else{
        println("${person.name} is not an employee")
    }
}