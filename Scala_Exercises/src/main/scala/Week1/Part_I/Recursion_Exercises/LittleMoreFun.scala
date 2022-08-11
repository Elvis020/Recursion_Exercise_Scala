package Week1.Part_I.Recursion_Exercises

import scala.annotation.tailrec


class LittleMoreFun {

  // With tail recursion
  def hasValidParenthesis(string: String): Boolean = {
    @tailrec
    def helperFunc(helperString: String, count: Int = 0): Boolean = {
      if ((helperString == "") || (helperString.head == ')' && count == 0)) helperString == "" && count == 0
      else {
        if (helperString.head == '(') {
          helperFunc(helperString.tail, count + 1)
        }
        else if (helperString.head == ')' && count > 0) {
          helperFunc(helperString.tail, count - 1)
        }
        else {
          helperFunc(helperString.tail, count)
        }
      }
    }

    helperFunc(string)
  }

  def countCharactersRT(s: String): Map[Char, Int] = {
    @tailrec
    def helperFunc(a: String, count: Int = 1, myMap: Map[Char, Int] = Map.empty): Map[Char, Int] = {
      if (a == "") myMap
      else {
        if (myMap.contains(a.head)) {
          helperFunc(a.tail, count, myMap + ((a.head, myMap(a.head)+1)))
        }
        else{
          helperFunc(a.tail, count, myMap + (a.head -> count))
        }
      }
    }
    helperFunc(s)
  }
}