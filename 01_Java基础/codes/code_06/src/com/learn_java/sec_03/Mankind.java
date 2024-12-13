package com.learn_java.sec_03;

public class Mankind {
    private int gender;
    private double salary;

    public Mankind() {
    }

    public Mankind(int gender, double salary) {
        this.gender = gender;
        this.salary = salary;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void maleOrFemale() {
        if (gender == 1) {
            System.out.println("male");
        } else if (gender == 0) {
            System.out.println("female");
        }
    }

    public void employed() {
        if (salary == 0) {
            System.out.println("have no job");
        } else {
            System.out.println("have job");
        }
    }
}
