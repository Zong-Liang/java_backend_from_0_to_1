package com.practice.prac13.reentrantlock_test;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zong Liang
 * ReentrantLock需要手动加锁和解锁，相比synchronized更灵活。
 * try-finally结构确保即使发生异常也能释放锁。
 */
@Data
public class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：" + count);
            count++;
        } finally {
            lock.unlock();
        }
    }
}
