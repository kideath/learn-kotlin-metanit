package invariativnost

//Инвариантность предполагает, что, если у нас есть классы Base и Derived, где Derived - производный класс от Base,
// то класс C<Base> не является ни базовым классом для С<Derived>, ни производным. Например, у нас есть следующие типы:
interface Messenger<T: Message>

open class Message(val text: String)
class EmailMessage(text: String): Message(text)

// В данном случае мы не можем присвоить объект Messenger<EmailMessage> переменной типа Messenger<Message> и наоборот,
// они никак между собой не соотносятся, несмотря на то, что EmailMessage наследуется от Message:
fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    //val messenger: Messenger<Message> = obj   // ! Ошибка
}
fun changeMessengerToDefault(obj: Messenger<Message>){
    //val messenger: Messenger<EmailMessage> = obj      // ! Ошибка
}

// Мы можем присвоить переменным по умолчанию только объекты их типов:
fun changeMessengerToDefault2(obj: Messenger<Message>){
    val messenger: Messenger<Message> = obj
}
fun changeMessengerToEmail2(obj: Messenger<EmailMessage>){
    val messenger: Messenger<EmailMessage> = obj
}