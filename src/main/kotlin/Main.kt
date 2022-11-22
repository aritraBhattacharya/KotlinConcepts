
    fun main(args: Array<String>) {
//        val listInts = listOf<Int>(1,1,1)
//        Test().findNumberOfMatch(listInts,5)

        FunctionsAndLambdas().outerFun()
        val d:String ="D"
        when(d){
            "a".lowercase()-> println("a")
            "D".lowercase()-> println("a")
            "D"+"A"-> println("ad")
            "D"-> println("D got")
            else->println("else")
        }

        "aba".checkPalindrome()

}