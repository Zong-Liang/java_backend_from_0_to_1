package com.learn_java.sec_10;

public class Account {
    private double balance; //余额

    public synchronized void deposit(double amount) { //this 指account，唯一
        if (amount > 0) {
            balance += amount;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "存钱1000块，余额为：" + balance);
    }
}
