package com.learn_java.sec_15;

public class Clerk {//店员
    private int productNumber = 0;//产品数量

    public synchronized void addProductNumber(){
        if (productNumber>=20){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            productNumber++;
            System.out.println(Thread.currentThread().getName() + " produced the " + productNumber + " product.");
            notifyAll();
        }
    }

    public synchronized void minusProductNumber(){
        if (productNumber<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println(Thread.currentThread().getName() + " consumed the " + productNumber + " product.");
            productNumber--;
            notifyAll();
        }
    }
}
