package Week_1.Part_I

import Week1.Part_I.Exercise_1_Recursion.LittleMoreFun
import munit.FunSuite

class LittleMoreFunTest extends FunSuite {
  val littleMoreFun = LittleMoreFun

  test("Should return true when given () using tail recursion") {
    val obtained = littleMoreFun.hasValidParenthesis("()")
    val expected = true
    assertEquals(obtained, expected)
  }

  test("Should return true when given ((())) using tail recursion") {
    val obtained = littleMoreFun.hasValidParenthesis("((()))")
    val expected = true
    assertEquals(obtained, expected)
  }
  test("Should return true when given (())()()(())((())) using tail recursion") {
    val obtained = littleMoreFun.hasValidParenthesis("(())()()(())((()))")
    val expected = true
    assertEquals(obtained, expected)
  }

  test("Should return false when given (() using tail recursion") {
    val obtained = littleMoreFun.hasValidParenthesis("(()")
    val expected = false
    assertEquals(obtained, expected)
  }

  test("Should return false when given )( using tail recursion") {
    val obtained = littleMoreFun.hasValidParenthesis(")(")
    val expected = false
    assertEquals(obtained, expected)
  }


  test("Should count the characters in a string using tail recursion") {
    val obtained = littleMoreFun.countCharactersRT("hello")
    val expected = Map('h' -> 1, 'e' -> 1, 'l' -> 2, 'o' -> 1)
    assertEquals(obtained, expected)
  }

  test("Should count the characters in a string using tail recursion") {
    val obtained = littleMoreFun.countCharactersRT("None of my buisness")
    val expected = Map('e' -> 2, 's' -> 3, 'n' -> 2, 'N' -> 1, 'y' -> 1, 'm' -> 1, 'i' -> 1, ' ' -> 3, 'b' -> 1, 'o' -> 2, 'u' -> 1, 'f' -> 1)
    assertEquals(obtained, expected)
  }

}