package Week1.Part_II

import java.io
import java.io.{File, PrintWriter}
import java.util.Date

object Playground extends App {
  val add1 = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1+1
  }

  val multiplyElements = new Function4[Int,Int,Int,Int,Int] {
    override def apply(v1: Int, v2: Int, v3: Int, v4: Int): Int = v1*v2*v3*v4
  }

  val multiplyElements_II = (v1: Int, v2: Int, v3: Int,v4:Int) => v1*v2*v3*v4
  val add1_II = (v1: Int) => v1*1
  val add:(Int,Int) => Int =  _ + _
  val add_II:(Int,Int) => Int =  (x:Int,y:Int) => x+y


  // Apply the function f to the value x, nTimes
  def nTimes(f:Int=>Int,n:Int,x:Int):Int = {
    if (n<=0) x
    else nTimes(f,n-1,f(x))
  }

  // Currying
  def withPrintWriter(file:File,op:PrintWriter=>Unit) = {
    val writer = new PrintWriter(file)
    try op(writer)
    finally writer.close()
  }
  def withPrintWriter_II(file:File)(op:PrintWriter=>Unit) = {
    val writer = new PrintWriter(file)
    try op(writer)
    finally writer.close()
  }
  val myFile = new File("./Elvis.txt")
  withPrintWriter_II(myFile){
    writer => writer.println(new Date)
  }
  def add3(x:Int)(y:Int)(z:Int):Int = x+y+z
  val add2_again:Int => Int = add3(3)(90)
  add2_again(89)

}