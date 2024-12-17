package com.learn_java.sec_03;

public class UnsafeTicketsSale {
    public static void main(String[] args) {
        UnsafeSellTickets unsafeSellTickets = new UnsafeSellTickets();

        Thread t1 = new Thread(unsafeSellTickets);
        Thread t2 = new Thread(unsafeSellTickets);
        Thread t3 = new Thread(unsafeSellTickets);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //会存在线程安全问题：出现了重票、错票
        t1.start();
        t2.start();
        t3.start();

    }
}
