package com.learn_java.sec_02;

import org.junit.jupiter.api.Test;

public class UseStringBufferAndStringBuilder {
    @Test
    public void test1() {
        StringBuilder sbd1 = new StringBuilder();
        sbd1.append("1").append("2").append("3");
        System.out.println(sbd1);

        sbd1.insert(2, "4");
        sbd1.insert(2, "false");
        System.out.println(sbd1);

        StringBuilder sbd2 = sbd1.reverse();
        System.out.println(sbd1);
        System.out.println(sbd1 == sbd2);

        System.out.println(sbd1.length()); //实际存储字符的个数

        sbd1.setLength(3);
        System.out.println(sbd1);

        StringBuffer sbf1 = new StringBuffer();
        sbf1.append("1").append("2").append("3");
        System.out.println(sbf1);

        sbf1.insert(2, "4");
        sbf1.insert(2, "false");
        System.out.println(sbf1);

        StringBuffer sbf2 = sbf1.reverse();
        System.out.println(sbf1);
        System.out.println(sbf1 == sbf2);

        System.out.println(sbf1.length()); //实际存储字符的个数

        sbf1.setLength(3);
        System.out.println(sbf1);
    }

    @Test
    public void test2() {
        long startTime = 0L;
        long endTime = 0L;
        String str = "";

        StringBuilder sbd = new StringBuilder("");
        StringBuffer sbf = new StringBuffer("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            sbd.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            sbf.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            str += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间：" + (endTime - startTime));
    }
}
