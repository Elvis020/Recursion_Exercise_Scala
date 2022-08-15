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

  // TODO: Question 3
  //  val function: (String, (Int, (String => Int)) => Int) => (Int => Int) = ???
  val takeStringAndConvertToInt: String => Int = (x: String) => x.toInt
  val take2Nums: (Int, String => Int) => Int = (num1: Int, takeStringAndConvertToInt) => num1 + takeStringAndConvertToInt("2")
  //  val level_4:(String, (Int, (String => Int)) => Int) => (Int => Int) = {
  //    case (x:String, y:((Int, (String => Int)) => Int)) => y match {
  //      case (s:Int,r:(String =>Int)) => r match {
  //        case
  //      }
  //    }
  //  }

  //  val level_1: String => Int = takeStringAndConvertToInt
  //  val level_2 = take2Nums(21,takeStringAndConvertToInt)
  //  val level_3 = level_4("5",take2Nums)
  //
  //  println(level_3)


  // Question 4
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  // Method 1 of converting to curried 🤓🤓🤓🤓🤓🤓🤓🤓
  val addThreeNumbers_II = addThreeNumbers.curried

  // Method 2 of converting to curried
  def addThreeNumbers_IIb(x: Int)(y: Int)(z: Int): Int = x + y + z
}