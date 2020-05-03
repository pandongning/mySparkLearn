package com.pdn.scalaLearn.模式匹配

object T23_Case_Option {
  private val map: Map[String, Int] = Map("pdn" -> 23, "pp" -> 24)

  def main(args: Array[String]): Unit = {
    matchMap("pdn")
    matchMap("hah")
  }

  def matchMap(name: String): Unit = {
    val age: Option[Int] = map.get(name)

    age match {
      case Some(grade) => println(grade)
      case None => println("没有对应的值")
    }
  }
}
