package com.learn_java.sec_05;

public class Student extends Person {
    private String school;
    private static String nation = "China";

    public Student() {
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String getInfo() {
        System.out.println("nation: " + nation + " name: " + getName() + " age: " + getAge() + " school:" + getSchool());
        return "I'm a student";
    }
}
