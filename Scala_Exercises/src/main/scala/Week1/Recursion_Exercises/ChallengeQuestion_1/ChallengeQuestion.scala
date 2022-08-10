package Week1.Recursion_Exercises.ChallengeQuestion_1

class ChallengeQuestion {
  def generateValidParentheses(sampleLength:Int):Unit = {
    def helperFunc(n:Int,result:List[String]=List("()")): List[String] = {
      if (sampleLength == 1) result
      else {
        helperFunc(n-1,result ++: List("()"))
      }
    }
    helperFunc(sampleLength)
  }


}