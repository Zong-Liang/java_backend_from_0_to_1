package com.learn_java;

public class UseEmployee_02 {
    public static void main(String[] args) {
        //创建实例
        Employee_02 employee=new Employee_02();
        System.out.println(employee);

        //给成员变量赋值
        employee.id = 1;
        employee.name = "zl";
        employee.age = 24;
        employee.salary = 30000;
        employee.birthday = new Birthday_02();
        employee.birthday.day = 26;
        employee.birthday.month = 7;
        employee.birthday.year = 1999;

        //给成员变量赋值
        employee.printInfo();
        employee.congratulateBirthday();
    }
}
