package com.practice.prac13.reentrantlock_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class ReentrantLockTest {
    @Test
    public void test1() {
        Counter counter = new Counter();

        // 创建两个线程
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        }, "t1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        }, "t2");

        // 启动线程
        t1.start();
        t2.start();

        // 等待线程执行完成
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出最终结果，应为200
        System.out.println("Final counter value: " + counter.getCount());
    }
}
