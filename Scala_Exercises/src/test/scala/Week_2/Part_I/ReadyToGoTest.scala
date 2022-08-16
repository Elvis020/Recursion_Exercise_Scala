package Week_2.Part_I

import Week_2.Part_I.Exercise_3_PMs.ReadyToGo.show
import Week_2.Part_I.Exercise_3_PMs.{Div, Number, Prod, Sum}
import munit.FunSuite

class ReadyToGoTest extends FunSuite{
  test("Should return  \"2\" given Number(2)"){
    val obtained = show(Number(2))
    val expected =  "2"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 + 3\" given Sum(Number(2),Number(3))"){
    val obtained = show(Sum(Number(2),Number(3)))
    val expected =  "2 + 3"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 + 3 + 4\" given Sum(Sum(Number(2),Number(3)),Number(4))"){
    val obtained = show(Sum(Sum(Number(2),Number(3)),Number(4)))
    val expected =  "2 + 3 + 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"(2 + 3) * 4\" given Prod(Sum(Number(2), Number(3)), Number(4))"){
    val obtained = show(Prod(Sum(Number(2), Number(3)), Number(4)))
    val expected =  "(2 + 3) * 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 * 3 + 4\" given Sum(Prod(Number(2), Number(3)), Number(4))"){
    val obtained = show(Sum(Prod(Number(2), Number(3)), Number(4)))
    val expected =  "2 * 3 + 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"((2 + 3) * 4)/5\" given Div(Prod(Sum(Number(2), Number(3)), Number(4)), Number(5))"){
    val obtained = show(Div(Prod(Sum(Number(2), Number(3)), Number(4)), Number(5)))
    val expected =  "((2 + 3) * 4)/5"
    assertEquals(obtained,expected)
  }
}