package com.learn_java.sec_13;

public class UseLock {
    public static void main(String[] args) {
        SafeSellTickets sst1 = new SafeSellTickets();
        SafeSellTickets sst2 = new SafeSellTickets();
        SafeSellTickets sst3 = new SafeSellTickets();

        sst1.setName("窗口1");
        sst2.setName("窗口2");
        sst3.setName("窗口3");

        sst1.start();
        sst2.start();
        sst3.start();
    }
}
