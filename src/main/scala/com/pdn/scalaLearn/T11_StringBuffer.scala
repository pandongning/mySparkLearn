package com.pdn.scalaLearn

object T11_StringBuffer {
  def main(args: Array[String]): Unit = {
    val buffer: StringBuffer = new StringBuffer()
    buffer.append("name")
    buffer.append("\t")
    buffer.append(23)

    val string: String = buffer.toString
    println(string)
  }
}
