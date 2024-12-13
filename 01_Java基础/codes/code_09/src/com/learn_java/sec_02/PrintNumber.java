package com.learn_java.sec_02;

public class PrintNumber {
    public static void main(String[] args) {
        // 创建当前实现类的对象
        PrintOddNumber pon = new PrintOddNumber();
        PrintEvenNumber pen= new PrintEvenNumber();

        // 将此对象当做参数传递到Thread类的构造器中，创建Thread类的实例
        Thread t1 = new Thread(pon);
        Thread t2 = new Thread(pen);

        t1.start();
        t2.start();

        // 创建Runnable接口匿名实现类的匿名对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();
    }
}
