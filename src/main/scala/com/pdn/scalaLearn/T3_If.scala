package com.pdn.scalaLearn

object T3_If {
  def main(args: Array[String]): Unit = {
    var score: Int = 20
    var sex: String = "man"

    if (score > 10) {
      println("pp")
      if (sex.equals("man")) {
        println("男生")
      }
    } else {
      println("dd")
    }

    if (score == 100) {
      println("aa")
    } else if (score > 60 && score < 100) {
      println("bb")
    } else {
      println("cc")
    }




  }
}
