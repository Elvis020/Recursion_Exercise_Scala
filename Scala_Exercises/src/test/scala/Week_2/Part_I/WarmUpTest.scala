package Week_2.Part_I

import Week_2.Part_I.Exercise_3_PMs.WarmUp
import Week_2.Part_I.Exercise_3_PMs.WarmUp.{question_1, question_2, question_3, swap}
import munit.FunSuite

class WarmUpTest extends FunSuite{
  val warmUpTest = WarmUp
  test("Should return  \"19<=number<=35\" because number is 30"){
    val obtained = question_1(30)
    val expected =  "19<=number<=35"
    assertEquals(obtained,expected)
  }
  test("Should return  \"<=65\" because number is 1000"){
    val obtained = question_1(1000)
    val expected =  ">65"
    assertEquals(obtained,expected)
  }
  test("Should return  \"<0\" because number is -78"){
    val obtained = question_1(-78)
    val expected =  "<0"
    assertEquals(obtained,expected)
  }
  test("Should return 0 because List is empty"){
    val obtained = question_2(List.empty[Int])
    val expected =  0
    assertEquals(obtained,expected)
  }
  test("Should return 3 because List(1,2,3) has 3 elements"){
    val obtained = question_2(List(1,2,3))
    val expected =  3
    assertEquals(obtained,expected)
  }
  test("Should return 1 because List(1,2,3,4) has more than 3 elements"){
    val obtained = question_2(List(1,2,3,4))
    val expected =  1
    assertEquals(obtained,expected)
  }
  test("Should return 4 because the List(1,2,3,4) has only 4 elements"){
    val obtained = question_3(List(1,2,3,4))
    val expected =  4
    assertEquals(obtained,expected)
  }
  test("Should return 2 because the Map(1 -> \"Welcome\",2 -> \"Goodbye\") has only 2 elements"){
    val obtained = question_3(Map(1 -> "Welcome",2 -> "Goodbye"))
    val expected =  2
    assertEquals(obtained,expected)
  }
  test("Should return 3 because the Vector(1,2,3) has only 3 elements"){
    val obtained = question_3(Vector(1,2,3))
    val expected =  3
    assertEquals(obtained,expected)
  }
  test("Should return -1 because its neither of type List,Map or Vector"){
    val obtained = question_3(Array(1,2))
    val expected =  -1
    assertEquals(obtained,expected)
  }
  test("Should return false when given )( using tail recursion with PM") {
    val obtained = warmUpTest.hasValidParenthesis(")(")
    val expected = false
    assertEquals(obtained, expected)
  }
  test("Should return false when given ())()( using tail recursion with PM") {
    val obtained = warmUpTest.hasValidParenthesis("())()(")
    val expected = false
    assertEquals(obtained, expected)
  }
  test("Should return Array(2,1) when given Array(1,2)") {
    val obtained = swap(Array(1, 2)).mkString("Array(", ", ", ")")
    val expected = Array(2,1).mkString("Array(", ", ", ")")
    assertEquals(obtained, expected)
  }
  test("Should return Array(2,1,3) when given Array(1,2,3)") {
    val obtained = swap(Array(1, 2,3)).mkString("Array(", ", ", ")")
    val expected = Array(2,1,3).mkString("Array(", ", ", ")")
    assertEquals(obtained, expected)
  }
}