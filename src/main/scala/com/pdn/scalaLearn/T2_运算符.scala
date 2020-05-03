package com.pdn.scalaLearn

object T2_运算符 {
  def main(args: Array[String]): Unit = {
    val i: Int = 10 / 3
    val i1: Int = 10 % 3
    var i3 = 2
    i3 <<= 2
    println(s"i3=$i3")
    println(i + "\t" + i1)
  }
}
