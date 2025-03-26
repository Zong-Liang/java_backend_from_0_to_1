package com.practice.prac13.runnable_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * 实现Runnable接口的run()方法，然后将其传递给Thread对象。
 */
public class RunnableTest {
    @Test
    public void test1() {
        PrintEvenNumber printEvenNumber = new PrintEvenNumber();
        PrintOddNumber printOddNumber = new PrintOddNumber();

        Thread thread1 = new Thread(printEvenNumber);
        Thread thread2 = new Thread(printOddNumber);

        thread1.start();
        thread2.start();
    }
    
    @Test
    public void test2() {
        // 创建Runnable接口匿名实现类的匿名对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();
    }
}
