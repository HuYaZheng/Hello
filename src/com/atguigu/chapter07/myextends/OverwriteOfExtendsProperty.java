package com.atguigu.chapter07.myextends;

/**
 * 类和子类定义了一个同名的字段，不会报错。
 * 但对于同一个对象，用父类的引用去取值(字段)，会取到父类的字段的值，
 * 用子类的引用去取值(字段)，则取到子类字段的值。
 * 在Java中只有方法的重写，没有属性/字段的重写
 */

public class OverwriteOfExtendsProperty {

    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.s);


        Super sup = new Sub();
        System.out.println(sup.s);

        System.out.println(((Sub) sup).s);
    }
}


class Super {

    String s = "super";
}

class Sub extends Super {
    String s = "sub";
}