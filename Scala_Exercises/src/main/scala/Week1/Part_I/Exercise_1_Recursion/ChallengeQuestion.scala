package Week1.Part_I.Exercise_1_Recursion

object Challenge {
  def generateValidParentheses(sampleLength:Int):List[String] = {
    def helperFunc(n:Int,currentStrings:Set[String]): Set[String] = {
      if (n == 0) currentStrings
      else  {
        val nextResult = for {
          string <- currentStrings
          index <- 0 until string.length
        } yield{
          val (before,after) = string.splitAt(index)
          s"$before()$after"
        }
        helperFunc(n-1,nextResult)
      }
    }
    if (sampleLength == 0) List()
    else helperFunc(sampleLength-1,Set("()")).toList
  }
}