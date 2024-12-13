package com.learn_java.sec_06;

public class Recursion {
//    public void test() {
//        System.out.println("test");
//        test();  //StackOverflowError
//    }

    public int sum(int num) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += i + 1;
        }
        return sum;
    }

    public int sum1(int num) {
        if (num == 1) {
            return 1;
        }
        return sum1(num - 1) + num;
    }

    public int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
//        recursion.test();
        System.out.println(recursion.sum(100));
        System.out.println(recursion.sum1(100));
        System.out.println(recursion.factorial(5));
        System.out.println(recursion.fibonacci(10));
    }
}
