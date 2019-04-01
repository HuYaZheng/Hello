package com.atguigu.chapter10

/**
  * 1.元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据
  * 2.元组中最大只能有22个元素
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    val tuple1 = (1, 2, 3, "hello", 4)
    println(tuple1)

    val tuple2 = (1, "a", "b", true, 2)
    println(tuple2._1) //访问元组的第一个元素 ，从1开始
    println(tuple2.productElement(0)) // 访问元组的第一个元素，从0开始


    for (t <- tuple2.productIterator){
      print (t + "\t")
    }
    println()
  }

}
