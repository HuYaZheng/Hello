package com.atguigu.chapter08.exer


class Frock {
  val serialNumber : Int = Frock.getNextNum

}

object Frock {

  var currentNum : Int = 100000

  def getNextNum():Int = {
    currentNum += 100
    currentNum
  }

  def apply(): Frock = new Frock()
}

object TestFrock{
  def main(args: Array[String]): Unit = {
    println(Frock.getNextNum())

    val frock1 = Frock()
    println(frock1.serialNumber)

    val frock2 = Frock()
    println(frock2.serialNumber)

    val frock3 = Frock()
    println(frock3.serialNumber)


  }
}