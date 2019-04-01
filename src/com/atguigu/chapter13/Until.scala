package com.atguigu.chapter13

object Until {
  def main(args: Array[String]): Unit = {

    /**
      *
      * 1.condition 表示一个无输入,有返回(Boolean)的函数
      * 2.block 表示一个无输入,无输出的函数
      * 3.until(){}分别代表两个函数
      */

    def until(condition : => Boolean)( block : => Unit):Unit ={
      if (condition) {
        block
        until(condition)(block)
      }
    }

    var n = 10
    until(n != 0){
      println("n = " + n)
      n -= 1
    }

  }

}
