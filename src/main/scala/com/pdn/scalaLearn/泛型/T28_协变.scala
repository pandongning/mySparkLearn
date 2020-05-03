package com.pdn.scalaLearn.泛型

object T28_协变 {
  def main(args: Array[String]): Unit = {
    val pp: WoMan = new WoMan("pp")
    meeting(new Card[PersonThere[String]](pp))
  }

  def meeting(card: Card[PersonThere[String]]): Unit = {

  }
}


class Card[+T](person: T) {

}

