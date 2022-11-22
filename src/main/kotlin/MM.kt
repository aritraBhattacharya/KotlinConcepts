import java.lang.StringBuilder

class MM {

    fun checkDuplicates(inputStr:String){
        val characterSet = HashSet<Char>()
        val strBuilder = StringBuilder()
        inputStr.forEach { ch->
            if(characterSet.contains(ch)){
                strBuilder.append("0")
            }
            else{
                strBuilder.append(ch)
                characterSet.add(ch)
            }

        }

        println(strBuilder)
    }

}

sealed class MySealedClas{
    class A: MySealedClas()
    class B: MySealedClas()
}

val myAdderLambda: (Int,Int)->Int = {x:Int,y:Int->x+y}

fun myHigherOrderFun(x:Int,y:Int,myLambda: (Int,Int)->Int){
    val res = myLambda(x,y)
    println(res)
}

enum class MyEnum{
    A,
    B
}

fun main(){
    tpe -->16(IO) -->
    MM().checkDuplicates("3435567733")
}