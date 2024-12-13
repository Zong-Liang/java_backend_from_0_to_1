package com.learn_java.sec_02;

public class UseGirlfriend {
    public static void main(String[] args) {
        Girlfriend g1 = Girlfriend.getInstance();
        Girlfriend g2 = Girlfriend.getInstance();
        System.out.println(g1 == g2);
    }
}
