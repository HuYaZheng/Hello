package com.atguigu.day01

import scala.io.StdIn
import scala.util.control.Breaks
import util.control.Breaks._

object Bastic {
  def main9(args: Array[String]): Unit = {
    Breaks.breakable {
      for (i <- 1 to 3) {
        print("用户名:")
        var name = StdIn.readLine
        print("密码:")
        var password = StdIn.readLine
        if (name.equals("张无忌") && password.equals("888")) {
          println("登录成功!")
          Breaks.break
        } else {
          var n = 3 - i
          if (n == 0) {
            println("账号冻结")
          } else {
            println("您还有" + (3 - i) + "次机会")
          }
        }
      }
    }
  }



  def main(args: Array[String]): Unit = {
    var n = 1
    //    def breakable(op: => Unit) {
    //      try {
    //        op
    //      } catch {
    //        case ex: BreakControl =>
    //          if (ex ne breakException) throw ex
    //      }
    //    }
    //1.breakable 是一个高级函数:可以接收函数的函数就是高阶函数
    //2.()内的程序相当于一个代码块
    //3.breakable 对 break() 抛出的异常做了处理
    breakable(
    while (n < 10){
      n += 1
      println("n = " + n )
      if (n == 18)
        break() //def break(): Nothing = { throw breakException }
    }
    )
    println("结束了")
  }



  def main8(args: Array[String]): Unit = {
    for (i <- 2 to 100){
      for (j <- 2 to i){
        if (i % j == 0 ) {
          print(i + " ")
        }
      }
    }
  }

  def main7(args: Array[String]): Unit = {
    //scala中的循环守卫类似于Java中的continue
    for (i <- 1 to 100 if i % 3 == 1 ) print(i + " ")
  }


  def main6(args: Array[String]): Unit = {
    var n = StdIn.readInt()
    var m = StdIn.readInt()
    for ( i <- 1 to n; j <- 1 to m) {
      print("*")
      if (j == m)
        println()
    }
  }

  def main5(args: Array[String]): Unit = {
    for (i <- 1 to StdIn.readInt();j = 10 - i) print(j + " ")
  }

  def main4(args: Array[String]): Unit = {
    for (i <- 1 to 10) println(i)
  }

  def main3(args: Array[String]): Unit = {
    var year = StdIn.readInt()
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) println("闰年") else println("平年")
  }

  def main2(args: Array[String]): Unit = {
    var n1 = StdIn.readInt()
    var n2 = StdIn.readInt()
    var n3 = StdIn.readInt()

    if (n1 > n2 && n2 > n3) println(n1) else if (n2 > n3) println(n2) else println(n3)
  }


  def main1(args: Array[String]): Unit = {
  println("hello,brother")
  }


}
