package com.learn_java;
/*
JavaBean是一种Java语言写成的可重用组件，是指符合以下标准的Java类：
        - 类是公共的。
        - 有一个无参的公共的构造器。
        - 有属性，且有对应的getter、setter方法。
*/

public class Customer_10 {
    private String firstName;  //名
    private String lastName;  //姓

    public Customer_10() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
