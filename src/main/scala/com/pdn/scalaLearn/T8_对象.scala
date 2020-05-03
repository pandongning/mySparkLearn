package com.pdn.scalaLearn

object T8_对象 {
  def main(args: Array[String]): Unit = {
    //    多态，父类的引用复制给子类的实例
    val man: Person = new Man("man")
    val man2: Person = man
    println(man.name+"\t"+man2.name)
  }
}


class Person {
  var name: String = _
  var age: Int = _
}

class Man(var sex: String) extends Person {
  this.age = 23
  this.name = "pdn"
  this.sex = "man"
}



