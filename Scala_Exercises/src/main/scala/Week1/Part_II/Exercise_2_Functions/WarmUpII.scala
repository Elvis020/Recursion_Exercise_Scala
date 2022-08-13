package Week1.Part_II.Exercise_2_Functions

import scala.annotation.tailrec

/**
 * 1. Write a function value that takes five strings and returns the sum of the length of all
 * of the strings. Write this function using both long hand syntax (e.g. FunctionX) and
 * short hand. Which do you prefer and why?
 *
 * 2. Write a function that takes an int as an argument and returns another function as a result
 *
 * 3.
 */


class WarmUpII {

  // Question 1 (I prefer take5AndAdd_I)
  val take5AndAdd_I = new Function5[Int, Int, Int, Int, Int, Int] {
    override def apply(v1: Int, v2: Int, v3: Int, v4: Int, v5: Int): Int = v1 + v2 + v3 + v4 + v5
  }
  val take5AndAdd_II: (Int, Int, Int, Int, Int) => Int = _ + _ + _ + _ + _

  // Question 2
  val add2ToReturnFunctionValue: Int => (Int => Int) = x => n => n + 2 + x

  // TODO: Question 3
  //  val function: (String, (Int, (String => Int)) => Int) => (Int => Int) = ???
  //  val takeIntAndReturnFunctionValue:Int => (Int => Int) = x => n => n+2+x
  //  val convertStrTInt: String => Int = s => s.toInt
  //  val addTwoNums: (Int, String => Int) => Int = (x:Int, y:String => Int) => x + (y _)
  //  val takeSandII: (String, (Int,(String => Int)) => Int) => Int = ???
  //  val takeStringAndComplexFun: (String, (Int,(String => Int)) => Int) =>(Int=>Int) = (x:String) => (y:Int,z:String=>Int)  => y+z(x)
  //  val takeStringAndComplexFun: (String, (Int,(String => Int)) => Int) =
  //    (x:String,y:(Int,(String => Int)) => Int) = (y => )
  //  val e1: (Int, String => Int) = (21,convertStrTInt)

  // Question 4
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  // Method 1 of converting to curried 🤓🤓🤓🤓🤓🤓🤓🤓
  val addThreeNumbers_II = addThreeNumbers.curried

  // Method 2 of converting to curried
  def addThreeNumbers_IIb(x: Int)(y: Int)(z: Int): Int = x + y + z


  // TODO: Question 5 - Ask Nunana for clarification
  def concatenate[T](item: T, item2: T, concat: T => T): T = ???


}