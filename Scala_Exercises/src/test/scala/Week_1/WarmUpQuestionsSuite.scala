package Week_1

import Week1.Recursion_Exercises.WarmUpQuestions.WarmUp
import munit.FunSuite



class WarmUpQuestionsSuite extends FunSuite {
  val warmUpQuestions = new WarmUp()

  test("Should the sum of the numbers between two numbers 2 and 10") {
    val obtained = warmUpQuestions.returnSum(2,10)
    val expected = 42
    assertEquals(obtained, expected)
  }


  test("Should the sum of the numbers between two numbers 2 and 10 using tailrec") {
    val obtained = warmUpQuestions.returnSumTR(2,10)
    val expected = 42
    assertEquals(obtained, expected)
  }

  test("Should concatenate a given string n times") {
    val obtained = warmUpQuestions.concatenateStringNTimes("hello",3)
    val expected = "hellohellohello"
    assertEquals(obtained, expected)
  }

  test("Should concatenate a given string n times using tail recursion") {
    val obtained = warmUpQuestions.concatenateStringNTimesTR("hello",3)
    val expected = "hellohellohello"
    assertEquals(obtained, expected)
  }


  test("Should return the length of a string") {
    val obtained = warmUpQuestions.findLength("hello")
    val expected = 5
    assertEquals(obtained, expected)
  }
  test("Should return the length of a string using tail recursion") {
    val obtained = warmUpQuestions.findLengthTR("hello")
    val expected = 5
    assertEquals(obtained, expected)
  }

  test("Should return a fibonacci number for a provided value n") {
    val obtained = warmUpQuestions.fibonacciNum(7)
    val expected = 13

    assertEquals(obtained, expected)
  }

  test("Should return a fibonacci number for a provided value n using tail recursion") {
    val obtainedTR = warmUpQuestions.fibonacciNumTR(7)
    val expected = 13
    assertEquals(obtainedTR, expected)
  }


//  test("Should return whether a given number n is prime") {
//    val obtained = warmUpQuestions.isPrime(7)
//    val expected = true
//    assertEquals(obtained, expected)
//  }


  test("Should return whether a given number n is prime using tail recursion") {
    val obtained = warmUpQuestions.isPrimeTR(7)
    val expected = true
    assertEquals(obtained, expected)
  }


}