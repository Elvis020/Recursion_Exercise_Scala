package Week1.Part_II.Exercise_2_Functions

import Week1.Part_II.Exercise_2_Functions.Challenge.mergeSort


object Challenge {

  def mergeSort[T](less:(T,T) => Boolean)(xs:List[T]):List[T] = {

    // Get the mid point
    val midPoint = xs.length/2

    // Return the list if the mid point is less than 1
    if (midPoint < 1) xs

    else{
      def merge(xs:List[T],ys:List[T]):List[T] = (xs,ys) match{
        case (Nil,ys) => ys
        case (xs,Nil) => xs
        case(x_head::x_tail,y_head::y_tail) if less(x_head,y_head) =>  x_head :: merge(x_tail,ys)
        case(x_head::x_tail,y_head::y_tail) if less(y_head,x_head) =>  y_head :: merge(y_tail,xs)
      }

      // Split the list into 2
      val splitList = xs.splitAt(midPoint)

      // Recursively send the split lists into the merge function until the lst has 1 element
      val m1 = mergeSort(less)(splitList._1)
      val m2 = mergeSort(less)(splitList._2)
      merge(m1,m2)
    }

  }


  def intSort(listOfInts:List[Int],fn:(Int,Int) => Boolean = _<= _ ): List[Int] = {
    mergeSort(fn)(listOfInts)
  }

  def reverseSort(listOfInts:List[Int],fn:(Int,Int) => Boolean = _ >= _ ): List[Int] = {
    mergeSort(fn)(listOfInts)
  }

  // Yh, making it curry makes it definitely easier to read and write. I have seen the significant difference the currying makes


}