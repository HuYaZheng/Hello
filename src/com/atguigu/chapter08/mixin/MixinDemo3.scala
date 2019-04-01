package com.atguigu.chapter08.mixin

/**
  * 经典案例Super应用
  *
  */
object MixinDemo3 {
  def main(args: Array[String]): Unit = {
    val mysql6 = new MySQL6 with DB5  with File5
    mysql6.insert(3243)
  }
}

trait Operate5 {
  def insert(id : Int)

}
trait File5 extends Operate5 {

  abstract override  def insert( id : Int ): Unit = {
    println("将数据保存到文件中..")
    super.insert(id)
  }
}

trait DB5 extends  Operate5 {
  def insert( id : Int ): Unit = {
    println("将数据保存到数据库中..")
  }
}
class MySQL6{}

