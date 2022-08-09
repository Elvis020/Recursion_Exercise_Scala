package Week1.Recursion_Exercises.LittleMoreFun

import scala.collection.mutable

class LittleMoreFun {
  // Without recursion
  def countCharacters(s: String):mutable.Map[Char,Int] = {
    val emptyMap = scala.collection.mutable.Map[Char,Int]()
    s.map(c =>{
      emptyMap += ((c ,s.count(_ == c)))
    })
    emptyMap
  }
  def hasValidParenthesis(s:String): Boolean = ???


  // With recursion
  def countCharactersRT(s:String):mutable.Map[Char,Int] = {
    def helperFunc(a:String,myMap:mutable.Map[Char,Int]=mutable.Map[Char,Int]()):mutable.Map[Char,Int]={
      if (a=="") myMap
      else {
        myMap.updateWith(a.head){
          case Some(count) => Some(count+1)
          case None => Some(1)
        }
        helperFunc(a.tail,myMap)
      }
    }
    helperFunc(s)
  }

}

object Test extends App{
  val lf = new LittleMoreFun()
}