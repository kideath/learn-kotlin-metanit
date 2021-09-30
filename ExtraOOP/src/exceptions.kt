package exceptions

fun main() {

    try{
        val x : Int = 0
        val z : Int = 0 / x
        println("z = $z")
    }
    catch(e: Exception){
        println("Exception")
        println(e.message)

        for(line in e.stackTrace) {
            println("at $line")
        }
    }
    finally{
        println("Program has been finished")
    }


    try {
        val nums = arrayOf(1, 2, 3, 4)
        println(nums[6])
    }
    catch(e:ArrayIndexOutOfBoundsException){
        println("Out of bound of array")
    }
    catch (e: Exception){
        println(e.message)
    }


    //val checkedAge1 = checkAge(5)
    //val checkedAge2 = checkAge(-115)

    try {
        val checkedAge1 = checkAge(5)
        val checkedAge2 = checkAge(-115)
    }
    catch (e: Exception){
        println(e.message)
    }

    // Возвращение значения
    //Конструкция try может возвращать значение. Например:
    val checkedAge1 = try { checkAge(5) } catch (e: Exception) { null }
    val checkedAge2 = try { checkAge(-125) } catch (e: Exception) { null }
    println(checkedAge1)    // 5
    println(checkedAge2)    // null

    val checkedAge3 = try { checkAge(-125) } catch (e: Exception) { println(e.message); 18 }
    println(checkedAge3)
}

fun checkAge(age: Int): Int{
    if(age < 1 || age > 110) throw  Exception("Invalid value $age. Age must be greater than 0 and less than 110")
    println("Age $age is valid")
    return age
}