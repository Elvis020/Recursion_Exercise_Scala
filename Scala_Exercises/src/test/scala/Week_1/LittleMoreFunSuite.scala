package Week_1

import Week1.Recursion_Exercises.LittleMoreFun.LittleMoreFun
import munit.FunSuite

import scala.collection.mutable

class LittleMoreFunSuite extends FunSuite {
  val littleMoreFun = new LittleMoreFun()

  test("Should return true when given () ") {
    val obtained = littleMoreFun.hasValidParenthesis("()")
    val expected = true
    assertEquals(obtained, expected)
  }

  test("Should return true when given ((())) ") {
    val obtained = littleMoreFun.hasValidParenthesis("((()))")
    val expected = true
    assertEquals(obtained, expected)
  }
  test("Should return true when given (())()()(())((())) ") {
    val obtained = littleMoreFun.hasValidParenthesis("(())()()(())((()))")
    val expected = true
    assertEquals(obtained, expected)
  }

  test("Should return false when given (() ") {
    val obtained = littleMoreFun.hasValidParenthesis("(()")
    val expected = false
    assertEquals(obtained, expected)
  }

  test("Should return false when given )( ") {
    val obtained = littleMoreFun.hasValidParenthesis(")(")
    val expected = false
    assertEquals(obtained, expected)
  }


  test("Should count the characters in a string using tail recursion") {
    val obtained = littleMoreFun.countCharactersRT("hello")
    val expected = mutable.HashMap('e' -> 1, 'h' -> 1, 'l' -> 2, 'o' -> 1)
    assertEquals(obtained, expected)
  }

}