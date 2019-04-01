package com.atguigu.chapter13

object PartialFunction {
  //简写一
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 3.4, "hello")
    val list2 = list.collect {
      case n: Int => n + 1
      case m: Double => (m * 2).toInt
    }
    println(list2)
  }



  //简写二
  def main3(args: Array[String]): Unit = {
    def part: PartialFunction[Any, Int] = {
      case n: Int => n + 1
    }

    val list = List(1, 2, 3, 4, "hello")
    val list2 = list.collect(part)

    println(list2)
  }


  //偏函数
  def main2(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "hello")

    val partialFunction = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int]

      override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
    }

    val ints = list.collect(partialFunction)
    print(ints)

  }

  //常规方法
  def main1(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "hello")

    def f1(n: Any): Boolean = {
      n.isInstanceOf[Int]
    }

    def f2(n: Any): Int = {
      n.asInstanceOf[Int]
    }

    def f3(n: Int): Int = {
      n + 1
    }

    println(list.filter(f1).map(f2).map(f3))
  }

}
