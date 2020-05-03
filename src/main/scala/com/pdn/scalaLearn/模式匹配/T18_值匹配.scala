package com.pdn.scalaLearn.模式匹配

object T18_值匹配 {

  def main(args: Array[String]): Unit = {
    judgeGrade("D")
    judgeGrade("B")
  }

  def judgeGrade(grade: String): Unit = {
    grade match {
      case "A" => println("beast")
      case "B" => println("good")
      case "C" => println("ok")
      case _ => println("come on")
    }
  }
}
