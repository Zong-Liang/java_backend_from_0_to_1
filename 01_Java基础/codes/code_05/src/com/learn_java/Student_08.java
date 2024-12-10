package com.learn_java;

public class Student_08 {
    String name;
    int age;
    String school;
    String major;

    public Student_08(String n, int a) {
        name = n;
        age = a;
    }

    public Student_08(String n, int a, String s) {
        name = n;
        age = a;
        school = s;
    }

    public Student_08(String n, int a, String s, String m) {
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
