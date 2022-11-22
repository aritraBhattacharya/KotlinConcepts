import com.sun.org.apache.xpath.internal.operations.Bool

class DataClassTest() {
    // 1. Data classes cannot be abstract, open, sealed, or inner. *****************
    // data sealed class A(val x:Int) ===> sealed not allowed
    // inner data class A(val x:Int) ===> inner not allowed
    // abstract data class A(val x:Int) ===> abstract not allowed

    // 2. data class Dataclasses() // ERROR : Data class must have at least one primary constructor parameter
    // 3. open data class MyDataClassA(val a:Int) ==> not possible, DATA CLASS CANT BE OPEN
    data class MyDataClassA(val a: Int)
    open class MyNormalClass(val normalParam: Boolean)

    // 4. data class MyDataClassB(val b:String, val temp:Int) : MyDataClassA(temp) // DATA class in by nature NOT OPEN, SO Cant BE INHERITED FROM OTHER DATA CLASS
    // 5.
    data class MyDataClassC(val c: String, val myBool: Boolean) :
        MyNormalClass(myBool) // DATA CLASS CAN INHERIT FROM OTHER CLASS


    // 6. Destructuring
    fun destructureCheck() {
        var myDataClassC = MyDataClassC("Abcd", true)
        val (name, status) = myDataClassC
        println(name)   //"Abcd"
        println(status)    //true
    }

    /* 7.
    The compiler automatically derives the following members from all properties declared in the primary constructor:
    equals()/hashCode() pair
    toString() of the form "User(name=John, age=42)"
    componentN() functions corresponding to the properties in their order of declaration.
    copy() function (see below).*/

// 8. Generated methods don't consider the parameters declared outside constructor and inside class body


    data class B(val j:Int){
        private var i: Int?=null // data class can have its own variables outside constructor but these are not consider in copy,hashcode,equals
        init {
            val i=2
        }
        fun dataMethod(){
            println(i)   // data class can have methods
        }
    }




}

