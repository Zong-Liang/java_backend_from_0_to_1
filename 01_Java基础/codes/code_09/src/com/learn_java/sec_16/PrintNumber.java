package com.learn_java.sec_16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrintNumber {
    public static void main(String[] args) {
        //创建实现Callable接口的实现类的对象
        PrintEvenNumber pen = new PrintEvenNumber();
        //将此Callable接口的实现类的对象作为参数传入Thread类的构造器中，创建Thread对象并调用start()方法
        FutureTask ft = new FutureTask(pen);

        Thread t = new Thread(ft);

        t.start();

        Object count = null;
        try {
            //获取Callable中call()方法的返回值
            //get()返回值即为FutureTask构造器参数Callable接口的实现类重写的call()方法的返回值
            count = ft.get();
            System.out.println("偶数个数为：" + count);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
