package Week1.Part_II.Exercise_2_Functions

import java.io.File
import scala.util.matching.Regex


object FileMatcher{
  private def filesHere: Array[File] = new File(".").listFiles()

  def getFileHere: Array[File] = filesHere


  // Initial implementation of code
  def filesEnding(query:String):Array[File] = filesHere.filter(_.toString.endsWith(query))
  def filesContaining(query:String):Array[File] = filesHere.filter(_.toString.contains(query))
  def filesRegex(query:String):Array[File] = filesHere.filter(x => new Regex(x.toString).matches(query))


  // Refactoring with filesMatching
  def filesMatching(exampleQuery:String,fn:(String,String) => Boolean):Array[File] = filesHere.filter(x => fn(exampleQuery,x.toString))

  def filesEndingII(query:String):Array[File] = filesMatching(query, (query,x) => x.endsWith(query))
  def filesContainingII(query:String):Array[File] = filesMatching(query, (query,x) => x.contains(query))
  def filesRegexII(query:String):Array[File] = filesMatching(query, (query,x) => new Regex(x).matches(query))

  def toString(arrOfFiles:Array[File]): String = arrOfFiles.mkString("[",",","]")

  // TODO: Work on additional implementation and convert to curried function


}