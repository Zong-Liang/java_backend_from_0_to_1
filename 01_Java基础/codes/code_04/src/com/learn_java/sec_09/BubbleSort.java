package com.learn_java.sec_09;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{88, 99, 66, 55, 11, 22, 66, 33, 77, 44};

        //打印待排序数组
        System.out.print("init_arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //排序(待优化)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换arr[i]和arr[i+1]的值
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.print("sort" + i + ": ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
}
