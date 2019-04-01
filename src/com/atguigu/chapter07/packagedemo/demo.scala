/**
  * 1.scala中,包的创建类似于遵守JavaApi的原则.更像是一个多级目录,
  * 2.建包的过程及其像是在编写JavaApi,如:
  * A
  * 1
  * 2
  * 3
  *   A.B
  * 1
  * 2
  * 3
  *   A.B.C
  * 1
  * 2
  * 3
  * ...
  * 3.对象创建及调用时,子包可以直接new创建父包中的类
  * 4.如果子包中的类名与父包中的类名一致时,默认情况下会优先调用子包中的类
  */
package com.atguigu {
  class user{

  }

  object demo{
    def main(args: Array[String]): Unit = {
      import com.atguigu.scala.Cat
      val cat = new Cat
      cat.play("ball")

      println(cat)
    }
  }


  /**
    * 1.每个包都可以有一个包对象
    * 2.包对象的名字需要和子包的名字相同
    * 3.包对象和子包处于平行关系
    * 4.编译后包对象生成了两个.class文件,对所定义的属性及方法进行了包装
    */

  package object scala {
    var name = "小白"

    def sayHello(): Unit = {
      println("我是包对象,我被调用了")
    }
  }


  package scala{

    class Cat {
      val name = "jack"

      def play(play: String) = {
        println(name + "喜欢玩" + play)
      }
    }

    class User{

    }

    object demo {
      def main(args: Array[String]): Unit = {
        val cat = new Cat
        cat.play("ball")
        println(cat)

        val user = new User
        println(user)

        println("包对象的信息:" + name)
        sayHello()

      }

    }

  }

}


