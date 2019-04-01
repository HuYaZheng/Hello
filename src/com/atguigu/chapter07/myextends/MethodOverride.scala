package com.atguigu.chapter07.myextends

object MethodOverride {
  def main(args: Array[String]): Unit = {

    val emp = new Emp
    println(emp.name)
    emp.sayHi()
    emp.printName()
  }
}

/**
  * 说明
  * 1. 在scala中，子类继承了父类的所有属性
  * 2. 但是private的属性和方法无法访问
  */

//Person类
class Person {
  var name: String = "tom"

  def printName() { //输出名字
    println("Person printName() " + name)
  }

  def sayHi(): Unit = {
    println("sayHi...")
  }
}

//这里我们继承Person
class Emp extends Person {
  //这里需要显式的使用override
  override def printName() {
    println("Emp printName() " + name)
    //在子类中需要去调用父类的方法,使用super
    super.printName()
    sayHi()
  }
}
