package com.learn_java.sec_06;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class OtherAPI {
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java.version：" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java.home：" + javaHome);
        String osName = System.getProperty("os.Name");
        System.out.println("os.Name：" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os.version：" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user.name：" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user.home：" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir：" + userDir);
    }

    @Test
    public void test2() {
        //技巧：floor(x + 0.5)
        System.out.println(Math.round(12.3)); //12
        System.out.println(Math.round(12.5)); //13
        System.out.println(Math.round(-12.3)); //-12
        System.out.println(Math.round(-12.6)); //-13
        System.out.println(Math.round(-12.5)); //-12
    }

    @Test
    public void test3() {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);

        int j = random.nextInt(10, 20);
        System.out.println(j);
    }
}
