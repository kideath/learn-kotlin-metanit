
//fun имя_функции (параметры) : возвращаемый_тип{
//    выполняемые инструкции
//}

fun main() {
    println("Remember me!")

    hello() // вызов функции hello
    hello() // вызов функции hello
    hello() // вызов функции hello

    showMessage("Hello Kotlin")
    showMessage("Привет Kotlin")
    showMessage("Salut Kotlin")

    displayUser("Tom", 23, "Manager")
    displayUser("Alice", 19)
    displayUser("Kate", 25)
    displayUser("Kate")
    displayUser("Kate", position = "manager")

    displayUser("Tom", position="Manager", age=28)
    displayUser(age=21, name="Alice")
    displayUser("Kate", position="Middle Developer")

    displayUser2(name="Tom", age=28)
    displayUser2(name="Kate")
    displayUser2(33, "George")

    var nums = intArrayOf(4, 5, 6)
    double(nums)
    println("Значение в функции main: ${nums[0]}")
}

// определение функции hello
fun hello(){
    println("Hello")
}

fun showMessage(message: String){
    println(message)
}

//fun displayUser(name: String, age: Int){
//    println("Name: $name   Age: $age")
//}

fun displayUser(name: String, age: Int = 18, position: String="unemployed"){
    println("Name: $name   Age: $age  Position: $position")
}

// Также если до обязательного параметра функции идут необязательные параметры, то для обязательного параметра значение
// передается по имени:
fun displayUser2(age: Int = 18, name: String){
    println("Name: $name   Age: $age")
}

fun doubleError(n: Int){
    //n = n * 2   // !Ошибка - значение параметра нельзя изменить
    println("Значение в функции double: $n")
}

fun double(numbers: IntArray){
    numbers[0] = numbers[0] * 2
    println("Значение в функции double: ${numbers[0]}")
}
