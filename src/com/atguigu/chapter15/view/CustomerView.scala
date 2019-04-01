package com.atguigu.chapter15.view

import com.atguigu.chapter15.bean.CustomerBean
import com.atguigu.chapter15.service.CustomerService

import scala.io.StdIn
import util.control.Breaks._

class CustomerView {

  var loop: Boolean = true
  var flag: Boolean = true
  val chars = List('1', '2', '3', '4', '5')
  var key: Char = _
  private val customerService = new CustomerService

  //显示主菜单
  def mainMenu(): Unit = {
    while (loop) {
      println("-----------------客户信息管理软件-----------------")
      println()
      println("                 1 添 加 客 户")
      println("                 2 修 改 客 户")
      println("                 3 删 除 客 户")
      println("                 4 客 户 列 表")
      println("                 5 退       出")
      println("                 请选择(1-5):")

      breakable {
        while (flag) {
          key = StdIn.readChar
          if (chars.contains(key)) {
            break()
          } else {
            println("输入错误,请重新输入:")
          }
        }
      }

      key match {
        case '1' => add()
        case '2' => modify()
        case '3' => delete()
        case '4' => list()
        case '5' => loop = false
      }
    }
    println("您已退出系统.....")
  }


  //显示客户信息
  def list(): Unit = {
    println()
    println("---------------------------客户列表---------------------------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
    val customers = customerService.customers
    for (cutomer <- customers) {
      println(cutomer)
    }
    println("-------------------------客户列表完成-------------------------")
  }


  //添加客户
  def add(): Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()
    //构建对象
    val customer = new CustomerBean(name, gender, age, tel, email)
    customerService.addCustomer(customer)
    println("---------------------添加完成---------------------")
  }

  //删除用户
  def delete(): Unit = {
    println("---------------------删除客户---------------------")
    println("请选择待删除客户编号(-1退出)：")
    val id = StdIn.readInt()
    if (id == -1) {
      println("---------------------删除没有完成---------------------")
      return
    }
    println("确认是否删除(Y/N)：")
    val choice = StdIn.readChar().toLower
    if (choice == 'y') {
      if (customerService.deleteCustomer(id)) {
        println("---------------------删除完成---------------------")
        return
      }
    }
    println("---------------------删除没有完成---------------------")
  }

  //修改客户信息
  def modify(): Unit = {
    println("---------------------修改客户信息---------------------")
    println("请选择待修改客户编号(-1退出)：")
    val id = StdIn.readInt()
    val customer = customerService.modify(id)

    println("姓名(" + customer.name + "):" )
    customer.name = StdIn.readLine()
    println("性别(" + customer.gender + "):")
    customer.gender = StdIn.readChar()
    println("年纪(" + customer.age + "):")
    customer.age = StdIn.readShort()
    println("电话(" + customer.tel + "):")
    customer.tel = StdIn.readLine()
    println("邮箱(" + customer.email + "):")
    customer.email = StdIn.readLine()
    println("---------------------修改完成---------------------")
    list()
  }


}
