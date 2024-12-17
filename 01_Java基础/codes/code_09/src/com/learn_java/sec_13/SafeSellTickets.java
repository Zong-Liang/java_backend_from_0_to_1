package com.learn_java.sec_13;

import java.util.concurrent.locks.ReentrantLock;

public class SafeSellTickets extends Thread{
    //    int ticket = 100;
    static int ticket = 100;

    // 需要确保多个线程共用一个Lock实例，需要将此对象声明为static final
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 锁定对共享资源的调用
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 解除对共享资源的调用的锁定
                lock.unlock();
            }

        }
    }
}
