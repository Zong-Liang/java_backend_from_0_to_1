package com.practice.prac13.synchronized_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * 两个线程同时操作counter，但同步机制保证了线程安全，最终结果为预期值200。
 */
public class SynchronizedTest {
    @Test
    public void test1() {
        Counter counter = new Counter();

        // 创建两个线程并发执行increment
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });

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
