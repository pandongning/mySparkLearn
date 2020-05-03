package com.pdn.scalaLearn.模式匹配

object T19_case_if {
  def main(args: Array[String]): Unit = {
    judgeGrade("A", "pp")
  }

  def judgeGrade(grade: String, name: String): Unit = {
    grade match {
      case "A" => {
        if (name == "pp")
          println(name + "\t" + "best")
        else
          println(name + "\t" + "haha")
      }
      case "B" if name == "pdn" => println("best")
      case _ => println("best")
    }
  }
}
