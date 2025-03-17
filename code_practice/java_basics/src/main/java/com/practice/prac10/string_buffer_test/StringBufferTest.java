package com.practice.prac10.string_buffer_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * StringBuffer 是 Java 中一个用于操作字符串的类，它与 StringBuilder 类似，但有一个关键区别：StringBuffer 是线程安全的。
 * 这意味着它在多线程环境中可以安全地被多个线程共享和修改，而不会出现数据竞争或线程安全问题。
 * 然而，这种线程安全性是以牺牲性能为代价的，因为 StringBuffer 的方法通常是同步的（synchronized）。
 */
public class StringBufferTest {
    @Test
    public void test1() throws InterruptedException {
        StringBuffer sb = new StringBuffer("Hello");

        // 创建多个线程修改 StringBuffer
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("a");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("b");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sb.toString());

    }
}
