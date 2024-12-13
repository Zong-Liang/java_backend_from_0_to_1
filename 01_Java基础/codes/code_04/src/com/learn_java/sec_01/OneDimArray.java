package com.learn_java.sec_01;

import java.util.Scanner;

public class OneDimArray {
    public static void main(String[] args) {
        //一维数组声明和初始化：数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, ...};
        double[] prices;
        prices = new double[]{20.32, 43.21, 43.25};

        String[] foods = new String[4];

        //访问数组元素
        System.out.println(prices[0]);

        //给数组元素赋值
        foods[0] = "好好学习";
        foods[1] = "天天向上";
        foods[2] = "天天开心";
        foods[3] = "健康生活";

        //数组长度
        System.out.println(foods.length);
        System.out.println(prices.length);

        //遍历数组
        for (int i = 0; i < 4; i++) {
            System.out.println(foods[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }

//        for (double price : prices) {
//            System.out.println(price);
//        }

        //数组元素默认初始化值
        //整型数组元素：0
        int[] arr = new int[3];
        System.out.println(arr[0]);
        //浮点型数组元素：0.0
        double[] arr1 = new double[3];
        System.out.println(arr1[0]);
        //字符型数组元素：0('\u0000')
        char[] arr2 = new char[3];
        System.out.println(arr2[0]);
        //boolean型数组元素：false
        boolean[] arr3 = new boolean[3];
        System.out.println(arr3[0]);
        //引用型数组元素：null
        String[] arr4 = new String[3];
        System.out.println(arr4[0]);

        //java内存结构：程序计数器、虚拟机栈、本地方法栈、堆、方法区
        /*与数组相关
            虚拟机栈：存放方法中声明的局部变量
            堆：存放数组中的元素
        */

        //一维数组练习
        //start
        //根据键盘输入人数创建数组
        Scanner scan = new Scanner(System.in);
        System.out.println("please input the number of students: ");
        int count = scan.nextInt();

        int[] scores = new int[count];

        //依次输入成绩并存储在数组中，并获取最大值
        int maxScore = scores[0];
        System.out.println("please input " + count + " scores");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scan.nextInt();

            if (maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }
        System.out.println("the max score is " + maxScore);

        //遍历数组，根据学生成绩与最高分的差值输出成绩及其对应等级
        char grade = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= maxScore - 10) {
                grade = 'A';
            } else if (scores[i] >= maxScore - 20) {
                grade = 'B';
            } else if (scores[i] >= maxScore - 30) {
                grade = 'C';
            } else {
                grade = 'D';
            }
            System.out.println("student" + i + "'s score is " + scores[i] + " and grade is " + grade);
        }
        //end
    }
}
