package com.learn_java.sec_01;

public class PrintOddNumber extends Thread{
    // 重写Thread类的run()方法
    @Override
    public void run() {
        // 将此线程要执行的操作声明在此方法体中
        for (int i = 1; i < 10001; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
