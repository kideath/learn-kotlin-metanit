package kontravariantnost

fun main() {

    val messenger: Messenger<EmailMessage> = InstantMessenger() // InstantMessenger - это Messenger<Message>

    val message = EmailMessage("Hi Kotlin")
    messenger.sendMessage(message)
}
open class Message(val text: String)
class EmailMessage(text: String): Message(text)

interface Messenger<in T: Message>{
    //fun writeMessage(text: String): T
    fun sendMessage(message: T)
}

class InstantMessenger(): Messenger<Message>{
    override fun sendMessage(message: Message){
        println("Send message: ${message.text}")
    }
}