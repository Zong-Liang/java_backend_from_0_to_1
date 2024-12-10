package com.learn_java;

//this可以调用成员变量 (属性)、方法、构造器。

public class Student_01 {
    String name;
    int age;
    String school;
    String major;

    public Student_01(String n, int a) {
        name = n;
        age = a;
    }

    public Student_01(String n, int a, String s) {
        this(n, a);  // this(参数列表);必须放在首行，最多声明一个
        school = s;
    }

    public Student_01(String n, int a, String s, String m) {
        this(n, a, s);
        major = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
