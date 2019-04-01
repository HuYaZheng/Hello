package com.atguigu.chapter07.visit

object TestVisit {
  def main(args: Array[String]): Unit = {
    val  c = new Clerk()
    c.showInfo()
    Clerk.test(c)
  }
}

/**
  * 1.private为私有权限,只能子类的内部和伴生对象中使用
  * 2.private[atguigu] var sal : "haha" , 即将sal属性的访问权限扩大到atguigu包及其子包
  * 3.protected为受保护权限,Scala中受保护权限比Java中更严格,只能子类访问,同包无法访问
  * 4.Scala中没有public关键字
  */
class Clerk {
  var name : String = "jack"
  private var sal : Double = 9999.9
  def showInfo(): Unit = {
    println(" name " + name + " sal= " + sal)
  }
}

/**
  * 1.class Clerk 称为伴生类
  * 2.object Clerk 称为伴生对象
  * 3.伴生类 写非静态的内容
  * 4.伴生对象 写静态的内容
  */
object Clerk{
  def test(c : Clerk): Unit = {
    //这里体现出在伴生对象中，可以访问c.sal
    println("test() name=" + c.name + " sal= " + c.sal)
  }
}
