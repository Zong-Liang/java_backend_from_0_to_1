package com.learn_java.sec_01;

public class PrintNumber {
    public static void main(String[] args) {
        // 创建当前Thread的子类对象，通过对象调用start()方法
        PrintEvenNumber pen = new PrintEvenNumber();
        pen.start();
//        pen.run(); //不会启动新线程
//        pen.start();

        PrintOddNumber pon = new PrintOddNumber();
        pon.start();

        // main所在的线程执行的操作
        for (int i = 1; i < 10001; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }

        // 创建Thread类的匿名子类的匿名对象
        new Thread() {
            @Override
            public void run() {
                // 将此线程要执行的操作声明在此方法体中
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }.start();
    }
}
