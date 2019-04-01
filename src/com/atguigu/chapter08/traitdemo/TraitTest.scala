package com.atguigu.chapter08.traitdemo

/**
  * trait 等价于(interface + abstract class)
  * 在scala中，java中的接口可以当做特质使用
  * 特质可以同时拥有抽象方法和具体方法，一个类可以实现/继承多个特质
  *
  * 当一个trait有抽象方法和非抽象方法时
  * 1. 一个trait在底层对应两个: Test.class Test接口(包含所有抽象方法及属性)
  *                           Test$class.class Test$class抽象类(包含普通方法及属性)
  * 2.一个类继承一个Trait时,会继承其所有的属性及方法(即普通方法和抽象方法)
  *
  * 动态/静态混入
  * 1.静态混入:在混入特质时,该对象还没有创建
  * 2.动态混入:在混入特质时,该对象已经创建
  */
trait Test {

  var name : String
  var age : Int = 10

  def getName():String= this.name
  def getAge
}

class A {
  def test(): Unit ={
    println("老子是class A 类test()")
  }
}

class B extends A with Test {
  override var name: String = "小白"

  def getAge: Unit ={
    println("age:"+ age)
  }
}

object TraitTest{
  def main(args: Array[String]): Unit = {
    val b = new B
    println(b.age)
    println(b.name)
    println(b.getName)
    b.getAge
    b.test()

  }
}
