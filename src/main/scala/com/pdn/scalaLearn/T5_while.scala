package com.pdn.scalaLearn

object T5_while {

  def main(args: Array[String]): Unit = {
    var i: Int = 3
    while (i > 0) {
      println(s"i=$i")
      i -= 1
    }
  }
}
