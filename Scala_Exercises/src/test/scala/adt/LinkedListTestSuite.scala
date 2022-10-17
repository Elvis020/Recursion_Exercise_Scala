package adt

package io.turntabl
package adt

import Week_5.{Cons, Empty, MyLinkedList}
import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

class MyLinkedListSuite extends FunSuite with ScalaCheckSuite {

  /* Generator to create objects of type MyLinkedList based on the standard generator of List */
  def myLinkedListGenerator[T](g: Gen[T]): Gen[MyLinkedList[T]] = Gen listOf(g) map(MyLinkedList(_ :_*))

  test("Head of an empty list should throw a runtime exception") {
    intercept[java.lang.RuntimeException](Empty.head)
  }

  test("Head of a non-empty list should return the first value in the list") {
    forAll(Gen.alphaNumStr, myLinkedListGenerator(Gen.alphaNumStr)) { (item, myList) =>
      assertEquals(Cons(item, myList).head, item)
    }
  }

  test("Tail of an empty list should throw a runtime exception") {
    intercept[java.lang.RuntimeException](Empty.tail)
  }

  test("Tail of a list should return the list without the first element") {
    assertEquals(MyLinkedList(1,2,3,4,5).tail, MyLinkedList(2,3,4,5))
  }

  test("Tail of a non-empty list should have one less element than the original list ") {
    forAll(myLinkedListGenerator(Gen.alphaNumStr)) { (myList) =>
      if(myList.length >= 1) assertEquals(myList.tail.length, myList.length -1)
    }
  }

  test("isEmpty should return true for lists with no elements and false otherwise") {
    forAll(myLinkedListGenerator(Gen.alphaNumStr)) { (myList) =>
      if (myList.length >= 1) assertEquals(myList.isEmpty, false)
      else assertEquals(myList.isEmpty, true)
    }
  }

  test("Adding an element to an empty list should return a list with just that element") {
    assertEquals(1 :: Empty, MyLinkedList(1))
  }

  test("Adding an element to any list should add the element to the front of the list") {
    forAll(Gen.alphaNumStr, myLinkedListGenerator(Gen.alphaNumStr)) { (item, myList) =>
      assertEquals((item :: myList).head, item)
    }
  }

  test("To string should return the elements of the list separated by commas and surrounded by [ ]") {
    assertEquals(MyLinkedList(1,2,3,4,5).toString, "[1,2,3,4,5]")
  }

  test("Calling map on the list with a function should apply the function to every element in the list") {
    assertEquals(MyLinkedList(1,2,3,4,5).map(_ * 2), MyLinkedList(2,4,6,8,10))
  }

  test("Flat map should apply a function to every element that returns another list and flatten the results to an individual list") {
    assertEquals(MyLinkedList(1,2,3,4,5).flatMap(elem => elem :: elem + 1 :: Empty), MyLinkedList(1,2,2,3,3,4,4,5,5,6))
  }

  test("For each should traverse through the list and perform a side affecting action on each element and return unit") {
    var myNewLinkedList: MyLinkedList[Int] = Empty

    val unitReturn: Unit = MyLinkedList(1,2,3,4,5).forEach(x => {
      myNewLinkedList = x * 2 :: myNewLinkedList
    })
    assertEquals(myNewLinkedList, MyLinkedList(10,8,6,4,2))
    assert(unitReturn.isInstanceOf[Unit])
  }

  test("Filter should return only the elements in the list that match the given predicate") {
    assertEquals(MyLinkedList(1,2,3,4,5).filter(_ < 3), MyLinkedList(1,2))
  }

  test("Filter not should return the elements in the list that don't match the given predicate") {
    assertEquals(MyLinkedList(1,2,3,4,5).filterNot(_ < 3), MyLinkedList(3,4,5))
  }

  test("For comprehensions should compile successfully and provide the same result as equivalent flatMap, map and with filter calls") {
    val firstList = MyLinkedList(1,2,3,4,5,6,7,8,9,10)
    val secondList = MyLinkedList(10,9,8,7,6,5,4,3,2,1)

    val forResult = for {
      x <- firstList;
      y <- secondList if y < 5
    } yield x + y

    val result = firstList
      .flatMap(x =>
        secondList
          .filter(_ < 5)
          .map(y => x + y))

    assertEquals(forResult, result)
  }

  test("Length should return the number of elements in the list") {
    assertEquals(MyLinkedList(1,2,3,4,5).length, 5)
    assertEquals(Empty.length, 0)
  }

  test("Reversing a list should return the same list but in the reverse order") {
    assertEquals(MyLinkedList(1,2,3,4,5).reverse, MyLinkedList(5,4,3,2,1))
    assertEquals(Empty.reverse, Empty)
  }

  test("When calling reduce on a list of integers with a sum function, should get the sum of the elements in the list") {
    assertEquals(MyLinkedList(1,2,3,4,5).reduce(_ + _), 15)
  }

  test("Fold should be the same as reduce with a sum function and a 0 start and a multiplication function and a 1 start") {
    val l = MyLinkedList(1,2,3,4,5)
    assertEquals(l.fold(0)(_ + _), l.reduce(_ + _))
    assertEquals(l.fold(1)(_ * _), l.reduce(_ * _))
  }

  test("Zip should throw an exception if the two lists are not the same length") {
    forAll(myLinkedListGenerator(Gen.alphaNumStr), myLinkedListGenerator(Gen.alphaNumStr)) { (list1, list2) =>
      if(list1.length != list2.length) intercept[RuntimeException](list1.zip(list2))
      assert(true) // Keeps compiler happy
    }
  }

  test("When lists are the same size zip should combine their elements pairwise") {
    val l1 = MyLinkedList(1,2,3,4,5)
    val l2 = MyLinkedList(5,4,3,2,1)

    assertEquals(l1.zip(l2), MyLinkedList((1,5),(2,4),(3,3),(4,2),(5,1)))
  }

  test("Zip with index should return the list with the index of each element starting at 0") {
    val l1 = MyLinkedList(1,2,3,4,5)
    assertEquals(l1.zipWithIndex, MyLinkedList((1,0), (2,1), (3,2), (4,3), (5,4)))
  }

  test("Zip with function should return the list with elements combined pairwise according to the given function") {
    val l1 = MyLinkedList(1, 2, 3, 4, 5)
    val l2 = MyLinkedList(5, 4, 3, 2, 1)

    assertEquals(l1.zipWith[String, String](l2.map(_.toString), _ + "-" + _), MyLinkedList("1-5","2-4", "3-3", "4-2", "5-1"))
  }

  test("Partition should separate a list in to two lists with the first matching where the predicate holds and the second where it doesn't") {
    val l1 = MyLinkedList(1,2,3,4,5)
    assertEquals(l1.partition(_ < 3), (MyLinkedList(1,2), MyLinkedList(3,4,5)))
  }

  test("Sort should return an unsorted list of integers in sorted order") {
    val l1 = MyLinkedList(5,3,7,2,1)
    assertEquals(l1.sort(_ - _), MyLinkedList(1,2,3,5,7))
  }

}
