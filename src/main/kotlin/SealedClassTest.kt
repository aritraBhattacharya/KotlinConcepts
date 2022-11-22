sealed class Months {
    class January(var shortHand: String) : Months()
    class February(var number: Int) : Months()
    class March(var shortHand: String, var number: Int) : Months()
}

class April(var shortHand: String, var number: Int) : Months() // YOU CAN ONLY EXTEND IN THIS FILE OR INSIDE THE SEALED CLASS


fun main() {
    // val myMonth = Months.April // not available as an instance of Month************************
    val myMonth1 = April("wefwe", 2) // not available
    val myMonthJan = Months.January("sdufg")

    var result:Months?=null

    when(result){
        is Months.January-> TODO()
        is April -> TODO()
        is Months.February -> TODO()
        is Months.March -> TODO()
        null -> TODO()
    }

}