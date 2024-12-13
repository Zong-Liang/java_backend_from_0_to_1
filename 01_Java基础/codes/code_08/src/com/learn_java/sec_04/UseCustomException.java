package com.learn_java.sec_04;

public class UseCustomException {
    public static void main(String[] args) {
        Student s1 = new Student();

        try {
            s1.register1(10);
            s1.register1(-10);
            System.out.println(s1);
        } catch (BelowZeroException1 e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

        try {
            s1.register2(10);
            s1.register2(-10);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
