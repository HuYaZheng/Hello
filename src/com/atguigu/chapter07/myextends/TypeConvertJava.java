package com.atguigu.chapter07.myextends;

public class TypeConvertJava {

    public static void main(String[] args) {
        TypeConvertJava i = new TypeConvertJava();

        i.func(new Dog());

        i.func(new Cat());

    }


    public void func(Animal an) {//Animal an = new Dog();
        an.eat();
        an.jump();
    }
}


class Animal{

    public void eat(){
        System.out.println("Animal:进食");
    }

    public void jump(){
        System.out.println("Animal:跳");
    }


}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void jump(){
        System.out.println("狗急跳墙");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }

    public void jump(){
        System.out.println("猫跳");
    }
}