package com.learn_java;

public class Loop_02 {
    public static void main(String[] args) {
        //while
        int i = 0;
        int sum = 0;
        while (i < 10) {
            sum += i;
            i++;
        }
        System.out.println("0+1+...+9的和为：" + sum);

        //do...while
        do {
            sum += i;
            i++;
        } while (i < 11);
        System.out.println("i=" + i + " sum=" + sum);

        //for
        for (int j = 1; j < 10; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.printf(k + "*" + j + "=" + (j * k) + "\t");
            }
            System.out.println();
        }

        //foreach
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("数组arr中元素有：");
        for (int x : arr) {
            System.out.printf(x + " ");
        }

        System.out.println();
        //break
        for (int j = 0; j < 6; j++) {
            System.out.printf("j=" + j + " ");
            if (j == 3) {
                break;
            }
        }

        System.out.println();
        //带有标签的break
        LOOP:
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < j; k++) {
                if (k == 4) {
                    break LOOP;
                }
            }
            System.out.print("j=" + j + " ");
        }

        //continue
        System.out.println();
        System.out.println("0~9内奇数有：");
        for (int j = 0; j < 10; j++) {
            if (j % 2 == 0) {
                continue;
            }
            System.out.printf(j + " ");
        }

        System.out.println();
        //带有标签的continue
        LOOP:
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < j; k++) {
                if (k == 1) {
                    continue LOOP;
                }
            }
            System.out.print("j=" + j + " ");
        }
    }
}
