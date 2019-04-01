package com.atguigu.chapter10

import scala.collection.mutable.ListBuffer

object ListDemo {
  /**
    * 可变list
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val lst0 = ListBuffer[Int](1, 2, 3)

    println("lst0(2)=" + lst0(2))
    for (item <- lst0) {
      println("item=" + item)
    }

    val lst1 = new ListBuffer[Int]
    lst1 += 4
    lst1.append(5)

    lst0 ++= lst1
    println(lst1)
    println(lst0)

    val lst2 = lst0 ++ lst1
    println(lst2)
    val lst3 = lst0 :+ 5
    println(lst3)

    println("=====删除=======")
    println("lst1=" + lst1)
    lst1.remove(1)
    for (item <- lst1) {
      println("item=" + item)
    }

  }
  /**
    * 1.符号::表示向集合中  新建集合添加元素。
    * 2.运算时，集合对象一定要放置在最右边，
    * 3.运算规则，从右向左。
    * 4.::: 运算符是将集合中的每一个元素加入到空集合中去
    *
    * @param args
    */

  def main2(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, "abc")

    val list2 = 4 :: 5 :: 6 :: list1 :: Nil
    println(list2)
    //下面等价 4 :: 5 :: 6 :: list1
    val list3 = 4 :: 5 :: 6 :: list1 ::: Nil
    println(list3)

  }
  /**
    * 说明
    *     1. 在默认情况下 List 是scala.collection.immutable.List,即不可变
    *     2. 在scala中,List就是不可变的，如需要使用可变的List,则使用ListBuffer
    *     3. List 在 package object scala 做了 val List = scala.collection.immutable.List
    *     4. val Nil = scala.collection.immutable.Nil // List()
    * @param args
    */
  def main1(args: Array[String]): Unit = {


    val list1 = List(1, 2, 3) //创建时，直接分配元素
    println(list1)
    val list2 = Nil  //空集合
    println(list2)

    //访问List的元素
    val value1 = list1(1) // 1是索引，表示取出第2个元素.
    println("value1=" + value1) // 2


    // :+运算符表示在列表的最后增加数据
    val list3 = list1 :+ 4
    println(list1) //list1没有变化
    println(list3) //新的列表结果是 [1, 2, 3, "abc", 4]

    // :+运算符表示在列表的最后增加数据
    val list4 = 4 +: list1
    println(list1) //list1没有变化
    println(list4) //新的列表结果是?

  }
}
