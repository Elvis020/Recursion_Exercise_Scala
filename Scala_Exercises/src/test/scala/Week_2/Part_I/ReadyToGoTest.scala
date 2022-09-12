package Week_2.Part_I

import Week_2.Part_I.Exercise_3_PMs.ReadyToGo.show
import Week_2.Part_I.Exercise_3_PMs.{Div, Expr, Expression, Num, Prod, Sum}
import munit.FunSuite

class ReadyToGoTest extends FunSuite{
  test("Should return  \"2\" given Number(2)"){
    val obtained = show(Num(2))
    val expected =  "2"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 + 3\" given Sum(Number(2),Number(3))"){
    val obtained = show(Sum(Num(2),Num(3)))
    val expected =  "2 + 3"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 + 3 + 4\" given Sum(Sum(Number(2),Number(3)),Number(4))"){
    val obtained = show(Sum(Sum(Num(2),Num(3)),Num(4)))
    val expected =  "2 + 3 + 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"(2 + 3) * 4\" given Prod(Sum(Number(2), Number(3)), Number(4))"){
    val obtained = show(Prod(Sum(Num(2), Num(3)), Num(4)))
    val expected =  "(2 + 3) * 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"2 * 3 + 4\" given Sum(Prod(Number(2), Number(3)), Number(4))"){
    val obtained = show(Sum(Prod(Num(2), Num(3)), Num(4)))
    val expected =  "2 * 3 + 4"
    assertEquals(obtained,expected)
  }
  test("Should return  \"((2 + 3) * 4)/5\" given Div(Prod(Sum(Number(2), Number(3)), Number(4)), Number(5))"){
    val obtained = show(Div(Prod(Sum(Num(2), Num(3)), Num(4)), Num(5)))
    val expected =  "((2 + 3) * 4) / 5"
    assertEquals(obtained,expected)
  }

  test("Show on sum of numbers with a + between each number") {
    val simpleSum: Expr = Sum(Num(3), Num(4))
    assertEquals(show(simpleSum), "3 + 4")

    val moreComplexSum: Expr = Sum(Num(3), Sum(Num(4), Sum(Num(5), Num(6))))
    assertEquals(show(moreComplexSum), "3 + 4 + 5 + 6")
  }

  test("Show on prod works with a * between each number") {
    assertEquals(show(Prod(Sum(Num(2), Num(3)), Num(4))), "(2 + 3) * 4")
    assertEquals(show(Sum(Prod(Num(2), Num(3)), Num(4))), "2 * 3 + 4")
  }

  test("Show on div works") {
    assertEquals(show(Div(Prod(Sum(Num(2), Num(3)), Num(4)), Num(5))), "((2 + 3) * 4) / 5")
  }
}