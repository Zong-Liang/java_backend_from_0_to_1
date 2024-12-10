package com.learn_java;

class Order {
    int orderId;
}

class Person {
    int age;
}

public class TransferValue_05 {

    public void test(int i) {
        i++;
    }

    public void test1(Person person) {
        person.age++;
    }

    public static void main(String[] args) {
        //基本数据类型的局部变量
        int m = 10;
        int n = m;
        System.out.println("m=" + m + " n=" + n);  //m=10 n=10
        m++;
        System.out.println("m=" + m + " n=" + n);  //m=11 n=10

        //引用数据类型的局部变量
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = arr;  //传递的是地址值
        arr1[0] = 10;
        System.out.println(arr[0]);  //10

        TransferValue_05 valueTransfer = new TransferValue_05();
        int i = 10;
        valueTransfer.test(i);
        System.out.println("i=" + i);  //10

        //对象类型的局部变量
        Order order = new Order();
        order.orderId = 1001;
        Order order1 = order;
        order1.orderId = 1002;
        System.out.println(order.orderId);  //1002

        Person person = new Person();
        person.age = 10;
        valueTransfer.test1(person);
        System.out.println(person.age);  //11
    }
}
