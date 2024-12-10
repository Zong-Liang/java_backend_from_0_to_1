package com.learn_java;

public class UseStudent_08 {
    public static void main(String[] args) {
        //构造器重载
        Student_08 student = new Student_08("zl", 25, "ahu", "cs");
        System.out.println(student.getInfo());

        Student_08 student1 = new Student_08("wh", 25);
        System.out.println(student1.getInfo());
    }
}
