import munit.FunSuite



class MySuite extends FunSuite {
  
  test("hello") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }


}