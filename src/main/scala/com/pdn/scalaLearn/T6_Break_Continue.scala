package com.pdn.scalaLearn

import util.control.Breaks._

object T6_Break_Continue {

  def main(args: Array[String]): Unit = {

    var i: Int = 3
    breakable {
      while (i > 0) {
        println(s"i=$i")
        i -= 1
        if (i == 1) {
          break()
        }
      }
    }


    //    Scala内置控制结构特地也去掉了continue，是为了更好的适应函数化编程，可以使用if – else 或是 循环守卫实现continue的效果
    for (i <- 1 to 10 if (i % 2 == 0)) {
      println(i)
    }

  }
}
