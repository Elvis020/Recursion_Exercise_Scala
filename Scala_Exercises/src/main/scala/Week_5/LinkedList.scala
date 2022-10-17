package Week_5

import org.graalvm.compiler.asm.amd64.AMD64VectorAssembler.VexFloatCompareOp.Predicate

import scala.annotation.tailrec

/**
 * Scala has a built in LinkedList under the List class, the aim here is to build our own (simplified) version
 * of a Linked List called MyLinkedList
 *
 * Exercises:
 * 1) Define a trait (MyLinkedList) and appropriate case classes and case objects for our linkedList to represent empty and non-empty
 * 2) Create a method head that returns the first element of our List
 * 3) Create a method tail that returns the remaining elements of our List
 * 4) Create a method isEmpty that returns whether our List is empty or not
 * 5) Create a method to add an element to a list, call this method :: as is standard in the Scala List Library
 * 6) Create a toString method that will return a string representation of the List with commas between each element e.g. [1,2,3,4,5]
 * 7) Create the appropriate method so that a List can be created with elements easily, i.e. val list = MyLinkedList(1,2,3,4,5)
 *
 * Notes: The List must be immutable.
 *
 */

sealed trait MyLinkedList[+T] {
  def head: T

  def tail: MyLinkedList[T]

  def isEmpty: Boolean

  def ::[S >: T](element: S): MyLinkedList[S] // Add method

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](f: T => B): MyLinkedList[B]

  def flatMap[B](f: T => MyLinkedList[B]): MyLinkedList[B]

  def filter(f: T => Boolean): MyLinkedList[T]

  def filterNot(f: T => Boolean): MyLinkedList[T] =this.filter(!f(_))

  def withFilter[B](f: T => Boolean): MyLinkedList[T] = filter(f) // This is a bit of a dummy implementation but allows for for comprehensions

  def ++[S >: T](list: MyLinkedList[S]): MyLinkedList[S]

  def reverse: MyLinkedList[T]

  def length: Int

  def forEach(f: T => Unit): Unit

  def zipWith[R, S](list: MyLinkedList[R], zip: (T, R) => S): MyLinkedList[S]

  def fold[S >: T](start: S)(operator: (S, S) => S): S

  def reduce[S >: T](operator: (S, S) => S): S

  def zip[S](list: MyLinkedList[S]): MyLinkedList[(T, S)]

  def zipWithIndex: MyLinkedList[(T, Int)]


  def partition(predicate: T => Boolean) : (MyLinkedList[T], MyLinkedList[T])

  def sort(compare: (T, T) => Int): MyLinkedList[T]


}


case object Empty extends MyLinkedList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException("Head of empty LinkedList")

  override def tail: MyLinkedList[Nothing] = throw new NoSuchElementException("Tail of empty LinkedList")

  override def isEmpty: Boolean = true

  override def ::[S >: Nothing](element: S): MyLinkedList[S] = Cons(element, this)

  override def printElements: String = ""

  override def map[B](f: Nothing => B): MyLinkedList[B] = Empty

  override def flatMap[B](f: Nothing => MyLinkedList[B]): MyLinkedList[B] = Empty

  override def filter(f: Nothing => Boolean): MyLinkedList[Nothing] = Empty

  override def ++[S >: Nothing](list: MyLinkedList[S]): MyLinkedList[S] = Empty

  override def reverse: MyLinkedList[Nothing] = Empty

  override def length: Int = 0

  override def forEach(f: Nothing => Unit): Unit = throw new NoSuchElementException("Can't iterate an empty LinkedList")

  override def zipWith[R, S](list: MyLinkedList[R], zip: (Nothing, R) => S): MyLinkedList[S] = Empty

  override def fold[S >: Nothing](start: S)(operator: (S, S) => S): S = start

  override def reduce[S >: Nothing](operator: (S, S) => S): S = throw new RuntimeException("Trying too apply the " +
    "reduce method on an empty list")

  override def zip[S](list: MyLinkedList[S]): MyLinkedList[(Nothing, S)] = Empty

  override def zipWithIndex: MyLinkedList[(Nothing, Int)] = Empty

  override def sort(compare: (Nothing, Nothing) => Int): MyLinkedList[Nothing] = Empty

  override def partition(predicate: Nothing => Boolean): (MyLinkedList[Nothing], MyLinkedList[Nothing]) = (Empty,Empty)
}

case class Cons[+T](my_head: T, my_tail: MyLinkedList[T]) extends MyLinkedList[T] {
  override def head: T = my_head

  override def tail: MyLinkedList[T] = my_tail

  override def isEmpty: Boolean = false

  override def ::[S >: T](element: S): MyLinkedList[S] = Cons(element, this)

  override def printElements: String = {
    if (my_tail.isEmpty) ""
    else my_head.toString + ","+ tail.printElements
  }

  override def map[B](f: T => B): MyLinkedList[B] = f(my_head) :: my_tail.map(f) // map in terms of fold

  override def flatMap[B](f: T => MyLinkedList[B]): MyLinkedList[B] = f(my_head) ++ my_tail.flatMap(f)

  override def filter(f: T => Boolean): MyLinkedList[T] = {
    if (f(my_head))  head :: my_tail.filter(f)
    else tail.filter(f)
  }

//  def withFilter[B](f: T => Boolean): MyLinkedList[T] = filter(f) // This is a bit of a dummy implementation but allows for for comprehensions
  override def withFilter[B](f: T => Boolean): MyLinkedList[T] = ??? // This is a bit of a dummy implementation but allows for
  // for comprehensions

  override def ++[S >: T](list: MyLinkedList[S]): MyLinkedList[S] = Cons(my_head, my_tail ++ list)

  override def reverse: MyLinkedList[T] = {
    @tailrec
    def reverseAcc(currLinkedList:MyLinkedList[T],myReversedLinkedList: MyLinkedList[T]):MyLinkedList[T] ={
      if (currLinkedList.isEmpty) myReversedLinkedList
      else reverseAcc(currLinkedList.tail, currLinkedList.head :: myReversedLinkedList)
    }
    reverseAcc( this,Empty)
  }

  override def length: Int = 1 + my_tail.length

  override def forEach(f: T => Unit): Unit = {
    f(my_head)
    my_tail.forEach(f)

  }

  override def zipWith[R, S](list: MyLinkedList[R], zip: (T, R) => S): MyLinkedList[S] = {
    if (isEmpty) Empty
    else zip(my_head, list.head) :: my_tail.zipWith(list.tail,zip)
  }

  override def fold[S >: T](start: S)(operator: (S, S) => S): S = {
    if (isEmpty) start
    else tail.fold(operator(start,head))(operator)
  }

  override def reduce[S >: T](operator: (S, S) => S): S = {
    if (length>2) head
    else tail.tail.fold(operator(head,tail.head))(operator)
  }

  override def zip[S](list: MyLinkedList[S]): MyLinkedList[(T, S)] = {
    if(isEmpty) Empty
    else (my_head,list.head) :: my_tail.zip(list.tail)
  }

  override def zipWithIndex: MyLinkedList[(T, Int)] = {
    (my_head::my_tail).zip(MyLinkedList(0 until(this.length): _*) )
  }

//  override def partition(predicate: T => Boolean): (MyLinkedList[T], MyLinkedList[T]) = {
//    (this.filter(predicate),this.filter(!predicate(_)))
//  }

//  override def partition(predicate: T => Boolean): (MyLinkedList[T], MyLinkedList[T]) = {
//    def partitionAcc(remainder:MyLinkedList[T],predicate: T => Boolean,partitioned:(MyLinkedList[T], MyLinkedList[T])): (MyLinkedList[T], MyLinkedList[T]) = {
//      if (remainder.isEmpty) partitioned
//      else{
//        if(predicate(remainder.head)) partitionAcc(remainder.tail,predicate, (remainder.head :: partitioned._1,
//          partitioned._2))
//        else partitionAcc(remainder.tail,predicate, (partitioned._1, remainder.head :: partitioned._2))
//      }
//    }
//    partitionAcc(this.reverse,predicate,(Empty,Empty))
//  }


  override def partition(predicate: T => Boolean): (MyLinkedList[T], MyLinkedList[T]) = {
    // Method 1
//    this.reverse.fold(Empty,Empty){
//      (my_head, acc: (MyLinkedList[T], MyLinkedList[T])) => {
//        if (predicate(my_head)) (my_head :: acc._1, acc._2)
//        else (acc._1, my_head :: acc._2)
//      }
//    }

    // Method 2
    (this.filter(predicate),this.filter(!predicate(_)))

    // Method 3
    def partitionAcc(remainder:MyLinkedList[T],
                     predicate:T=>Boolean,
                     partitioned:(MyLinkedList[T],MyLinkedList[T])):(MyLinkedList[T],MyLinkedList[T]) = {
      if (isEmpty) partitioned
      else{
        if(predicate(remainder.head)) partitionAcc(remainder.tail,predicate,(remainder.head :: partitioned._1,partitioned._2))
        else partitionAcc(remainder.tail,predicate,(partitioned._1,remainder.head ::partitioned._2))
      }
    }
    partitionAcc(this.reverse,predicate,(Empty,Empty))
  }


  // TODO: Take a look at sort
  override def sort(compare: (T, T) => Int): MyLinkedList[T] = this

}


object MyLinkedList {


  def apply[T](items: T*): MyLinkedList[T] = {
    if(items.isEmpty) Empty
    else items.head :: apply(items.tail: _*)
  }

  def main(args: Array[String]): Unit = {
    val myList: MyLinkedList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
    val myList2: MyLinkedList[Int] = 1 :: 2 :: 3 :: 4 :: Empty

    val calvinsList = MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val myEmptyList = Empty
    println(myList2) // [1,2,3,4]
    println(myEmptyList)

  }
}

