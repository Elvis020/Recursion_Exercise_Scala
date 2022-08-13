package Week1.Part_I.Exercise_1_Recursion

import scala.annotation.tailrec

/**
 * Write recursive functions for the following functions:
 * 1. Returns the sum of the numbers between two numbers a and b
 * 2. Concatenate a given string n times
 * 3. Find the length of a string
 * 4. Calculate fibonacci number for a provided value n
 * 5. Returns whether a given number n is prime (i.e. it is divisible by itself and 1)
 */

class WarmUp {

  // Standard Recursive
  def concatenateStringNTimes(inputString:String,n:Int):String = {
    if (n==0 || n==1) inputString
    else inputString+concatenateStringNTimes(inputString,n-1)
  }
  def fibonacciNum(number:Int):Int = {
    if (number == 1 || number == 2) 1
    else fibonacciNum(number-1)+fibonacciNum(number-2)
  }
  def findLength(inputString:String):Int = {
    def helperFun(s:String,acc:Int=1):Int = {
      if (s=="") acc-1
      else acc+findLength(s.substring(1))
    }
    helperFun(inputString)

  }
  def returnSum(a:Int,b:Int):Int = {
    if ((a+1)==b) 0
    else a+1+returnSum(a+1,b)
  }



  // Tail Recursive
  def concatenateStringNTimesTR(s:String,n:Int):String = {
    @tailrec
    def helperFun(a:String,n:Int,acc:String=s):String ={
      if (n==0 || n==1) acc
      else helperFun(a,n-1,acc+s)
    }
    helperFun(s,n)
  }
  def isPrimeTR(n:Int):Boolean = {
    @tailrec
    def helperFunc(a:Int,acc:Int=2):Boolean={
      if (n==acc) true
      else if (n%acc == 0) false
      else helperFunc(a,acc+1)
    }
    helperFunc(n)
  }
  def returnSumTR(a:Int,b:Int):Int = {
    @tailrec
    def helperFunc(c:Int,d:Int,acc:Int=0):Int = {
      if ((c+1)==d) acc
      else helperFunc(c+1,d,acc+c+1)
    }
    helperFunc(a,b)
  }
  def findLengthTR(s:String):Int = {
    @tailrec
    def helperFun(n:String,acc:Int=1):Int = {
      if (n=="") acc-1
      else helperFun(n.substring(1),acc+1)
    }
    helperFun(s)

  }
  def fibonacciNumTR(n:Int):Int = {
    @tailrec
    def helperFunc(a:Int,acc1:Int=0,acc2:Int=1):Int = {
      if (a == 1 || a == 2) acc1+acc2
      else helperFunc(a-1,acc2,acc1+acc2)
    }
    helperFunc(n)
  }



}