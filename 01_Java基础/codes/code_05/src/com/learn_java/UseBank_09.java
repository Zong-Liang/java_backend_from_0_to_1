package com.learn_java;

public class UseBank_09 {
    public static void main(String[] args) {
        Bank_09 bank = new Bank_09();

        bank.addCustomer("l", "z");
        bank.addCustomer("h", "w");

        bank.getCustomer(0).setAccount(new Account_09(1000));
        bank.getCustomer(0).getAccount().withdraw(50);
        bank.getCustomer(0).getAccount().deposit(100);

        System.out.println("账户余额为：" + bank.getCustomer(0).getAccount().getBalance());
    }
}
