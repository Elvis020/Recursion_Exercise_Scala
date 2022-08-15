package Week_1.Part_I

import Week1.Part_I.Exercise_1_Recursion.Challenge
import munit.FunSuite

class ChallengeTest extends FunSuite{
  test("Should return a valid set of parenthesis fo sampleLength 2") {
    val obtained = Challenge.generateValidParentheses(2)
    val expected = List("()()","(())")
    assertEquals(obtained, expected)
  }

  test("Should return a valid set of parenthesis fo sampleLength 3") {
    val obtained = Challenge.generateValidParentheses(3).sorted
    val expected = List("(()())","()()()","(())()","((()))","()(())").sorted
    assertEquals(obtained, expected)
  }

}