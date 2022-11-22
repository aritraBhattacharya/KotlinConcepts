class Test {

    fun findNumberOfMatch(list: List<Int>,number:Int){
        var i =0
        var startingPoint =0
        var sum =0
        var countOfMatches = 0
        while (i<list.size){

            sum+=list[i]
            if(sum==number){
                countOfMatches++;
                sum=0
                startingPoint++
                i=startingPoint
            }
            else if(sum<number){
                // do nothing and continue
                i++
            }
            else{ // sum is larger than number, so this subarray has to be discraded
                sum=0
                startingPoint++
                i=startingPoint
            }
        }
        print(countOfMatches)
    }

}