fun sum(x:Int, y:Int): Int{

    return x + y
}

fun hello2() : Unit{ // unit- аналог void
    println("Hello")
}

fun square(x: Int) = x * x
// 	fun square(x: Int) : Int = x * x

fun compareAge(age1: Int, age2: Int){

    fun ageIsValid(age: Int): Boolean{
        return age > 0 && age < 111
    }
    if( !ageIsValid(age1) || !ageIsValid(age2)) {
        println("Invalid age")
        return
    }

    when {
        age1 == age2 -> println("age1 == age2")
        age1 > age2 -> println("age1 > age2")
        age1 < age2 -> println("age1 < age2")
    }
}

//fun sum(a: Int, b: Int) : Int{
//    return a + b
//}
fun sum(a: Double, b: Double) : Double{
    return a + b
}
fun sum(a: Int, b: Int, c: Int) : Int{
    return a + b + c
}
fun sum(a: Int, b: Double) : Double{
    return a + b
}
fun sum(a: Double, b: Int) : Double{
    return a + b
}

fun main() {

    val a = sum(4, 3)
    val b = sum(5, 6)
    val c = sum(6, 9)
    println("a=$a  b=$b  c=$c")

    val d = hello2()
    val e = hello2()

    val a2 = square(5)   // 25
    val b2 = square(6)   // 36
    println("a=$a2  b=$b2")

    compareAge(20, 23)
    compareAge(-3, 20)
    compareAge(34, 134)
    compareAge(15, 8)

    val a3 = sum(1, 2)
    val b3 = sum(1.5, 2.5)
    val c3 = sum(1, 2, 3)
    val d3 = sum(2, 1.5)
    val e3 = sum(1.5, 2)
    println("a=$a3  b=$b3  c=$c3  d=$d3  e=$e3")
}