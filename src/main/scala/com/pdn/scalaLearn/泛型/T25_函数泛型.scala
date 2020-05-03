package com.pdn.scalaLearn.泛型

object T25_函数泛型 {
  def main(args: Array[String]): Unit = {
    say[String]("name", "man")
  }

  def say[T](name: T, sex: T): Unit = {
    println(name + "\t" + sex)
  }
}
