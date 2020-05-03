package com.pdn.scalaLearn.类

object T13_继承 {

  def main(args: Array[String]): Unit = {
    val person: Person = new Person("man")
    val student: Student = new Student(23, 186)

    println(student.isInstanceOf[Person])
    println(person.isInstanceOf[Student])
    if (student.isInstanceOf[Person]) {
      val person1: Person = student.asInstanceOf[Person]
      println(person1)
    }

    println(person.getClass == classOf[Student])
    println(person.getClass == classOf[Person])


    student.hello()
  }
}

class Person(var sex: String) {
  private var name: String = "pdn"
  var age: Int = 23
  protected var address: String = "xunyi"
  final var height: Int = 186

  def say(): Unit = {
    println(name + "\t" + age + "\t" + address + "\t" + this.sex)
  }
}

//此处在继承父类的时候，必须引用父类的主构造函数
class Student(age: Int, heigth: Int) extends Person("man") {

  //  override var height: Int = 165

  def hello(): Unit = {
    println(this.address + "\t" + this.age + "\t" + this.sex)
  }

  override def say(): Unit = {
    this.height = 180
    println(this.age + this.address + "\t" + this.height)
  }

}
