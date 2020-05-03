package com.pdn.spark

import com.pdn.scalaLearn.Person

object Tt {
  def main(args: Array[String]): Unit = {
    val person: Person = new Person
    person.age = 30
    person.name = "pp"
    println(person.name)
  }

}
