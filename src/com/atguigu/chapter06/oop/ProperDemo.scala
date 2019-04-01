package com.atguigu.chapter06.oop

object ProperDemo {
  def main(args: Array[String]): Unit = {

    val person = new Person
    println(person.name)
    println(person.age)
    println(person.sal)
    println(person.adress) //null

    val person2 = new Person
    //如果给属性赋值为空,一定要指定类型,否则将不能更改属性值
    person2.name = null
    person2.adress = "中国"
    println(person2.name)
    println(person2.age)
    println(person2.sal)
    println(person2.adress)
  }

}

class Person{
  var name = null
  var age :Int = 10
  var sal = 32.43
  var adress :String = _
}

