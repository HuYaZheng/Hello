package com.atguigu.chapter07

object Employee {
  def main(args: Array[String]): Unit = {
    val employee = new Employee
    println(employee)
  }

}

/**
  * 类Employee 在com.atguigu.chapter07.scalapackage下被创建
  * 当我们修改包名时(如:com.atguigu.chapter07.scalapackage.employee)
  * 程序不会报错,编译器会将.class文件存放在修改后的文件目录下
  */
class Employee{

}
