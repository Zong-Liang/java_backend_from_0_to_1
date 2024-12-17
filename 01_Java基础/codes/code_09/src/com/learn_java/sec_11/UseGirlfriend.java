package com.learn_java.sec_11;

public class UseGirlfriend {
    static Girlfriend girlfriend1;
    static Girlfriend girlfriend2;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            girlfriend1 = Girlfriend.getInstance();
            System.out.println(girlfriend1);
        });

        Thread t2 = new Thread(() -> {
            girlfriend2 = Girlfriend.getInstance();
            System.out.println(girlfriend2);
        });

        t1.start();
        t2.start();

        // 等待线程t1和t2执行完毕
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(girlfriend1);
        System.out.println(girlfriend2);
        System.out.println(girlfriend1 == girlfriend2);
    }
}
