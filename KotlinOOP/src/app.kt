import email.send as sendEmail
import email.Message as EmailMessage
import sms.send as sendSms
import sms.Message as SmsMessage

fun main() {

    val myEmailMessage = EmailMessage("Hello Kotlin")
    sendEmail(myEmailMessage, "tom@gmail.com")

    val mySmsMessage = SmsMessage("Hello Kotlin")
    sendSms(mySmsMessage, "+1234567890")

    val bob: Employee9 = Employee9()
    bob.name = "Bob"
    bob.printName()

    val bobb = EmployeeB("Bob")
    bobb.printName()

    val bobc = EmployeeC("Bob", "JetBrains")
    bobc.printName()
    bobc.printCompany()
}


// Наследование
open class Person8{
    var name: String = "Undefined"
    fun printName(){
        println(name)
    }
}
// Первый способ - после двоеточия сразу указать вызов конструктора базового класса:
class Employee8: Person8()

// Второй способ вызвать конструктор базового класса - определить в производном классе вторичный конструктор и в нем
// вызвать конструктор базового класса с помощью ключевого слова super:
class Employee9: Person8{
    constructor() : super(){
    }
}

// Наследование класса с первичным конструктором
open class PersonA(val name: String){
    fun printName(){
        println(name)
    }
}
class EmployeeA(empName: String): PersonA(empName)

// Если производный класс не имеет явного первичного конструктора, тогда при вызове вторичного конструктора должен
// вызываться конструктор базового класса через ключевое слово super:
class EmployeeB: PersonA{
    constructor(empName: String) : super(empName){}
}



// Расширение базового класса
open class PersonC(val name: String){
    fun printName(){
        println(name)
    }
}
class EmployeeC(empName: String, val company: String): PersonC(empName){

    fun printCompany(){
        println(company)
    }
}










