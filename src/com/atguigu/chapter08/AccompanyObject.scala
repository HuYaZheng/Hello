package com.atguigu.chapter08

object AccompanyObject {
  def main(args: Array[String]): Unit = {


    val person = new ScalaPerson
    person.say()
  }

}

class ScalaPerson {
  private val name : String = ""
  def say(): Unit ={
    println("我是伴生类")
  }
}
//类中的私有属性可以通过伴生对象来访问
object ScalaPerson {
  def say(n : ScalaPerson): Unit ={
    println("我是伴生对象" + n.name)
  }
}