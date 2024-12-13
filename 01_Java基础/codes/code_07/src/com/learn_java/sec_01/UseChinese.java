package com.learn_java.sec_01;

public class UseChinese {
    public static void main(String[] args) {
        //static修饰的属性可以通过类直接访问
        System.out.println(Chinese.nation);
        Chinese.selfIntro();

        Chinese c1 = new Chinese("zl", 25);
        System.out.println(c1);
        Chinese c2 = new Chinese("wh", 25);
        System.out.println(c2);

        System.out.println(c1.nation);
        c2.nation = "uk";
        System.out.println(c2.nation);
    }
}
