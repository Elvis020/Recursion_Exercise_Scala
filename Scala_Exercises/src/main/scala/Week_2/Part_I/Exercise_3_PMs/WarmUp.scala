package Week_2.Part_I.Exercise_3_PMs

import scala.annotation.tailrec

object WarmUp {

  // Q1
  val question_1 = (number:Int) => number match {
    case num if num<0 => "<0"
    case num if num>=0 && num<=18  => "0<=number<=18"
    case num if num>=19 && num<=35  => "19<=number<=35"
    case num if num>=36 && num<=54  => "36<=number<=54"
    case _  => ">65"
  }

  // Q2
  val question_2 = (newList:List[Int]) => newList match {
    case Nil => 0
    case List(a,b,c) => c
    case List(head,_*) => head
  }

  // Q3
  val question_3 = (inputParam:Any) => inputParam match {
    case f:List[_] => f.length
    case f:Map[_,_] => f.size
    case f:Vector[_] => f.length
    case _ => -1
  }

  // Q4
  def hasValidParenthesis(string: String): Boolean = {
    @tailrec
    def helperFunc(helperString: String, count: Int = 0): Boolean = (helperString,count) match {
      case (helperString,count) if helperString == "" || helperString.head == ')' && count == 0 => helperString == "" && count == 0
      case (helperString,count) => (helperString,count) match {
        case (helperString,count) if helperString.head == '(' => helperFunc(helperString.tail, count + 1)
        case (helperString,count) if helperString.head == ')' && count > 0 => helperFunc(helperString.tail, count - 1)
        case (helperString,count) => helperFunc(helperString.tail, count)
      }
    }
    helperFunc(string)
  }

  // Q5
  val swap = (arr:Array[_]) => arr.toList match{
    case first :: second :: tail => (second :: first :: tail).toArray
  }


}