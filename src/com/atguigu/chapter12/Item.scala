package com.atguigu.chapter12

object Sales{
  def main(args: Array[String]): Unit = {
    /**
      * 组合套餐书籍:减十元
      *     1.Book("漫画", 40)
      *     2.另一个套餐:文学作品减二十元
      *             1.Book("《阳关》", 80)
      *             2.Book("《围城》", 30)
      */
    val sale = Bundle("组合套餐书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))

    //知识点1 - 使用case语句，得到 "漫画"
    val res = sale match  {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, Book(desc, _), _*) => desc
    }
    println("res=" + res)



    //知识点2-通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
    val res2 = sale match  {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, art @ Book(_, _), rest) => (art, rest)
    }
    println("res2=" + res2)


    def price(it:Item): Double = {
      it match  {
        case Book(_,p) => p
        case Bundle(_,disc,its @ _*) => its.map(price).sum - disc
      }
    }
    println("price=" + price(sale)) // 120

  }
}




abstract class Item
case class Book(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, item: Item*) extends Item
