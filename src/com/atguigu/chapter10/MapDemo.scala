package com.atguigu.chapter10

import scala.collection.mutable

object MapDemo {
  def main(args: Array[String]): Unit = {
    /**方式一:不可变映射
      * 1.默认Map是 immutable.Map
      * 2.key-value 类型支持Any
      * 3.在Map的底层，每对key-value是Tuple2
      * 4.Map(Alice -> 10, Bob -> 20, Kotlin -> 北京)
      */

    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map1)

    /**方式二:可变映射
      * 1.Map(Bob -> 20, Kotlin -> 北京, Alice -> 10)
      * 2.可实现映射内容的修改
      *
      */
    val map2 = mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map2)

    /**方式三:创建空的映射
      *
      */
    val map3 = new mutable.HashMap[String,Int]
    println(map3)

    /**方式四:对偶元组
      *
      */

    val map4 = mutable.Map(("Alice" , 10), ("Bob" , 20), ("Kotlin" , "北京"))
    println(map4)

    //////////////////////////////////根据key查询value/////////////////////////////////////////
    /**方式1-使用map(key)
      * 说明:
      * 1)如果key存在，则返回对应的值
      * 2)如果key不存在，则抛出异常[java.util.NoSuchElementException]
      * 在Java中,如果key不存在则返回null
      */
    val value1 = map4("Alice")
    println(value1)

    /**
      * 方式二:使用contains方法检查是否存在key
      */
    if (map4.contains("Alice")) {
      println("key存在，值=" + map4("Alice"))
    } else {
      println("key不存在:)")
    }

    /**
      * 方式三:使用map.get(key).get取值
      *   1)map.get方法会将数据进行包装
      *   2)如果 map.get(key) key存在返回some,如果key不存在，则返回None
      *   3)如果 map.get(key).get  key存在，返回key对应的值,否则，抛出异常 java.util.NoSuchElementException: None.get
      */
    println(map4.get("Alice").get)
    //println(map4.get("Alicesd").get)//Exception in thread "main" java.util.NoSuchElementException: None.get

    /**
      *方式四:使用map4.getOrElse()取值
      */
    println(map4.getOrElse("Alice","默认的值 鱼 <・)))><<"))

    /////////////////////////////////////////map的更新,添加及删除//////////////////////////////////////////////////
    println(map4)
    map4("Harry") = 22 //添加
    println(map4)

    map4 += ("Jack" -> 10,"Joy" -> 34)
    println(map4)

    val map5 = map4 + ("Jack" -> 10)
    println("map5 = " + map5)

    map4("Alice") = 70 //修改
    println(map4)

    map4 -= ("Jack","Joy")//删除
    println(map4)


    //////////////////////////////map的遍历////////////////////////////////
    println(map4)
    println("----(k, v) <- map4--------")
    for ((k, v) <- map4) println(k + " is mapped to " + v)

    println("----v <- map4.keys--------")
    for (v <- map4.keys) println(v)

    println("----v <- map4.values--------")
    for (v <- map4.values) println(v)

    //这样取出方式 v 类型是 Tuple2
    println("----v <- map4--------")
    for (v <- map4) println(v + " key =" + v._1 + " val=" + v._2)


  }
}
