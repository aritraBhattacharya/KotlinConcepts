//class GenericsInOut {
//
//
//    //region Reified
//    fun <T> genericFun(a:T){
//        println(T::class.java) // you cant get class info from Generic type
//    }
//
//    fun <reified T> genericFunReified(a:T){
//        println(T::class.java) // Reified only works with inline fun as compiler needs to modify the fun when copying
//    }
//
//    inline fun <reified T> genericFunReifiedAndInlined(a:T){
//        println(T::class.java) // Reified only works with inline fun as compiler needs to modify the fun when copying
//    }
//
//    // funcs with reified cant be called from java
//
//    //endregion
//
//
//    //region Type Erasure
//
//    // These two funs have same JVM signature
//    //Platform declaration clash: The following declarations have the same JVM signature (bar(Ljava/util/List;)Ljava/lang/String;):
//    //public final fun bar(foo: List<Int>): String defined in GenericsInOut
//    //public final fun bar(foo: List<String>): String defined in GenericsInOut
//
//    //THIS IS CALLED TYPE ERASURE
//    fun bar(foo: List<String>): String {
//        return ""
//    }
//
//    fun bar(foo: List<Int>): String {
//        return "2";
//    }
//
//    // to solve this use @JVMNAME
//
//    @JvmName(name = "barString")fun bar(foo: List<String>): String {
//        return ""
//    }
//
//    @JvmName(name = "barInt")fun bar(foo: List<Int>): String {
//        return "2"}
//
//
//
//    //endregion
//
//    class GenericDemoClass <I,O,N>(val inPositon: I, val outPositon: O,val normalPositon: N){
//
//
//
//    }
//
//    class Box<out T>(val t:T) {
//        init {
//            val a =t
//        }
//        fun takein(t1:T){ //=========> Not allowed in IN position
//
//        }
//        fun giveOut():T{ //=========> Only allowed in Out position
//            return this.t
//        }
//    }
//
//    open class A
//    class B : A()
//    class C : A()
//    class D : A()
//
//    class GenericDemoCovariant<out T:A>{}
//    class GenericDemoContravariant<in T:A>{}
//    class GenericDemoInvariant<T>{}
//    fun Testing(){
//
//        var invariant = GenericDemoInvariant<A>()
//        invariant = GenericDemoInvariant<B>()  // even though B is sub class of A, GenericDemoInvariant<B> is not a subtype of GenericDemoInvariant<A>
//
//
//
//    }
//
//}