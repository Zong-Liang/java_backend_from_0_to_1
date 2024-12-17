package com.learn_java.sec_07;

public class SafeSellTickets implements Runnable{
    int ticket = 100;
    boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            sellTicket();
        }
    }

    //使用同步方法解决线程安全问题
    public synchronized void sellTicket() { //方法非静态，此时同步监视器是this (唯一)
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
            ticket--;
        } else {
            isFlag = false;
        }
    }
}
