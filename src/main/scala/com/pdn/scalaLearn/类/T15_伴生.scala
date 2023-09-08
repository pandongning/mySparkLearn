package com.pdn.scalaLearn.类

object T15_伴生 {
  def apply(name: String) = new T15_伴生(name)

  def main(args: Array[String]): Unit = {
    T15_伴生("pdn").say()
  }
}

class T15_伴生(var name: String) {
  def say(): Unit = {
    println(name)
  }
}
