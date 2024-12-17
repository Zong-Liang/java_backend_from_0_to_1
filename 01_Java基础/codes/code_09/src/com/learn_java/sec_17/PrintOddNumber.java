package com.learn_java.sec_17;

public class PrintOddNumber implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
