package com.atguigu.chapter09

object ImplicitDemo {
  implicit def f1(mySQL: MySQL): DB = {
    new DB
  }

  def main(args: Array[String]): Unit = {

   val my = new MySQL
    my.insert()
    my.delete()

    implicit val name :String = "harry"
    def hello(implicit name: String): Unit = {
      println(name + "hello")
    }

    hello
  }

}


class DB{
  def delete()={
    println("delete")
  }
}

class MySQL{
  def insert()={
    println("insert")
  }
}