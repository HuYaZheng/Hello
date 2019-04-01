package com.atguigu.day01

import scala.io.StdIn

object HomeWork {
  def main(args: Array[String]): Unit = {
    var a = StdIn.readInt//高
    var b = 2*a - 1//宽
    for (i <- 1 to a){
      for (j <- 1 to b) {
        if ((a - i) >= j || (a + i) <= j) {
          print(" ")
        }else {
          print("*")
        }
      }
      println()
    }
  }

  def main1(args: Array[String]): Unit = {
    var a = StdIn.readDouble
    var b = StdIn.readDouble
    var c = StdIn.readDouble

    var x1 = (-b + math.sqrt(b * b - 4 * a * c)) / 2 * a
    var x2 = (-b - math.sqrt(b * b - 4 * a * c)) / 2 * a

    if (b * b - 4 * a * c < 0) {
      println("方程" + a + "x^2 + " + b + "x + " + c + "= 0" + "无解")
    } else {

      if (b * b - 4 * a * c > 0) {
        var x1 = (-b + math.sqrt(b * b - 4 * a * c)) / 2 * a
        var x2 = (-b - math.sqrt(b * b - 4 * a * c)) / 2 * a
        println("方程" + a + "x^2 + " + b + "x + " + c + "= 0" + "有两个解" + "X1 = " + x1 + ", X2 = " + x2)
      } else {
        var x1 = (-b + math.sqrt(b * b - 4 * a * c)) / 2 * a
        var x2 = (-b - math.sqrt(b * b - 4 * a * c)) / 2 * a
        println("方程" + a + "x^2 + " + b + "x + " + c + "= 0" + "有一个解" + "X1 = " + x1 + ", X2 = " + x2)
      }
    }
  }
}
