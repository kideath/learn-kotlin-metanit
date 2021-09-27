package abstract

abstract class Human0(val name: String)

fun main() {
    val kate0: Human0     // норм, просто определение переменной
    //val alice: Human0 = Human0("Alice")   // ! ошибка, создать объект нельзя

    val kate: Person = Person("Kate")
    val slim: Human = Person("Slim Shady")
    kate.hello()    // My name is Kate
    slim.hello()    // My name is Slim Shady

}

abstract class Human(val name: String){

    fun hello(){
        println("My name is $name")
    }
}

class Person(name: String): Human(name)

// 2
abstract class Human2(val name: String){

    abstract var age: Int
    abstract fun hello()
}
class Person2(name: String): Human2(name){

    override var age : Int = 1
    override fun hello(){
        println("My name is $name")
    }
}


// абстрактный класс фигуры
abstract class Figure {
    // абстрактный метод для получения периметра
    abstract fun perimeter(): Float

    // абстрактный метод для получения площади
    abstract fun area(): Float
}
// производный класс прямоугольника
class Rectangle(val width: Float, val height: Float) : Figure()
{
    // переопределение получения периметра
    override fun perimeter(): Float{
        return width * 2 + height * 2;
    }
    // переопрелеление получения площади
    override fun area(): Float{
        return width * height;
    }
}


