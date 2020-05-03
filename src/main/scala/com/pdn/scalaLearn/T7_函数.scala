package com.pdn.scalaLearn

object T7_函数 {

  def main(args: Array[String]): Unit = {
    val i: Int = sum(i2 = 2, i1 = 3)
    val i1: Int = sum(1, 2, 3, 4)

    val i2: Int = sum(1, 1 to 5: _*)
    println(i + "\t" + i1 + "\t" + i2)
  }

  def sum(i1: Int, i2: Int = 2): Int = {
    i1 + i2
  }

  def sum(i1: Int, i3: Int*): Int = {
    val list: List[Int] = i3.toList
    list.sum + i1
  }
}
