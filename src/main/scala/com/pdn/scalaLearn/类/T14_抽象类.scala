package com.pdn.scalaLearn.类

object T14_抽象类 {

}

abstract class Car {
  var color: String = "red"

  def run(): Unit
}



class MyCar extends Car {
  override def run(): Unit = {
    println(this.color)
  }
}