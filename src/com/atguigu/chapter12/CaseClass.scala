package com.atguigu.chapter12

object CaseClass {
  def main(args: Array[String]): Unit = {
    val amt = new Currency(3000.0,"RMB")
    val amt2 = amt.copy() // 克隆,创建的对象和amt的属性一样
    println("amt2.value" + amt2.value + " amt2.unit= " + amt2.unit)
    println(amt2)

    val amt3 = amt.copy(value = 8000.0)
    println(amt3)

    val amt4 = amt.copy(unit = "美元")
    println(amt4)
  }

  def main1(args: Array[String]): Unit = {
    //该案例的作用就是体验使用样例类方式进行对象匹配简洁性
    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
      val result = amt match {
        //说明
        case Dollar(v) => "$" + v // $1000.0
        //说明
        case Currency(v, u) => v + " " + u // 1000.0 RMB
        case NoAmount => "" // ""
      }
      println(amt + ": " + result)
    }

  }
}

abstract class Amount
case class Dollar(value: Double) extends Amount    //样例类
case class Currency(value: Double, unit: String) extends Amount //样例类
case object NoAmount extends Amount  //样例类
//类型(对象) =序列化(serializable)==>字符串(1.你可以保存到文件中【freeze】2.反序列化,2网络传输)