var age: Int = 18
    set(value){
        println("Call setter")
        if((value>0) and (value <110))
            field = value
    }
    //get() = field
    get(){
        println("Call getter")
        return field
    }

fun main() {

    println(age)    // 18
    age = 45
    println(age)    // 45
    age = -345
    println(age)    // 45

    println(age)    // срабатывает get
    age = 45        // срабатывает set
    println(age)    // срабатывает get

    val tom = PersonGS("Tom", "Smith")
    println(tom.fullname)   // Tom Smith
    tom.lastname = "Simpson"
    println(tom.fullname)   // Tom Simpson
}

class PersonGS(var firstname: String, var lastname: String){

    val fullname: String
        get() = "$firstname $lastname"
}