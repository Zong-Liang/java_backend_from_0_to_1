package com.learn_java.sec_01;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Scanner;

public class CommonException {
    @Test
    public void test1() {
        int[] arr = new int[10];
        System.out.println(arr[10]);  //ArrayIndexOutOfBoundsException
    }

    @Test
    public void test2() {
//        String str = "abc";
//        str=null;
//        System.out.println(str.toString());  //NullPointerException

        int[][] arr = new int[10][];
        System.out.println(arr[0][0]);  //NullPointerException
    }

    @Test
    public void test3() {
        Object obj = new String();
        String str = (String) obj;
        Date date = (Date) obj;  //ClassCastException
    }

    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int i = Integer.parseInt(str);
        System.out.println(i);  //NumberFormatException
    }

    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();  //InputMismatchException
        System.out.println(i);
    }

    @Test
    public void test6() {
        int i = 10;
        System.out.println(i / 0);  //ArithmeticException
    }

    @Test
    public void test7() {
//        Class cls = Class.forName("java.lang.String");  //ClassNotFoundException

    }

    @Test
    public void test8() {
//        File file = new File("hello.txt");
//
//        FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException
//
//        int data = fis.read(); //java.io.IOException
//        while (data != -1) {
//            System.out.println((char) data);
//            data = fis.read(); //java.io.IOException
//        }
//        fis.close(); //java.io.IOException
    }



}
