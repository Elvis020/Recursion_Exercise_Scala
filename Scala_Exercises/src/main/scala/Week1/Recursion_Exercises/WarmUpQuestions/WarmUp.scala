package Week1.Recursion_Exercises.WarmUpQuestions

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
  // TODO: Write isPrime for Standard Recursive
  def concatenateStringNTimes(inputString:String,n:Int):String = {
    if (n==0 || n==1) inputString
    else inputString+concatenateStringNTimes(inputString,n-1)
  }
  def fibonacciNum(number:Int):Int = {
    if (number == 1 || number == 2) 1
    else fibonacciNum(number-1)+fibonacciNum(number-2)
  }
  def findLength(inputString:String,acc:Int=1):Int = {
    if (inputString=="") acc-1
    else acc+findLength(inputString.substring(1))
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
  def isPrimeTR(n:Int,acc:Int=2):Boolean = {
    if (n==acc) true
    else if (n%acc == 0) false
    else isPrimeTR(n,acc+1)
  }
  def returnSumTR(a:Int,b:Int,acc:Int=0):Int = {
    if ((a+1)==b) acc
    else returnSumTR(a+1,b,acc+a+1)
  }
  def findLengthTR(s:String,acc:Int=1):Int = {
    if (s=="") acc-1
    else findLengthTR(s.substring(1),acc+1)
  }

  def fibonacciNumTR(n:Int,acc1:Int=0,acc2:Int=1):Int = {
    if (n == 1 || n == 2) acc1+acc2
    else fibonacciNumTR(n-1,acc2,acc1+acc2)
  }



}