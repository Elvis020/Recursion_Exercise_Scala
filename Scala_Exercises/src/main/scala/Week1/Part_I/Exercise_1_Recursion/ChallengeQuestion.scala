package Week1.Part_I.Exercise_1_Recursion

object ChallengeQuestion {
  def generateValidParentheses(sampleLength:Int):Unit = {

    // TODO: To figure out the logic for this function
    def helperFunc(n:Int,result:List[String]=List("()")): List[String] = {
      if (sampleLength == 1) result
      else {
        helperFunc(n-1,result ++: List("()"))
      }
    }
    helperFunc(sampleLength)
  }
}