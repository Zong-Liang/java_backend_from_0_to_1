package com.learn_java.sec_02;

public class TwoDimArray {
    public static void main(String[] args) {
        //二维数组的声明与初始化：数据类型[][] 数组名 = new 数据类型[m][n];
        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 6}};  // 3*2

        String[][] arr1 = new String[1][3];

        //访问数组元素
        System.out.println(arr[0][1]);  // 2
        System.out.println(arr[0]);  // [I@4eec7777

        //给数组元素赋值
        arr1[0][0] = "好好学习";
        arr1[0][1] = "天天向上";
        arr1[0][2] = "天天开心";

        //数组长度
        System.out.println(arr.length);
        System.out.println(arr[0].length);

        //遍历数组
        System.out.println(arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println(arr1[i][j]);
            }
        }

//        for (int[] int_arr : arr) {
//            for (int anInt : int_arr) {
//                System.out.println(anInt);
//            }
//        }

//        for (String[] strings : arr1) {
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        }

        //二维数组外层元素默认值是地址，内层元素参默认值参照一维数组
    }
}
