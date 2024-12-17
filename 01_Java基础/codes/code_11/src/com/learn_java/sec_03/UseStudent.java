package com.learn_java.sec_03;

import java.util.ArrayList;
import java.util.Scanner;

public class UseStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入学生信息：");

        ArrayList list = new ArrayList();

        while (true) {
            System.out.println("|1:继续录入 | 0:结束录入|");
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            } else if (option == 1) {
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入学生年龄：");
                int age = scanner.nextInt();

                Student s = new Student(name, age);

                list.add(s);
            }
        }

        System.out.println("录入结束，遍历学生信息：");

        for (Object o : list) {
            Student s = (Student) o;
            System.out.println(o.toString());
        }

        scanner.close();
    }
}
