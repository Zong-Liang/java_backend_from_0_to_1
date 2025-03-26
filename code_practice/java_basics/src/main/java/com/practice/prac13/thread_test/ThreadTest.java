package com.practice.prac13.thread_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * 继承Thread并重写run()方法。
 */
public class ThreadTest {
    @Test
    public void test1() {
        // 创建两个线程对象
        PrintOddNumber printOddNumber = new PrintOddNumber();
        PrintEvenNumber printEvenNumber = new PrintEvenNumber();

        // 启动线程
        printOddNumber.start();
        printEvenNumber.start();
    }
    
    @Test
    public void test2() {
        // 创建Thread类的匿名子类的匿名对象
        new Thread() {
            @Override
            public void run() {
                // 将此线程要执行的操作声明在此方法体中
                for (int i = 1; i < 101; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }.start();
    }
}
