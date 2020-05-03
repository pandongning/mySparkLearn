package com.pdn.scalaLearn
import java.net.URL

import scala.io.BufferedSource
import scala.io.Source._

object T8_异常 {

  def main(args: Array[String]): Unit = {
    val url: URL = getClass.getClassLoader.getResource("stu.csv")
    val source: BufferedSource = fromFile(url.getPath)
    val string: String = source.mkString
    println(string)
  }
}
