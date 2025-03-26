package com.practice.prac13.runnable_test;

/**
 * @author Zong Liang
 * 创建一个继承Thread类的子类
 */
public class PrintEvenNumber implements Runnable{
    // 重写Thread类的run()方法
    @Override
    public void run() {
        // 将此线程要执行的操作声明在此方法体中
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
