package com.learn_java.sec_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PrintNumber {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
        System.out.println(es.getClass());
        //设置线程池的属性
        tpe.setMaximumPoolSize(50); //设置线程池中线程数的上限

        //执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
        es.execute((new PrintEvenNumber()));
        es.execute((new PrintOddNumber()));

//        es.submit(Callable callable);

        //关闭连接池
        es.shutdown();
    }
}
