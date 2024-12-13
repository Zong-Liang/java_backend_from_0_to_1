package com.learn_java.sec_09;

public class UseEmployee {
    @UseAnnotation("main方法，程序入口")
    public static void main(String[] args) {
        Employee employee = new Employee("Jerry", 18, Status.FREE);
        System.out.println(employee);
    }
}
