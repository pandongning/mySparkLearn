package com.pdn.scalaLearn.类


object DemoOne {

  def main(args: Array[String]): Unit = {

    //    val person: PersonTest = new PersonTest("pp", "man")
    //    println(person.toString)

    var student = new StudentTwo("aa", "man")
    student.age = 20
    val myName = student.sayName()
    println(student.age + "\t" + myName + "\t" + student.sex)

  }
}

//由于name参数没加var或者val修饰，所以name只是一个构造函数的参数，如果要获得，则必须使用下面的sayName
//sex被var修饰，则sex可以直接被认为是类的一个字段
//address被val修饰，则必须赋予值
class StudentTwo(name: String, var sex: String) {
  var age: Int = _
  val address: String = "213"


  def sayName(): String = {
    name
  }

}

class PersonTest(hobbby: String) {

  private var name: String = "pdn"
  protected var age: Int = 23
  var sex: String = "man"
  val height: Int = 186
//  https://blog.csdn.net/dingyufei615/article/details/106769187/ 这个文档学习
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



