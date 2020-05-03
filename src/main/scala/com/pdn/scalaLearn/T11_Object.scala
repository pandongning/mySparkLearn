package com.pdn.scalaLearn

object T11_Object {
  var name: String = "pdn"

  def say(): Unit = {
    println(name)
  }

  println(s"name=$name")

  def apply(sex: String): T11_Object = new T11_Object(sex)

  def main(args: Array[String]): Unit = {
    val t11_Object: T11_Object = T11_Object("man")
    val t11_Object1: T11_Object = new T11_Object("woman")
    t11_Object.say()
    t11_Object1.say()
  }
}

class T11_Object(sex: String) {
  def say(): Unit = {
    println(sex)
  }
}
