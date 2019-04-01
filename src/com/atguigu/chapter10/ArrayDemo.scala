package com.atguigu.chapter10

import scala.collection.mutable.ArrayBuffer

object ArrayDemo {
  /**
    * Scala数组转Java的List
    * Java的List转Scala数组(mutable.Buffer)
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer("1", "2", "3")

    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr) //为什么可以这样使用?

    val arrList = javaArr.command()
    println(arrList) //输出 [1, 2, 3]


    //java的List 转成 scala的 ArrayBuffer
    //1. asScalaBuffer 是一个隐式函数
    //implicit def asScalaBuffer[A](l : java.util.List[A]) : scala.collection.mutable.Buffer[A] = { /* compiled code */ }

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    //java.util.List ==> Buffer
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")
    scalaArr.append("tom")
    scalaArr.remove(0)
    println(scalaArr) // (2,3,jack,tom)
  }


  /**
    * 多维数组的定义和使用
    * @param args
    */
  def main3(args: Array[String]): Unit = {
    val array1 = Array.ofDim[Int](3, 4)
    array1(1)(1) = 9
    for (item <- array1) {
      for (item2 <- item) {
        print(item2 + "\t")
      }
      println()
    }
    println("===================")
    for (i <- 0 to array1.length - 1) {
      for (j <- 0 to array1(i).length - 1) {
        printf("arr[%d][%d]=%d\t", i, j, array1(i)(j))
      }
      println()
    }

  }
  /**变长数组
    * 1.ArrayBuffer是变长数组，类似java的ArrayList
    * 2.val arr2 = ArrayBuffer[Int]() 也是使用的apply方法构建对象
    * 3.def append(elems: A*) { appendAll(elems) } 接收的是可变参数.
    * 4.每append一次，arr在底层会重新分配空间，进行扩容，arr2的内存地址会发生变化，也就成为新的ArrayBuffer
    * 5.arr1.toBuffer  //定长数组转可变数组
    * 6.arr2.toArray  //可变数组转定长数组
    *
    */
  def main2(args: Array[String]): Unit = {
    val arr01 = ArrayBuffer[Any](3, 2, 5)
    println("arr01(1)=" + arr01(1))

    for (i <- arr01) {
      println(i)
    }
    println(arr01.length)

    println("arr01.hash=" + arr01.hashCode())

    arr01.append(90.0,13)
    println("arr01.hash=" + arr01.hashCode())

    arr01(1) = 89 //修改
    println("--------------------------")
    for (i <- arr01) {
      println(i)
    }

    //删除
    arr01.remove(0)
    println("--------------------------")
    for (i <- arr01) {
      println(i)
    }
    println("最新的长度=" + arr01.length)

  }


  /**
    * 定长数组
    * @param args
    */
  def main1(args: Array[String]): Unit = {

    //第一种方式定义数组
    val arr01 = new Array[Int](4)
    println(arr01.length)

    println("arr01(0)=" + arr01(0))
    for (i <- arr01) {
      println(i)
    }

    println("--------------------")
    arr01(3) = 10
    for (i <- arr01) {
      println(i)
    }

    //第二种方式定义数组
    var arr02 = Array(1, 3, "xxx")
    for (i <- arr02) {
      println(i)
    }


  }
}
