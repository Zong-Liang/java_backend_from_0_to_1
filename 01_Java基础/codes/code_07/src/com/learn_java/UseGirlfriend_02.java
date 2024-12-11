package com.learn_java;

public class UseGirlfriend_02 {
    public static void main(String[] args) {
        Girlfriend_02 g1 = Girlfriend_02.getInstance();
        Girlfriend_02 g2 = Girlfriend_02.getInstance();
        System.out.println(g1 == g2);
    }
}
