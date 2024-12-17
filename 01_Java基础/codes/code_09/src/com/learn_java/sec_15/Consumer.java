package com.learn_java.sec_15;

public class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consumer starts to consume product：");
            clerk.minusProductNumber();
        }
    }

}
