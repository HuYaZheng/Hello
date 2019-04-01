package com.atguigu.chapter08.mixin

/**
  * 动态混入
  */

object MixinDemo {
  def main(args: Array[String]): Unit = {
    val oracleDB = new OracleDB with Operate3 {
      override var name: Int = _
    }
    oracleDB.insert(3423)

    val mySQL = new MySQL3 with Operate3 {
      override var name: Int = _
    }
    mySQL.insert(6789)

    val mySQL4 = new MySQL4 with Operate3 {
      override def insert(): Unit = println("insert")

      override var name: Int = _
    }
    mySQL4.insert(324)


  }

}


trait Operate3 { //特质
  var name : Int
  def insert(id: Int): Unit = { //方法（实现）
    println("插入数据 = " + id)
  }
}

class OracleDB { //空
}

abstract class MySQL3 { //空
}

abstract class MySQL4 { //空
  def insert()
}