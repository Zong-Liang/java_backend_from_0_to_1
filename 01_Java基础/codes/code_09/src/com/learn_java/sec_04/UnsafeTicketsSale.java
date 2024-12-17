package com.learn_java.sec_04;

public class UnsafeTicketsSale {
    public static void main(String[] args) {
        UnsafeSellTickets unsafeSellTickets1 = new UnsafeSellTickets();
        UnsafeSellTickets unsafeSellTickets2 = new UnsafeSellTickets();
        UnsafeSellTickets unsafeSellTickets3 = new UnsafeSellTickets();

        unsafeSellTickets1.setName("窗口1");
        unsafeSellTickets2.setName("窗口2");
        unsafeSellTickets3.setName("窗口3");

        //会存在线程安全问题：出现了重票、错票
        unsafeSellTickets1.start();
        unsafeSellTickets2.start();
        unsafeSellTickets3.start();
    }
}
