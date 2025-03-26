package com.practice.prac13.waitnotify_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * wait()和notify()必须在synchronized块中使用，基于同一个锁对象。
 * 实现生产者-消费者模式，线程间通过条件协作。
 */
public class WaitNotifyTest {
    private final Object lock = new Object();
    private boolean isProduced = false;

    // 生产者方法
    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (isProduced) { // 如果已经生产，等待消费
                lock.wait();
            }
            System.out.println("Produced by " + Thread.currentThread().getName());
            isProduced = true;
            lock.notify(); // 通知消费者
        }
    }

    // 消费者方法
    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (!isProduced) { // 如果未生产，等待生产
                lock.wait();
            }
            System.out.println("Consumed by " + Thread.currentThread().getName());
            isProduced = false;
            lock.notify(); // 通知生产者
        }
    }
    
    @Test
    public void test1() {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();

        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    waitNotifyTest.produce();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer");

        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    waitNotifyTest.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer");

        // 启动线程
        producer.start();
        consumer.start();
    }

}
