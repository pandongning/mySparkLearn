package com.pdn.scalaLearn.模式匹配

class Person

case class Teacher(name: String, subject: String) extends Person

case class Student(name: String, classroom: String) extends Person


object T22_Case_Class与模式匹配 {

  def main(args: Array[String]): Unit = {
    judgeIdentify(Student("aa", "bb"))
  }

  def judgeIdentify(p: Person) {
    p match {
      case Teacher(name, subject) => println(name + subject)
      case Student(name, classroom) => println(name + classroom)
      case _ => println("hah")
    }
  }
}


