package com.atguigu.chapter06.oop.exer

import scala.collection.mutable

object Homework {
  def main(args: Array[String]): Unit = {
    var t = {}
    println(t + " " + t.isInstanceOf[Unit])

    for(i <- 0 to 10 reverse) print(i + "\t")

    (0 to 10).reverse.foreach(println)

    var res:Long = 1
    for (i <- "hello") res *= i.toLong
    println("res:" + res )

    var res2:Long = 1
    "hello".foreach(res2 *= _.toLong)
    println("res:" + res2)

    println(product("hello"))

    val q1 = new mutable.Queue[Int]
    q1 ++= List(1,3,4,0)
    println(q1)
    println(q1.tail)

  }

//  def reverse(q : mutable.Queue[Int]):mutable.Queue[Int]={
//    if (q.tail.size == 1) {
//      return q
//    }else {
//      reverse(q.tail).enqueue(q.dequeue)
//    }
//  }

  def product(s:String): Long = {
    //take()拿出一个字符串中第n个字符,drop(n)丢弃一个字符串中的第n个字符
    if (s.length == 1) s.charAt(0).toLong else s.take(1).charAt(0).toLong * product(s.drop(1))
  }






}
