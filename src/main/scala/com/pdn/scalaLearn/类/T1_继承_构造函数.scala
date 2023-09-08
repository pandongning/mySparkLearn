package com.pdn.scalaLearn.类

object T1_继承_构造函数 {

  def main(args: Array[String]): Unit = {
    val b: B = new B()
    b.say()

    val c: C = new C()
    c.say()

    val d: D = new D("nn", 27)
    d.say()
  }
}


class A {
  var name: String = _
  var age: Int = _

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }

  def say(): Unit = {
    println(this.name + "\t" + this.age)
  }
}

//B调用A的辅助构造函数def this(name: String, age: Int)
//调用的时候指定固定的值
class B extends A("pdn", 23) {
}


//C def this(name: String)
class C extends A("pp") {
}


//D调用A的辅助构造函数def this(name: String, age: Int)
//创建D的时候再赋予A辅助构造函数的值，这样则能做到每次根据不同的需求，赋予不同的值
class D(name: String, age: Int) extends A(name, age){
}


