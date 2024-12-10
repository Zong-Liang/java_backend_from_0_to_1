package com.learn_java;

public class Account_09 {
    private double balance;  //余额

    public Account_09(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    //存钱
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("成功存入：" + amount);
        }
    }

    //取钱
    public void withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            System.out.println("成功取出：" + amount);
        } else {
            System.out.println("取款数额有误或余额不足");
        }
    }
}
