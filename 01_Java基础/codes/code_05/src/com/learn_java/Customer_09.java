package com.learn_java;

public class Customer_09 {
    private String firstName;  //名
    private String lastName;  //姓

    private Account_09 account;

    public Customer_09(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account_09 getAccount() {
        return account;
    }

    public void setAccount(Account_09 account) {
        this.account = account;
    }
}
