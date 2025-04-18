package com.learn_java.sec_08;

public class Student {
    String name;
    int age;
    String school;
    String major;

    public Student(String n, int a) {
        name = n;
        age = a;
    }

    public Student(String n, int a, String s) {
        name = n;
        age = a;
        school = s;
    }

    public Student(String n, int a, String s, String m) {
        name = n;
        age = a;
        school = s;
        major = m;
    }

    public String getInfo() {
        return "name: " + name + " age: " + age
                + " school: " + school + " major: " + major;
    }
}
