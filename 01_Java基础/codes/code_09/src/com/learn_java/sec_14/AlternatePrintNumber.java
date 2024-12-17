package com.learn_java.sec_14;

public class AlternatePrintNumber {
    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();

        Thread t1 = new Thread(pn);
        Thread t2 = new Thread(pn);

        t1.start();
        t2.start();
    }
}
