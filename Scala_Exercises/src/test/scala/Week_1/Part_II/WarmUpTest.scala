package Week_1.Part_II

import Week1.Part_II.Exercise_2_Functions.WarmUpII
import munit.FunSuite


class WarmUpFunSuite extends FunSuite {
  val warmUp = WarmUpII

  test("Should return the sum of 15 when given (1,2,3,4,5)") {
    val obtained = warmUp.take5AndAdd_I(1,2,3,4,5)
    val expected = 15
    assertEquals(obtained, expected)
  }
  test("Should return the sum of 15 when given (1,2,3,4,5)") {
    val obtained = warmUp.take5AndAdd_II(1,2,3,4,5)
    val expected = 15
    assertEquals(obtained, expected)
  }
  test("Should return 8 when given (5) and (1)") {
    val obtained_1 = warmUp.add2ToReturnFunctionValue(5)
    val obtained = obtained_1(1)
    val expected = 8
    assertEquals(obtained, expected)
  }
  test("Should add 3 numbers") {
    val obtained = warmUp.addThreeNumbers(5,4,3)
    val expected = 12
    assertEquals(obtained, expected)
  }
  test("Should add 3 numbers using curried method 1") {
    val obtained = warmUp.addThreeNumbers_II(5)(4)(3)
    val expected = 12
    assertEquals(obtained, expected)
  }
  test("Should add 3 numbers using curried method 2") {
    val obtained = warmUp.addThreeNumbers_IIb(90)(20)(10)
    val expected = 120
    assertEquals(obtained, expected)
  }
}