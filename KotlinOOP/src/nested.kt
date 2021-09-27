package nested

class Person{
    class Account(val username: String, val password: String){

        fun showDetails(){
            println("UserName: $username  Password: $password")
        }
    }
}

fun main() {

    val userAcc = Person.Account("qwerty", "123456");
    userAcc.showDetails()

    val tom = PersonPrivate("qwertyZ", "123456");
    tom.showAccountDetails()

    val acc = BankAccount(3400)
    acc.Transaction().pay(2500)
}

// Если необходимо ограничить область применения вложенного класса только внешним классом, то следует определить вложенный
// класс с модификатором private:

class PersonPrivate(username: String, passwrd: String){

    private val account: Account = Account(username, passwrd)

    private class Account(val username: String, val passwrd: String)

    fun showAccountDetails(){
        //println("UserName: ${account.username}  Password: $account.passwrd")
        println("UserName: ${account.username}  Password: ${account.passwrd}")
    }
}

interface SomeInterface {
    class NestedClass
    interface NestedInterface
}

class SomeClass {
    class NestedClass
    interface NestedInterface
}

class BankAccountERROR(private var sum: Int){

    fun display(){
        println("sum = $sum")
    }

    class Transaction{
        fun pay(s: Int){
            //sum -= s // error
            //display() // error
        }
    }
}



class BankAccount(private var sum: Int){

    fun display(){
        println("sum = $sum")
    }

    inner class Transaction{
        fun pay(s: Int){
            sum -= s
            display()
        }
    }
}



class A{
    private val n: Int = 1
    inner class B{
        private val n: Int = 1
        fun action(){
            println(n)          // n из класса B
            println(this.n)     // n из класса B
            println(this@B.n)   // n из класса B
            println(this@A.n)   // n из класса A
        }
    }
}