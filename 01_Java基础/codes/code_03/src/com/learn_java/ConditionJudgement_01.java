package com.learn_java;

import java.util.Scanner;

public class ConditionJudgement_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //if
        System.out.println("please input tow float numbers to compare:");
        float num = sc.nextFloat();
        float num1 = sc.nextFloat();
        if (num > num1) {
            System.out.println("the larger num is " + num);
        } else {
            System.out.println("the smaller num is " + num1);
        }

        //if...else用三元运算符简化
        System.out.println("the larger num is " + (num > num1 ? num : num1));

        //switch
        System.out.println("please input the month: ");
        int month = sc.nextInt();
        switch (month) {
            case 2:
            case 3:
            case 4:
                System.out.println("the present season is spring");
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("the present season is summer");
                break;
            case 8:
            case 9:
            case 10:
                System.out.println("the present season is autumn");
                break;
            case 11:
            case 12:
            case 1:
                System.out.println("the present season is winter");
        }
    }
}
