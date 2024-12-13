package com.learn_java.sec_10;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class UseUnitTest {
    @Test
    public void test1() {
        System.out.println("hello , this is unit test1.");
    }

    @Test
    public void test2() {
        System.out.println("hello , this is unit test2.");
        //默认情况下，单元测试方法中使用`Scanner`失效，如何解决？
        //在Help/Edit Custom VM Options中添加如下配置：-Deditable.java.test.console=true
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a number:");
        int num = scanner.nextInt();
        System.out.println("the number you input is: " + num);
    }
}
