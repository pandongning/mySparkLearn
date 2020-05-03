package com.pdn.scalaLearn

object T18_Option {

  def main(args: Array[String]): Unit = {

    val grades: Map[String, String] = Map("Leo" -> "A", "Jack" -> "B", "Jen" -> "C")
    val option: Option[String] = grades.get("Leo")
    println(Some(option))
    println(option.get)
    println(option.getOrElse("$$"))
    val maybeString: Option[String] = grades.get("pdn")
    println(Some(maybeString))
    println(maybeString.isEmpty)


    println(Some(2/1).get)
  }
}
