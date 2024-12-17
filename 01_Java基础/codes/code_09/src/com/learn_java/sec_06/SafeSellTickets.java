package com.learn_java.sec_06;

public class SafeSellTickets extends Thread{
    //    int ticket = 100;
    static int ticket = 100;
//    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //使用同步代码块解决线程安全问题
            synchronized (SafeSellTickets.class) { //Class cls = SafeSellTicket2.class
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
}
