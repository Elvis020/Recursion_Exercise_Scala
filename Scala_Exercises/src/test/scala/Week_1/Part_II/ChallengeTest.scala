package Week_1.Part_II

import Week1.Part_II.Exercise_2_Functions.Challenge
import munit.FunSuite

class ChallengeTest extends FunSuite{
  val challenge = Challenge

  test("Should sort List(3, 2, 4, 2, 3, 4, 5, 4, 3) in ascending order recursively using mergeSort algorithm"){
    val testList = List(3, 2, 4, 2, 3, 4, 5, 4, 3)
    val obtained = challenge.intSort(testList)
    val expected = List(2, 2, 3, 3, 3, 4, 4, 4, 5)
    assertEquals(obtained,expected)
  }

  test("Should sort List(3, 2, 4, 2, 3, 4, 5, 4, 3) in descending order recursively using mergeSort algorithm"){
    val testList = List(3, 2, 4, 2, 3, 4, 5, 4, 3)
    val obtained = challenge.reverseSort(testList)
    val expected = List(5, 4, 4, 4, 3, 3, 3, 2, 2)
    assertEquals(obtained,expected)
  }

}