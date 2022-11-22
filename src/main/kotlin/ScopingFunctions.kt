class ScopingFunctions {


    /*
    *
    * 1. Let takes in as it (ARGUMENT) --> returns result of lambda
    * 2. Also takes in as it (ARGUMENT)--> returns the same object
    *
    * 3. Apply takes in as this (RECEIVER) --> returns the same object
    * 4. Run takes in as this (RECEIVER) --> returns result of lambda
    *
    * 5. With takes in as this (RECEIVER) --> returns result of lambda
    *
    * */


    //region LET -----------

    // <T, R> T.let(block: (T) -> R): R


    val studentSectionString = Student(1, "Jack")?.let {
        //it.name // cant access private member
        "section is ${it.section}"
    } // ==========> returns "section is ${it.section}"


    // endregion

    //region ALSO ----------

    // fun <T> T.also(block: (T) -> Unit): T

    val student1 = Student(1,"Jack").also {
        it.study()
    } // =================> calls study fun on the student object and returns the receiver or the student object

    //endregion

    // region APPLY ---------

    // <T> T.apply(block: T.() -> Unit): T


    val student = Student(1,"Jack").apply {
        //this.name // cant access private members
        section = "A"
    } //=================>  Sets the student section as A and then returns the student

    //endregion

    // region RUN -----------

    fun testRunFunction(){
        val student2= Student(1,"Jack")
        run{
            // T.run(block: T.() -> R): R


        }
        student2.run {
            // T.run(block: T.() -> R): R
            section = "B"
            "this student is in section $section"
        }
    }

    //endregion



    // region WITH ----------

    //with(receiver: T, block: T.() -> R): R

    private val student3 = Student(1,"Jack")
    fun testWithFun(){
        with(student3){
            //this.name --> no access to private members as usual
            this.section = "C"
            "This student is in section C"
        } // ==================> takes the parameter as this and returns "This student is in section C"
    }
    //endregion



}

class Student(private val rollNumber: Int, private val name: String) {
    var section: String? = "default section"
    private var address: String? = null

    fun study() = println("Student $name is studying")
    private fun sleep() = println("Student $name is sleeping")

}