package com.learn_java.sec_01;

public class Phone {
    //成员变量、属性
    String brand;
    double price;

    //方法
    public void call() {
        System.out.println("calling");
    }

    public void sendMessage(String message) {
        System.out.println("sending message: " + message);
    }

    public void playGame() {
        System.out.println("playing game");
    }
}
