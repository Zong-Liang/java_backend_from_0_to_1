package com.learn_java.sec_04;

public class UnsafeSellTickets extends Thread{
    //    int ticket = 100;
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
        }
    }
}
