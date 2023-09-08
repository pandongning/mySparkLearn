package com.pdn.scalaLearn

import scala.collection.immutable

object T4_For {

  def main(args: Array[String]): Unit = {
//    for (i <- 1 to 3) {
//      println(i + "aa")
//    }

//    for (i <- 1 until (3)) {
//      println(i + "aa")
//    }
//
//    for (i <- 1 until (3) if i != 2) {
//      println(i + "aa")
//    }
//
//    //    引入变量
//    for (i <- 1 to 3; j = 4 - i) {
//      println(s"j=$j")
//    }
//
//    //嵌套循环
//    for (i <- 1 to 3; j <- 1 to 3) {
//      println(s"i=$i  j=$j")
//    }
//
//
    //    循环返回值
//    val ints: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield i * 2
//    ints.foreach(x => println(x))

    //    步长
    for (i <- Range(1, 10, 2)) {
      println(s"i=$i")
    }

  }
}
