package com.learn_java.sec_10;

public class Customer extends Thread{
    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public Customer(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.deposit(1000);
        }
    }
}
