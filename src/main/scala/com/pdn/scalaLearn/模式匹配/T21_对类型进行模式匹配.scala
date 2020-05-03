package com.pdn.scalaLearn.模式匹配

object T21_对类型进行模式匹配 {
  import java.io._

  def processException(e: Exception) {
    e match {
      case e1: IllegalArgumentException => println("you have illegal arguments! exception is: " + e1)
      case e2: FileNotFoundException => println("cannot find the file you need read or write!, exception is: " + e2)
      case e3: IOException => println("you got an error while you were doing IO operation! exception is: " + e3)
      case _: Exception => println("cannot know which exception you have!" )
    }
  }

}
