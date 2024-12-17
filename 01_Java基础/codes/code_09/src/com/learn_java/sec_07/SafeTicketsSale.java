package com.learn_java.sec_07;

public class SafeTicketsSale {
    public static void main(String[] args) {
        SafeSellTickets safeSellTickets = new SafeSellTickets();

        Thread t1 = new Thread(safeSellTickets);
        Thread t2 = new Thread(safeSellTickets);
        Thread t3 = new Thread(safeSellTickets);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
