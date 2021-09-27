package delege

interface Base {
    fun someFun()
}

class BaseImpl() : Base {
    override fun someFun() { }
}

class Derived(someBase: Base) : Base by someBase




interface Messenger{
    fun send(message: String)
}
class InstantMessenger(val programName: String) : Messenger{

    override fun send(message: String){
        println("Message `$message` has been sent")
    }
}
class SmartPhone(val name: String, m: Messenger): Messenger by  m




interface Messenger2{
    fun send(message: String)
}
class InstantMessenger2(val programName: String) : Messenger2{
    override fun send(message: String) = println("Send message: `$message`")
}
interface PhotoDevice2{
    fun takePhoto()
}
class PhotoCamera2: PhotoDevice2{
    override fun takePhoto() = println("Take a photo")
}
class SmartPhone2(val name: String, m: Messenger2, p: PhotoDevice2)
    : Messenger2 by  m, PhotoDevice2 by p










fun main() {
    val telegram = InstantMessenger("Telegram")
    val pixel = SmartPhone("Pixel 5", telegram)
    pixel.send("Hello Kotlin")
    pixel.send("Learn Kotlin on Metanit.com")


    val telegram2 = InstantMessenger2("Telegram")
    val photoCamera2 = PhotoCamera2()
    val pixel2 = SmartPhone2("Pixel 5", telegram2, photoCamera2)
    pixel2.send("Hello Kotlin")
    pixel2.takePhoto()
}