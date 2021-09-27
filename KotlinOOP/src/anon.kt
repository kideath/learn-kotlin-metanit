fun main() {

    // Для определения анонимного объекта применяется ключевое слово object:
    val tom = object {
        val name = "Tom"
        var age = 37
        fun sayHello(){
            println("Hi, my name is $name")
        }
    }
    println("Name: ${tom.name}  Age: ${tom.age}")
    tom.sayHello()


    // Функция может возвращать анонимный объект:
    val tom2 = createPerson("Tom", "JetBrains")
    tom2.sayHello()
}


private fun createPerson(_name: String, _company: String) = object{
    val name = _name
    val company = _company
    fun sayHello() = println("Hi, my name is $name. I work in $company")
}