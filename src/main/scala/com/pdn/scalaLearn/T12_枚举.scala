package com.pdn.scalaLearn

object T12_枚举 extends Enumeration {

  val SPRING = Value(0, "spring")
  val SUMMER = Value(1, "summer")
  val AUTUMN = Value(2, "autumn")
  val WINTER = Value(3, "winter")

  def main(args: Array[String]): Unit = {
    val autumn: T12_枚举.Value = T12_枚举.AUTUMN

    println(autumn)
  }

}
