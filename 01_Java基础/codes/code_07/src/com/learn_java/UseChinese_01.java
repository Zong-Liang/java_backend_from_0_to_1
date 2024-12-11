package com.learn_java;

public class UseChinese_01 {
    public static void main(String[] args) {
        //static修饰的属性可以通过类直接访问
        System.out.println(Chinese_01.nation);
        Chinese_01.selfIntro();

        Chinese_01 c1 = new Chinese_01("zl", 25);
        System.out.println(c1);
        Chinese_01 c2 = new Chinese_01("wh", 25);
        System.out.println(c2);

        System.out.println(c1.nation);
        c2.nation = "uk";
        System.out.println(c2.nation);
    }
}
