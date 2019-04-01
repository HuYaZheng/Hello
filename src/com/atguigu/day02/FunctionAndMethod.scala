package com.atguigu.day02


/**
  * 函数及方法的明确
  * 相同点:方法和函数几乎可以等同(比如他们的定义、使用、运行机制都一样的)
  * 不同点:
  *    1.方法:同一定义的一块代码,应用到oop中就是方法
  *           定义在类中,使用关键字def
  *    2.函数:上述定义代码,赋给一个变量,应用到函数式编程时就被称为函数
  *           理解为一个对象,有引用可以指向它,也有类型
  * 函数式编程与oop编程:
  *
  * 1.面向对象编程
  *    public int sum (int n1, int n2){
  *       return n1 + n2
  *    }
  * 2.函数式编程
  *    def op(a:int,b:int):int ={
  *       a+b
  *    }
  *
  *    def sum(op:(int,int)=>int,a:Int,b:Int)={
  *       op(a,b)
  *    }
  *
  *    主方法中调用 print(sum(op,2,3))
  *
  */
object FunctionAndMethod {

  def main6(args: Array[String]): Unit = {
    val f1 = () => "abc"

    val f2 = (a: String, b : Double) => a.toInt + b.toInt
    println(f2("3", 3.0))



  }


  def main5(args: Array[String]): Unit = {

    def A(a:Int , b:Int, c:Int):Int = {
      (a + b + c) / 3
    }

    def B(C:(Int, Int ,Int) => Int ,a:Int , b:Int, c:Int ) = {
      C(a , b , c )
    }

    println(B(A, 20,30,40))


    def max(a:Int , b:Int, c:Int):Int  ={

     if (a > b && b > c) a else if (b > c) b else c

    }

    println(B(max,30,40,50))

    println(B((a:Int , b:Int, c:Int)=>{if (a > b && b > c) c else if (b > c) b else a},30,40,50))
  }



  def main4(args: Array[String]): Unit = {
    def fbn (n : Int):Int = {//递归中不可以使用类型推断
      if (n == 1 && n ==2 ) 1 else (fbn(n-1) + fbn(n-2))
    }
  }


  //根据类型推导返回值类型的函数
  def main3(args: Array[String]): Unit = {
    var money = 100
    def buy(): Int = {
      money  -= 10
      money
    }

    def test1(a: Int) = {
      println(a)
      println(a)
    }

    def test2(a: => Int) = {
      println(a)
      println(a)
    }

    def test3(a: () => Int) = {
      println(a)
      println(a)
    }

    def test4(a: () => Int) = {
      println(a())
      println(a())
    }
    test1(buy)
    test2(buy)
    test3(buy)
    test4(buy)
  }



  def main2(args: Array[String]): Unit = {

    print(shape('*',3,3))
    //有固定返回值类型的函数
    def shape (ch : Char, n : Int, m : Int): Int = {
      for (i <- 1 to n ; j <- 1 to m ){ print(ch)
        if (j == m) println()
      }
      n*m
    }
  }




  def main1(args: Array[String]): Unit = {

    calc('*',3,5)
    //没有返回值的函数
    def calc(op : Char, n1 : Int, n2 : Int) {
      if (op == '+'){println(n1 + n2)}
      if (op == '-'){println(n1 - n2)}
      if (op == '*'){println(n1 * n2)}
      if (op == '/'){println(n1 / n2)}
    }
  }
}
