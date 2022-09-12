package Week1.Part_II.Exercise_2_Functions

import scala.annotation.tailrec




object WarmUpII {

  // Question 1 (I prefer take5AndAdd_I)
  val take5AndAdd_I = new Function5[Int, Int, Int, Int, Int, Int] {
    override def apply(v1: Int, v2: Int, v3: Int, v4: Int, v5: Int): Int = v1 + v2 + v3 + v4 + v5
  }
  val take5AndAdd_II: (Int, Int, Int, Int, Int) => Int = _ + _ + _ + _ + _

  // Question 2
  val add2ToReturnFunctionValue: Int => (Int => Int) = x => n => n + 2 + x

  // TODO: Question 3 - Play around more with this
//  val function: (String, (Int, (String => Int)) => Int) => (Int => Int) = ???
  val take2Nums: (Int, String => Int) => Int = (num1:Int, takeStringAndConvertToInt) => num1 + takeStringAndConvertToInt("2")
  val function:(String, (Int, (String => Int)) => Int) => (Int => Int) = (s,take2Nums) => y => s.length + y








  // Question 4
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  // Method 1 of converting to curried 🤓🤓🤓🤓🤓🤓🤓🤓
  val addThreeNumbers_II = addThreeNumbers.curried

  // Method 2 of converting to curried
  def addThreeNumbers_IIb(x: Int)(y: Int)(z: Int): Int = x + y + z


  // TODO - Add test cases later
  def concatenate[T](item: T, item2: T, concat: (T,T) => T): T = concat(item,item2)





}

object Testy extends App{
  val w = WarmUpII
  val concatenateNames = w.concatenate[String]("Elvis", "Opoku", _ + _)
  println("Full name: " + concatenateNames)
}