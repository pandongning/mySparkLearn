package com.pdn.scalaLearn.泛型

object T24_类泛型 {

  def main(args: Array[String]): Unit = {
    val pdn: PersonThere[String] = new PersonThere[String]("pdn")
    pdn.say()

  }
}

class PersonThere[T](var name: T) {
  def hello: Unit = {
    println("My name is" + name + "oh")
  }

  def say(): Unit = {
    println(name.getClass.getTypeName)
  }
}
