package enumss

enum class Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum class Day2(val value: Int){
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(100500)
}

enum class Day3(val value: Int){
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6),
    SUNDAY(7);
    fun getDuration(day: Day3): Int{
        return value - day.value;
    }
}

enum class DayTime{
    DAY{
        override val startHour = 6
        override val endHour = 21
        override fun printName(){
            println("День")
        }
    },
    NIGHT{
        override val startHour = 22
        override val endHour = 5
        override fun printName(){
            println("Ночь")
        }
    };
    abstract fun printName()
    abstract val startHour: Int
    abstract val endHour: Int
}

enum class Operation{

    ADD, SUBTRACT, MULTIPLY
}
fun operate(n1: Int, n2: Int, op: Operation): Int{

    when(op){
        Operation.ADD -> return n1 + n2
        Operation.SUBTRACT -> return n1 - n2
        Operation.MULTIPLY -> return n1 *n2
    }
}


fun main() {

    val day: Day = Day.FRIDAY
    println(day)            // FRIDAY
    println(Day.MONDAY)     // MONDAY

    val day2a: Day2 = Day2.FRIDAY
    println(day2a.value)        // 5
    println(Day2.MONDAY.value) // 1

    val day1: Day3 = Day3.FRIDAY
    val day2: Day3 = Day3.MONDAY
    println(day1.getDuration(day2))        // 4

    // props
    val day1a: Day2 = Day2.FRIDAY
    println(day1a.name)        // FRIDAY
    println(day1a.ordinal)     // 4

    for(day in Day.values())
        println(day)
    println(Day.valueOf("FRIDAY"))

    // anonym
    DayTime.DAY.printName()     // День
    DayTime.NIGHT.printName()   // Ночь
    println("Day from ${DayTime.DAY.startHour} to ${DayTime.DAY.endHour}")

    println(operate(5, 6, Operation.ADD))         // 11
    println(operate(5, 6, Operation.SUBTRACT))   // -1
    println(operate(5, 6, Operation.MULTIPLY))   // 30

}