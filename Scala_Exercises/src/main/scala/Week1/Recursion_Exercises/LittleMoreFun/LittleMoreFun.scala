package Week1.Recursion_Exercises.LittleMoreFun

import javax.naming.ldap.LdapName
import scala.annotation.tailrec
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



  // With tail recursion
  def countCharactersRT(s:String):mutable.Map[Char,Int] = {
    @tailrec
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
  def hasValidParenthesis(s:String): Boolean = {
    def helperFun(a:String,d:mutable.Stack[String]=mutable.Stack.empty):Boolean ={
      if ((a == "") || (a.head.toString ==")") && d.isEmpty) a == "" && d.isEmpty
      else{
        if (a.head.toString =="("){
          d.push(a.head.toString)
        }
        else if (a.head.toString == ")" && d.last == "(") d.pop()
        helperFun(a.tail,d)
      }
    }
    helperFun(s)
  }

}