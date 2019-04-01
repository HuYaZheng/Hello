package com.atguigu.chapter11

import scala.collection.mutable.ArrayBuffer

object Exercise {
  def main(args: Array[String]): Unit = {
    val list = List("abc atguigu ccc hello", "atguigu,hello,ccc,hello,abc", "atguigu", "aaa ccc hello atguigu")
    val list2 = list.flatMap(_.split(" |,")).groupBy(v=>v).map(t=>(t._1,t._2.size)).toList.sortBy(_._2)
    println(list2)


  }


  def main9(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    def charCount(map: Map[Char, Int], char: Char): Map[Char, Int] = {
      map + (char -> (map.getOrElse(char,0)+1))
    }

    val map = sentence.foldLeft(Map[Char,Int]())(charCount)
    println(map)
  }

  def main8(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    val chars = new ArrayBuffer[Char]()

    def array(arr: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
      arr.append(c)
      arr
    }

    sentence.foldLeft(chars)(array)

    println(chars)

  }

  def main7(args: Array[String]): Unit = {
    //普通函数
    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }

    //5 (1,2,3,4,5) =>(5, 4, 2, -1, -5, -10) //Vector(5, 4, 2, -1, -5, -10)
    val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
    println("i8=" + i8)

    //普通函数
    def add(num1: Int, num2: Int): Int = {
      num1 + num2
    }

    //(1,2,3,4,5) 5 => (20,19,17,14, 10,5)
    val i9 = (1 to 5).scanRight(5)(add) //IndexedSeq[Int]
    println("i9=" + i9)

  }


  def main6(args: Array[String]): Unit = {
    val list4 = List(1, 9)

    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }

    //foldLeft和foldRight 缩写方法分别是：/:和:\
    var i6 = (1 /: list4) (minus) // =等价=> list4.foldLeft(1)(minus)
    println("i6=" + i6)

    i6 = (100 /: list4) (minus) //=等价=> list4.foldLeft(100)(minus)
    println(i6) // 输出?

    i6 = (list4 :\ 10) (minus) // list4.foldRight(10)(minus)
    println(i6) // 输出? 2

  }

  def main5(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4)

    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }

    //说明
    //1. 折叠的理解和化简的运行机制几乎一样.
    //理解 list.foldLeft(5)(minus) 理解成 list(5,1, 2, 3, 4) list.reduceLeft(minus)

    //步骤  (5-1)
    //步骤  ((5-1) - 2)
    //步骤  (((5-1) - 2) - 3)
    //步骤  ((((5-1) - 2) - 3)) - 4 = - 5

    println(list.foldLeft(5)(minus)) // 函数的柯里化

    ////理解 list.foldRight(5)(minus) 理解成 list(1, 2, 3, 4, 5) list.reduceRight(minus)
    // 步骤 (4 - 5)
    // 步骤 (3- (4 - 5))
    // 步骤 (2 -(3- (4 - 5)))
    // 步骤 1- (2 -(3- (4 - 5))) = 3
    println(list.foldRight(5)(minus)) //
  }

  def main4(args: Array[String]): Unit = {
    /*
    使用化简的方式来计算list集合的和
     */
    val list = List(1, 20, 30, 4, 5)

    def sum(n1: Int, n2: Int): Int = {
      println("sum被调用~~")
      n1 + n2
    }

    val res = list.reduceLeft(sum) // reduce/reduceLeft/reduceRight

    //执行的流程分析
    //步骤 1 (1 + 20)
    //步骤 2 (1 + 20) + 30
    //步骤 3 ((1 + 20) + 30) + 4
    //步骤 4 (((1 + 20) + 30) + 4) + 5 = 60

    println("res=" + res) // 60

  }

  def main3(args: Array[String]): Unit = {
    /*
    选出首字母为A的元素
     */
    val names = List("Alice", "Bob", "Nick")

    def startA(str: String): Boolean = {
      str.startsWith("A")
    }

    val names2 = names.filter(startA)
    println("names=" + names)
    println("names2=" + names2)
  }


  def main2(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")

    def upper(s: String): String = {
      s.toUpperCase
    }

    val names2 = names.map(upper)
    println("names=" + names2)


  }

  def main1(args: Array[String]): Unit = {

    val names = List("Alice", "Bob", "Nick")

    def upper(s: String): String = {
      s.toUpperCase
    }

    //需求是将List集合中的所有元素，进行扁平化操作，即把所有元素打散
    val names2 = names.flatMap(upper)
    println("names2=" + names2)


  }

}
