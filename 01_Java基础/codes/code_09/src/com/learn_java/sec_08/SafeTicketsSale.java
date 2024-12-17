package com.learn_java.sec_08;

public class SafeTicketsSale {
    public static void main(String[] args) {
        SafeSellTickets safeSellTickets1 = new SafeSellTickets();
        SafeSellTickets safeSellTickets2 = new SafeSellTickets();
        SafeSellTickets safeSellTickets3 = new SafeSellTickets();

        safeSellTickets1.setName("窗口1");
        safeSellTickets2.setName("窗口2");
        safeSellTickets3.setName("窗口2");

        safeSellTickets1.start();
        safeSellTickets2.start();
        safeSellTickets3.start();
    }
}
