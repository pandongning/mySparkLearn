package com.pdn.scalaLearn.类


object DemoOne {

  def main(args: Array[String]): Unit = {

    val person: PersonTest = new PersonTest("pp", "man")
    println(person.toString)


  }
}

class PersonTest(hobbby: String) {

  private var name: String = "pdn"
  protected var age: Int = 23
  var sex: String = "man"
  val height: Int = 186
  private[this] var address: String = "xunyi"

  def this(hobbby: String, name: String) {
    this(hobbby)
    this.name = name
  }


  def say(): Unit = {
    println(name + "\t" + age + "\t" + address)
  }

  def setName(name: String): Unit = {
    this.name = name
  }

  def getName: String = {
    this.name
  }

  def setAddress(address: String): Unit = {
    this.address = address
  }


  override def toString: String = s"Person($name, $age, $sex, $height, $address,$hobbby)"
}



