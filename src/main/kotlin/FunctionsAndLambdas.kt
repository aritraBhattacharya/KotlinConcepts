import com.sun.org.apache.xpath.internal.operations.Bool

class FunctionsAndLambdas {

    fun lam(a: Int, b: Int) = a + b


    //region -- LAMBDA-------------------------------------------
    private val sumLambda1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    private val sumLambda2 = { x: Int, y: Int -> x + y }

    val sumResult1 = sumLambda1(1, 1)
    val sumResult2 = sumLambda2(1, 1)

    private fun useLambdaInHigherOrder(s: String, lamFun: (Int, Int) -> Int) {
        println(s + lamFun(1, 2))
    }

    fun checkLambda() {
        useLambdaInHigherOrder("sum = ", sumLambda1)
        useLambdaInHigherOrder("sum = ", sumLambda2)
    }

    // endregion

    //region -- Anonymous function ------------------------------
    val annoSum = fun(x: Int, y: Int): Int = x + y
    fun checkAnonymousFun() {
        println(annoSum(2, 3))

        val d: String = "d"


    }

    //endregion

    //region -- Higher order fun --------------------------------

    //region EXAMPLE 1 using lambda fun
    val myLambdaFun = { a: Int, b: Int -> "returning from lambda: $a + $b = ${a + b}" }
    //OR val myLambdaFun: (Int,Int) -> String = {a:Int,b:Int -> "returning from lambda: $a + $b = ${a+b}"}

    fun myHigherOrderFun(a: Int, b: Int, myLambdaParam: (Int, Int) -> String) {
        myLambdaParam(a, b)
    }
    //endregion

    // region EXAMPLE 2 using normal fun

    //someFun: (value:String) -> Unit
    fun sayThis(message: String) {
        println(message)
    }

    // our higher order fun takes in a string and a functions such as : someFun: (value:String) -> Unit
    fun ourHigherOrderFun(message: String, someFun: (value: String) -> Unit) {
        someFun(message)
    }

    // now call our higher order fun like this

    fun checkHigherOrderFun() {
        ourHigherOrderFun("String input", this::sayThis)
    }


    //endregion

    //endregion

    //region -- Inline ------------------------------------------
    val myLambdaToBeInlined = { x: Int, y: Int -> x + y }
    fun myFunToBeInLined(x: Int, y: Int): Int {
        return x + y
    }

    // my higher order fun that inlines : myLambdaToBeInlined AND myFunToBeInLined
    inline fun inlineHigherOrderFun(x: Int, y: Int, funToBeInlined: (Int, Int) -> Int) {
        println("Result of inline fun: ${funToBeInlined(x, y)}")
    }

    fun callInlineHigherOrderFun() {
        inlineHigherOrderFun(2, 4, myLambdaToBeInlined)
        inlineHigherOrderFun(2, 4, this::myFunToBeInLined)
    }
    //endregion


    //region -- No inline ---------------------------------------


    val myLambdaToBeNoInlined: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    fun myFunToBeNoInLined(x: Int, y: Int): Int {
        return x + y
    }

    // my higher order fun that inlines : myLambdaToBeInlined AND myFunToBeInLined
    inline fun inlinedHigherOrderFun(x: Int, y: Int, funToBeInlined: (Int, Int) -> Int) {
        println("Result of inline fun: ${funToBeInlined(x, y)}")
    }

    fun checkNoInline() {
        inlinedHigherOrderFun(3, 6, myLambdaToBeNoInlined)
        inlinedHigherOrderFun(3, 6, this::myFunToBeNoInLined)
    }


    //endregion

    //region -- local functions ---------------------------------------

    fun outerFun() {
        println("start of outer fun")

        fun innerFun() {
            println("start of inner fun")
            println("end of inner fun")
            return  // =======================> Will only return from the inner fun, not the outer fun
        }
        innerFun()
        println("end of outer fun")

        /* call to outerFun will yield this result:
        * start of outer fun
        * start of inner fun
        * end of inner fun
        * end of outer fun*/
    }
    //endregion----------

    //region -- crossLine ---------------------------------------

    inline fun ourCrossInLineHigherOrderFun(
        x: Int,
        y: Int,
        sumLambdaFun: (Int, Int) -> Unit,
        crossinline minusLambdaFun: (Int, Int) -> Unit
    ) {
        println("starting of ourCrossInLineHigherOrderFun")
        sumLambdaFun(x, y)
        minusLambdaFun(x, y)
        println("end of ourCrossInLineHigherOrderFun")
    }

    fun checkCrossLine() {
        ourCrossInLineHigherOrderFun(
            9,
            6,
            sumLambdaFun = { m: Int, n: Int ->

                println("starting sumLambdaFun")
                println("sumLambdaFun --> ${m + n}")
                return  // ===========================> if we dont make sumLambdaFun crossline, then returning from this lambda will retrun from ourCrossInLineHigherOrderFun
                println("ending sumLambdaFun")
                // starting of ourCrossInLineHigherOrderFun
                // and the final result will be
                // starting sumLambdaFun / sumLambdaFun --> 15


            },
            minusLambdaFun = { m: Int, n: Int ->

                println("starting minusLambdaFun")
                println("minusLambdaFun --> ${m - n}")
                //return // ===========================> not allowed to return as we have marked minusLambdaFun as crossinline
                println("ending minusLambdaFun")
            }
        )
    }


    //endregion----------

    //region -- Infix --------------------------------
    class Warrior(var hp: Int, var ap: Int) {
        infix fun attack(anotherWarrior: Warrior) {
            anotherWarrior.hp -= ap
        }
    }

    fun attackTest() {
        val warrior1 = Warrior(100, 20)
        val warrior2 = Warrior(100, 15)

        warrior1 attack warrior2
        println("Warrior 2 HP : ${warrior2.hp}") // ====> Warrior 2 HP : 80
    }
    //endregion

    //region -- Kotlin closure --------------------------------
    var result =0

    val myClosureLambda = {x:Int,y:Int ->
        result = x+y} // here we can access the variable (result) defined outside lambda, and use that inside lambda. NOT Possible in JAVA
    //endregion

    //region -- Tail rec --------------------------------
    //endregion


}
//region -- Extension functions --------------------------------

fun String.checkPalindrome() {
    println("checkPalindrome==> ${this == this.reversed()}")
}
//endregion