package com.pdn.scalaLearn.隐式转换



object T2_参数类型不符合 {


  def main(args: Array[String]): Unit = {
    // 导入了 commonPersonToSuperMan的隐式转换
    import T1_增强现有的类.commonPersonToSuperMan
    buySpecialTicket(new CommonPerson("pp"))
  }

  def buySpecialTicket(p: SuperMan): Unit = {
    p.say()
  }
}
