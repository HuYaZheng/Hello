package com.atguigu.chapter10

import scala.collection.mutable

/**
  * 集是不重复元素的结合。集不保留顺序，默认是以哈希集实现
  * 如果添加的对象已经存在，则不会重复添加，也不会报错
  * 如果删除的对象不存在，则不生效，也不会报错
  */

object SetDemo {
  def main(args: Array[String]): Unit = {
    val set = Set(1, 2, 3) //不可变
    println(set)

    val mutableSet = mutable.Set(1, 2, 3) //可变
    println(mutableSet)
    //添加
    mutableSet.add(4)
    mutableSet += 6
    mutableSet.+=(5)
    println(mutableSet)

    //删除
    mutableSet -= 6
    mutableSet.remove(5)
    println(mutableSet)

    for(x <- mutableSet) {
      println(x)
    }



  }

}
