package com.pdn.scalaLearn

object T1_数据类型 {
  def main(args: Array[String]): Unit = {
    var f1 = 2.3f
    var f2 = 5.12e2
    var f3: Int = 3
    val f4: Int = f3.+(4)
    var f5: Byte = 2
    var f6 = 240L
    var f7 = 'a'
    var f8 = '你'
    val f9 = f6 + 20 + f8
    var f10 = '\t'

    var f11: Boolean = true
    var f12 = null

    f6.toInt

    var f13 = "pdn"
    val list: List[Char] = f13.toList
    list.foreach((x: Char) => println(x))
    list.foreach((x: Char) => x + "aa")
    println(list)
    val strings: List[String] = list.map((x: Char) => x + "bb")
    println(strings)

    println(s"f1=$f1,f4=$f4,f5=$f5")
  }
}
