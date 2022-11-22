
const val someConstant = "2"
//const var someConstant3 = "2" // Modifier 'const' is not applicable to 'vars'
class BasicsDemo {
    //const val someConstant2 = "2" // Not allowed here : Const 'val' are only allowed on top level, in named objects, or in companion objects

    //lateinit var retrofitInstance: Int // Not allowed for primitives
    lateinit var myLateInitString: String

    var t: Int = 0
        get() {return field}
        private set(value) {field =value}

    val myValue:Int by lazy { 2 }


    fun check(){
        // to check if lateinit is initialized
        this::myLateInitString.isInitialized
    }
}



// pending
//
// getter setter with custom modifier
// :: : etc
//
// loops and conditions statement

