package com.pdn.scalaLearn.模式匹配

object T20_模式匹配中进行变量赋值 {

  def main(args: Array[String]): Unit = {
    judgeGrade("A")
    judgeGrade("D")
  }

  def judgeGrade(grade: String): Unit = {
    grade match {
      case "A" => println(grade + "\t" + "beast")
      case "B" => println("good")
      case "C" => println("ok")
      case _ => println(grade + "\t" + "come on")
    }
  }
}
