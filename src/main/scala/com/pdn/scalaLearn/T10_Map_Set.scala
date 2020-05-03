package com.pdn.scalaLearn

import scala.collection.mutable

object T10_Map_Set {
  def main(args: Array[String]): Unit = {
    val map: mutable.Map[String, Int] = mutable.Map[String, Int]()
    map.+=(("pdn", 23))
    map.+=(("pdn2", 25))
    map.+=(("pdn3", 24))
    //    修改
    map("pdn") = 26

    val i: Int = map.getOrElse("pdn", 24)
    println(i)

    for ((name, age) <- map) {
      println(name + "\t" + age)
    }

    for (elem <- map.keys) {
      println(elem + "\t" + map.getOrElse(elem, "30"))
    }


    val ints: mutable.LinkedHashSet[Int] = mutable.LinkedHashSet[Int](1, 1, 2)
    println(ints)

  }
}
