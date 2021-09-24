package base

private val privateVal = 3
val publicVal = 5

private class PrivateClass(val name: String)
class PublicClass(val name:String)

private fun privateFun(){
    println("privateFn")
    println(privateVal)
    val privateClass= PrivateClass("Tom")
}

fun publicFun(){
    println("publicFn")
    println(privateVal)
    val privateClass= PrivateClass("Tom")
}