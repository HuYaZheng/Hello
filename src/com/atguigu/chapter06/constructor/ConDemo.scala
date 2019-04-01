package com.atguigu.chapter06.constructor

object ConDemo {
  def main(args: Array[String]): Unit = {
    val student = new Student("jack", 20)
    println(student.toString())

    val student2 = new Student("小红")
    println(student2.toString())

    val student3 = new Student(2)
    println(student3.toString())
  }
}

/**
  * 1.主构造器会执行类定义中的所有语句
  * 2.辅助构造器无论是直接或间接，最终都一定要调用主构造器，执行主构造器的逻辑
  * 3.而且需要放在辅助构造器的第一行,这点和java一样，java中一个构造器要调用同类的其它构造器，也需要放在第一行
  * 4.@BeanProperty加到局部变量前可以生成类似java中的get和set方法
  *
  * @param inName
  * @param inAge
  */

class Student(inName : String, inAge : Int){
  var name : String = inName
  var age :Int = inAge
  println("*************")

  def this(name : String){
    this("小白", 30)
    println("___________")
    this.name = name
  }

  def this(age : Int){
    this("小林")
    println("^^^^^^^^^^^^^")
    this.age = age
  }


  override def toString():String= {
    "Name:" + name + " Age:" + age
  }
}

/**
  * 主构造器的第二种形式
  * ()前面加private,主构造器私有化
  * 主构造器私有化后,只能通过公共的辅助构造器new对象
  * @param name
  * @param age
  */

class Person private (var name :String, var age : Int) {

  override def toString():String= {
    "Name:" + name + "Age:" + age
  }
}