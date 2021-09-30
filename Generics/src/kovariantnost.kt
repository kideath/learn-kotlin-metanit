package kovariantnost

interface Messenger0<out T: Message>
open class Message(val text: String)
class EmailMessage(text: String): Message(text)

// В данном случае интерфейс Messenger является ковариантным, так как его параметр определен со словом out: interface
// Messenger<out T>. И теперь переменной типа Messenger<Message> мы можем присвоить значение типа Messenger<EmailMessage>
fun changeMessengerToEmail0(obj: Messenger0<EmailMessage>){
    val messenger: Messenger0<Message> = obj
}

// не случайно используется именно слово out. Оно указывает, что обобщенный тип может возвращать из функции значение типа T:

fun main() {

    val messenger: Messenger<Message> = EmailMessenger()
    val message = messenger.writeMessage("Hello Kotlin")
    println(message.text)    // Email: Hello Kotlin
}
//open class Message(val text: String)
//class EmailMessage(text: String): Message(text)

interface Messenger<out T: Message>{
    fun writeMessage(text: String): T
}
class EmailMessenger(): Messenger<EmailMessage>{
    override fun writeMessage(text: String): EmailMessage {
        return EmailMessage("Email: $text")
    }
}