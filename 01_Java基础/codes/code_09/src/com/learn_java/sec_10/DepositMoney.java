package com.learn_java.sec_10;

public class DepositMoney {
    public static void main(String[] args) {
        //两个储户往同一个账户存钱
        Account account = new Account();

        Customer customer1 = new Customer(account, "customer1");
        Customer customer2 = new Customer(account, "customer2");

        customer1.start();
        customer2.start();
    }
}
