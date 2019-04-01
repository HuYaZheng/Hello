package com.atguigu.chapter08.mixin

/**
  * 1.特质也有类的概念,混入多个特质时,会首先从后面的特质开始执行(即从左到右)
  * 2.当我们执行一个动态混入对象的方法时
  *     (1)从右到左开始执行
  *     (2)当执行到super时,是指的左边的特质
  *     (3)如果左边没有特质了,则super就是父特质
  *
  */

object MixinDemo2 {
  def main(args: Array[String]): Unit = {

    val mySQL = new MySQL5 with DB4 with File4

    println(mySQL)

    mySQL.insert(3245)
  }

}


trait Operate4 { //特点
  println("Operate4...")

  def insert(id: Int) //抽象方法
}

trait Data4 extends Operate4 { //特质，继承了Operate4
  println("Data4")

  override def insert(id: Int): Unit = { //实现/重写 Operate4 的insert
    println("插入数据 = " + id)
  }
}

trait DB4 extends Data4 { //特质，继承 Data4
  println("DB4")

  override def insert(id: Int): Unit = { // 重写 Data4 的insert
    println("向数据库")
    super.insert(id)
  }
}

trait File4 extends Data4 { //特质，继承 Data4
  println("File4")

  override def insert(id: Int): Unit = { // 重写 Data4 的insert
    println("向文件")
    //super.insert(id) //调用了insert方法(难点)，这里super在动态混入时，不一定是父类
    super[Data4].insert(id) //使用super[a]时, a必须是当前特质的直接父特质
  }
}

class MySQL5  {} //普通类