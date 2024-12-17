package com.learn_java.sec_15;

public class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Producer starts to produce product：");
            clerk.addProductNumber();
        }
    }
}
