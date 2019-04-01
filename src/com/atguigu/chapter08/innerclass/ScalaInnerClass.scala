package com.atguigu.chapter08.innerclass


object ScalaInnerClass {
  def main(args: Array[String]): Unit = {
    //测试1. 创建了两个外部类的实例
    val outer1 : ScalaOuterClass = new ScalaOuterClass();
    val outer2 : ScalaOuterClass = new ScalaOuterClass();

    //在scala中，创建成员内部类的语法是
    //对象.内部类  的方式创建, 这里语法可以看出在scala中，默认情况下内部类实例和外部对象关联
    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    //测试一下使用inner1 去调用 info()
    inner1.info()

    //创建静态内部类实例
    val staticInner= new ScalaOuterClass.ScalaStaticInnerClass()


  }
}

class ScalaOuterClass {
  myouter => //这里我们可以这里理解 外部类的别名 看做是外部类的一个实例
  class ScalaInnerClass { //成员内部类,

    def info() = {
      // 访问方式：外部类别名.属性名
      // 只是这种写法比较特别，学习java的同学可能更容易理解 ScalaOuterClass.class 的写法.
      println("name~ = " + myouter.name
        + " sal~ =" + myouter.sal)
    }

    //这里有一个方法,可以接受ScalaInnerClass实例
    //下面的 ScalaOuterClass#ScalaInnerClass 类型投影的作用就是屏蔽 外部对象对内部类对象的影响
    def test(ic: ScalaOuterClass#ScalaInnerClass): Unit = {
      System.out.println("使用了类型投影" + ic)
    }

  }
  //定义两个属性
  var name = "jack"
  private var sal = 800.9
}

object ScalaOuterClass { //伴生对象
class ScalaStaticInnerClass { //静态内部类
}
}
