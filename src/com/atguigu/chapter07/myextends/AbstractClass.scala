package com.atguigu.chapter07.myextends

object AbstractClass {
  def main(args: Array[String]): Unit = {
    val implement = new AbstractImplement
    implement.info

    val abstractDemo = new AbstractDemo {

      override var name: String = "小明"
      override var age: Int = 10

      override def info(): Unit = {
        println("信息如下:" + "\n 姓名:" + name + "\n 年纪:" + age)
      }
    }
    abstractDemo.info
  }
}


abstract class AbstractDemo{
  var name:String
  var age : Int // 抽象的字段
  var color : String = "black" //普通属性
  def info() //抽象方法,不需要标记 abstract
  def print(): Unit ={
    println("hahahahaha")
  }
}

class AbstractImplement extends AbstractDemo{

  override var name: String = "小明"
  override var age: Int = 10
  override def info(): Unit = {
    println("信息如下:" + "\n 姓名:"+ name + "\n 年纪:" + age )
  }
}
