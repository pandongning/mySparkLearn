package com.pdn.scalaLearn

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object T9_Array {

  def main(args: Array[String]): Unit = {

    val strings: Array[String] = new Array[String](3)
    strings(0) = "a"
    strings(1) = "b"
    strings(2) = "c"
    strings.foreach((x: String) => println(x))

    val buffer: ArrayBuffer[String] = new ArrayBuffer[String]();
    buffer.+=("aa")
    buffer.+=:("bb")
    buffer.++=(mutable.Set("cc", "dd"))
    buffer.insert(2, "ee")
    println(buffer)

    //    简单遍历
    buffer.foreach(x => print(x + "\t"))

    //    遍历
    for (elem <- buffer) {
      print(elem + "\t")
    }

    for (i <- buffer.indices.reverse){
      println(buffer(i))
    }

    val strings2: Array[String] = Array[String]("a", "b")
    val ints: Array[Int] = Array[Int](1, 2)
    val tuples: Array[(String, Int)] = strings2.zip(ints)
    for (elem <- tuples) {
      println(elem._1 + "\t" + elem._2)
    }

  }
}
