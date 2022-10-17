package Week_1.Part_II

import Week1.Part_II.Exercise_2_Functions.FileMatcher
import munit.FunSuite

class WeAreWarmTest extends FunSuite {
  val fileMatcher = FileMatcher

  // List of files
  val listOfFiles = fileMatcher.getFileHere

  test("Should return all the files ending in .txt using implementation I") {
    val extract = fileMatcher.filesEnding(".txt")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./Elvis.txt]"
    assertEquals(obtained,expected)
  }

  test("Should return all the files ending in .txt using implementation II") {
    val extract = fileMatcher.filesEndingII(".txt")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./Elvis.txt]"
    assertEquals(obtained,expected)
  }

  test("Should return all the files containing 'get' using implementation I") {
    val extract = fileMatcher.filesContaining("get")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./target]"
    assertEquals(obtained,expected)
  }

  test("Should return all the files containing 'get' using implementation II") {
    val extract = fileMatcher.filesContainingII("get")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./target]"
    assertEquals(obtained,expected)
  }

  test("Should return all the files with regex './.bsp' using implementation I") {
    val extract = fileMatcher.filesRegex("./.bsp")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./.bsp]"
    assertEquals(obtained,expected)
  }
  test("Should return all the files with regex './.bsp' using implementation II") {
    val extract = fileMatcher.filesRegexII("./.bsp")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./.bsp]"
    assertEquals(obtained,expected)
  }
  test("Should return all the files with regex './.bsp' using implementation II") {
    val extract = fileMatcher.filesStartingWithCurried("./.")
    val obtained = fileMatcher.toString(extract)
    val expected = "[./.bsp,./.idea]"
    assertEquals(obtained,expected)
  }

}