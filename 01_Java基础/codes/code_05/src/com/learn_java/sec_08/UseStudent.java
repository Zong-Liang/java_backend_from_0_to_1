package com.learn_java.sec_08;

public class UseStudent {
    public static void main(String[] args) {
        //构造器重载
        Student student = new Student("zl", 25, "ahu", "cs");
        System.out.println(student.getInfo());

        Student student1 = new Student("wh", 25);
        System.out.println(student1.getInfo());
    }
}
