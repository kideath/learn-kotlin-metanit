package constraints

//fun <T> getBiggestOld(a: T, b: T): T{
//    if(a > b) return a   // ! Ошибка
//    else return b
//}

fun main() {

    val result1 = getBiggest(1, 2)
    println(result1)
    val result2 = getBiggest("Tom", "Sam")
    println(result2)

    val email1 = EmailMessage("Hello Kotlin")
    send(email1)
    val sms1 = SmsMessage("Привет, ты спишь?")
    send(sms1)


    val result11 = getBiggestNums(1, 2)
    println(result11)    // 2

    val result21 = getBiggestNums(1.6, -2.8)
    println(result21)    // 1.6


    val email13 = EmailMessage3("Hello Kotlin")
    val outlook3 = Messenger3<EmailMessage3>()
    outlook3.send(email13)

    val skype3 = Messenger3<SmsMessage3>()
    val sms13 = SmsMessage3("Привет, ты спишь?")
    skype3.send(sms13)


}
// Стоит отметить, что по умолчанию ко всем параметрам типа также применяется ограничение в виде типа Any?.
// То есть определение параметра типа <T> фактически аналогично определению <T: Any?>
fun <T: Comparable<T>> getBiggest(a: T, b: T): T{
    return if(a > b) a
    else b
}

// Подобным образом мы можем использовать в качестве ограничений собственные типы. Например, нам надо определить
// функцию для условной отправки сообщения:
fun<T:Message> send(message: T){
    println(message.text)
}

interface Message{
    val text: String
}
class EmailMessage(override val text: String): Message
class SmsMessage(override val text: String): Message


// В примере выше мы могли передавать в функцию getBiggest() любой объект, который реализует интерфейс Comparable.
// Но что, если мы хотим, чтобы функция могла сравнивать только числа? Все числовые типы данных наследуются от базового
// класса Number. И мы можем задать еще одно ограничение - чтобы сравниваемый объект представлял тип Number:
// Если параметра типа надо установить несколько ограничений, то все они указываются после возвращаемого типа функции
// после слова where через запятую в форме:
fun <T> getBiggestNums(a: T, b: T): T where T: Comparable<T>,
                                        T: Number {
    return if(a > b) a
    else b
}


class Messenger3<T>() where T: Message3, T: Logger3{
    fun send(mes: T){
        mes.log()
    }
}
interface Message3{ val text: String }
interface Logger3{ fun log() }

class EmailMessage3(override val text: String): Message3, Logger3{
    override fun log() = println("Email: $text")
}
class SmsMessage3(override val text: String): Message3, Logger3{
    override fun log() = println("SMS: $text")
}