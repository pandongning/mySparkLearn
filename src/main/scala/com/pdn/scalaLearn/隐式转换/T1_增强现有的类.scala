package com.pdn.scalaLearn.隐式转换

object T1_增强现有的类 {

  implicit def commonPersonToSuperMan(man: CommonPerson): SuperMan = {
      new SuperMan(man.name)
  }

  def main(args: Array[String]): Unit = {
    new CommonPerson("pdn").say()
  }

}




