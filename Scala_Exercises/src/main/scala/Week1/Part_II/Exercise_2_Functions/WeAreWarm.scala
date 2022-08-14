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


  // Refactoring with filesMatching function
  def filesMatching(exampleQuery:String,fn:(String,String) => Boolean):Array[File] = filesHere.filter(x => fn(exampleQuery,x.toString))

  def filesEndingII(query:String):Array[File] = filesMatching(query, (query,x) => x.endsWith(query))
  def filesContainingII(query:String):Array[File] = filesMatching(query, (query,x) => x.contains(query))
  def filesRegexII(query:String):Array[File] = filesMatching(query, (query,x) => new Regex(x).matches(query))


  // A different function of my own
  def filesStarting(query:String):Array[File] = filesMatching(query, (query,x) => x.startsWith(query))
  def filesStartingWithCurried(query:String):Array[File] = filesMatchingII(query)((query,x) => x.startsWith(query))

  // Using Currying for the filesMatching
  def filesMatchingII(exampleQuery:String)(fn:(String,String) => Boolean):Array[File] = filesHere.filter(x => fn(exampleQuery,x.toString))

  def toString(arrOfFiles:Array[File]): String = arrOfFiles.mkString("[",",","]")


}