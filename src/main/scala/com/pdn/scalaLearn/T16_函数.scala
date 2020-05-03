package com.pdn.scalaLearn

object T16_函数 {

  def say(mess: String): Unit = {
    println(mess)
  }

  private val function: String => Unit = say

  def main(args: Array[String]): Unit = {
    function("aa")
  }
}
