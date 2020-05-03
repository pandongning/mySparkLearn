package com.pdn.scalaLearn.泛型


object T27_ViewBounds {
  implicit def dog2person(dog: Dog): PersonThere[String] = new PersonThere[String](dog.name)

  def main(args: Array[String]): Unit = {
    val dog: Dog = new Dog("wang")
    val part: Part[PersonThere[String]] = new Part[PersonThere[String]](new Man("pp"), dog)
    part.makeFriends()
  }
}





