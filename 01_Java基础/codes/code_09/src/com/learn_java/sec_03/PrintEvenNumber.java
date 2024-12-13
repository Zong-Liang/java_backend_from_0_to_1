package com.learn_java.sec_03;

import java.util.concurrent.Callable;

public class PrintEvenNumber implements Callable {
    //实现接口中的call()方法，将线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
                count++;
            }
        }
        return count;
    }
}
