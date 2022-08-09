package Week1.Recursion_Exercises.ChallengeQuestion_1

import scala.annotation.tailrec
import scala.collection.{immutable, mutable}


class LittleMoreFun {

  // With tail recursion
  def hasValidParenthesis(string: String): Boolean = {
    @tailrec
    def helperFunc(helperString:String, count: Int = 0):Boolean = {
      if ((helperString == "") || (helperString.head == ')' && count == 0)) helperString == "" && count == 0
      else {
        if (helperString.head == '(') {
          helperFunc(helperString.tail, count + 1)
        }
        else if (helperString.head == ')' && count > 0) {
          helperFunc(helperString.tail, count - 1)
        }
        else{
          helperFunc(helperString.tail, count)
        }
      }
    }
    helperFunc(string)
  }

  def countCharacters(sampleString:String):Map[Char,Int] = {
    ???
  }



 



}