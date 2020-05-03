package com.pdn.scalaLearn.泛型

object T26_上边界 {
  def main(args: Array[String]): Unit = {

    val man: Man = new Man("pp")
    val woMan: WoMan = new WoMan("dd")
    val person: PersonThere[String] = new PersonThere[String]("nn")

    val part: Part[PersonThere[String]] = new Part[PersonThere[String]](woMan, man)
    part.makeFriends()

  }
}

class Part[B <: PersonThere[String]](t1: B, t2: B) {
  def makeFriends(): Unit = {
    t1.hello
    t2.hello
  }
}
