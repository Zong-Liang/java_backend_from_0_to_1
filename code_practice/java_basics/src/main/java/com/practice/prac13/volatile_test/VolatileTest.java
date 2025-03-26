package com.practice.prac13.volatile_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * volatile确保flag的修改对所有线程可见，但不保证原子性。
 * 适用于控制标志等简单场景，不适合复杂同步。
 */
public class VolatileTest {
    private volatile boolean flag = true;

    public void start(){
        new Thread(()->{
            while (flag){
                System.out.println(Thread.currentThread().getName() + " is running...");
                try {
                    Thread.sleep(500); // 模拟工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread stopped.");
        },"Worker-Thread").start();
    }

    public void stop(){
        // 修改volatile变量，主线程修改对工作线程立即可见
        flag = false;
    }

    @Test
    public void test1() throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.start();
        Thread.sleep(5000);
        volatileTest.stop();
    }
}
