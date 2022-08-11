package Week1.Part_I.Recursion_Exercises

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
object Testy extends App{
  val e = new ChallengeQuestion
  val res = e.generateValidParentheses(2)
  println(res)
}