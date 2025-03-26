package com.practice.prac13.synchronized_test;

import lombok.Data;

/**
 * @author Zong Liang
 * synchronized修饰方法时，使用当前对象的锁（this）。
 */
@Data
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + "：" + count);
        count++;
    }
}
