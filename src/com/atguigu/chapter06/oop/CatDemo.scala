package com.atguigu.chapter06.oop

object CatDemo {
  def main(args: Array[String]): Unit = {
    val cat = new Cat

    //等价于cat.name_$eq("小白")
    cat.name = "小白"
    cat.age = 10
    cat.color = "白色"

    printf("\n小猫信息: %s %d %s\n",cat.name,cat.age,cat.color)
    //${}类似于El表达式,可以做简单的运算,{}内内容单一时,{}可以省略
    println(s"name=${cat.name} age=${cat.age} color=${cat.color}")

  }
}

class Cat {
  /**
    * 说明
    * 1.声明的属性在编译后,.class文件中属性会是私有的
    * 2.同时相应的属性会对应的有public方法(name_$eq)类似于Java中的get()和set()
    */
  var name :String = _
  var age :Int = _
  var color :String = _
}
