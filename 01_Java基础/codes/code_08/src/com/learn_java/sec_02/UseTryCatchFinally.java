package com.learn_java.sec_02;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseTryCatchFinally {
    @Test
    public void test1() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
        }

        System.out.println("异常处理结束，继续执行代码");
    }

    @Test
    public void test2() {
        try {
            String str = "123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace(); //推荐
//            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            File file = new File("hello.txt");

            FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            fis.close(); //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("读取数据结束");
    }

    @Test
    public void test4() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
            System.out.println(10 / 0); //在catch中存在异常
        } finally {
            System.out.println("异常处理结束，继续执行代码");

        }
    }

    @Test
    public void test5() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //将流资源的关闭操作放在finally中
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("读取数据结束");
    }

//    public static void main(String[] args) {
//        int result = test("8");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//            return 0;
//        }
//    }

    public static void main(String[] args) {
        int result = test(10);
        System.out.println(result);
    }

    public static int test(int i) {
        try {
            return i;
        } catch (NumberFormatException e) {
            return i--;
        } finally {
            System.out.println("test结束");
//            return ++i; //11
            ++i; //10
        }
    }
}
