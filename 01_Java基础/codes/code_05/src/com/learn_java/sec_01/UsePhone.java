package com.learn_java.sec_01;

public class UsePhone {
    public static void main(String[] args) {
        //创建对象(Phone_01类实例)
        Phone phone=new Phone();

        //给成员变量赋值
        phone.brand = "xiaomi";
        phone.price = 4999.99;
        System.out.println("Your new phone's brand is " + phone.brand + " and it's price is " + phone.price);

        //调用成员方法
        phone.call();
        phone.sendMessage("hello xiaomi");
        phone.playGame();
    }
}
