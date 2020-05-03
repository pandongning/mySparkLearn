package com.pdn.scalaLearn

object T15_Trait {

  def main(args: Array[String]): Unit = {
    val messageImpl: PrintMessageImpl = new PrintMessageImpl("pp")
    messageImpl.hello()
  }
}

class PrintMessageImpl(message: String) extends PrintMessage {

  override var name: String = "MM"

  override def hello(): Unit = {
    println(message + "pdn" + "\t" + name)
  }


  say(message)
}

trait PrintMessage {
  var name: String

  def say(mess: String): Unit = {
    println(mess + "\t" + name)
  }

  def hello(): Unit
}
