package com.atguigu.chapter15.service

import com.atguigu.chapter15.bean.CustomerBean

import scala.collection.mutable.ListBuffer
import util.control.Breaks._


class CustomerService {

  var customerId : Int= 3
  var index:Int = -1
  val customers = ListBuffer[CustomerBean]()
  val bean1 = new CustomerBean(1,"tom",'男',10,"110","tom@sohu.com")
  val bean2 = new CustomerBean(2,"jack",'男',11,"110","tom@sohu.com")
  val bean3 = new CustomerBean(3,"harry",'男',12,"110","tom@sohu.com")
  customers.append(bean1)
  customers.append(bean2)
  customers.append(bean3)



  def addCustomer(customer:CustomerBean):Boolean={
    customerId += 1
    customer.id = this.customerId
    customers.append(customer)

    true
  }

  def findIndexById(id : Int): Int ={
    breakable{
      for (i <- 0 until customers.length) {
        if (customers(i).id == id) {
          index = i
          break()
        }
      }
    }
    index
  }

  def deleteCustomer(id:Int):Boolean={
    val index = findIndexById(id)
    if(index != -1){
      customers.remove(index)
      true
    }else{
      false
    }
  }

  def modify(id:Int):CustomerBean={
    val index = findIndexById(id)
      customers(index)
  }


}
