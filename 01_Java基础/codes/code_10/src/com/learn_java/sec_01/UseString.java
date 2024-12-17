package com.learn_java.sec_01;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class UseString {
    @Test
    public void test1() {
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        String s1 = "hello";
        String s2 = "hello";

        s2 = "hi";

        System.out.println(s1); //hello
        System.out.println(s2); //hello
    }

    @Test
    public void test3() {
        String s1 = "hello";
        String s2 = "hello";

        s2 += " world";

        System.out.println(s1); //hello
        System.out.println(s2); //hello world
    }

    @Test
    public void test4() {
        String s1 = "hello";
        String s2 = s1.replace('l','w');

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test5() {
        String s1 = "hello";
        String s2 = "hello";

        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s3 == s4); //false

        System.out.println(s3.equals(s1)); //true
    }

    @Test
    public void test6() {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1==p2);

        p1.name = "Tom";
        p2.name = "Tom";

        p1.name = "jerry";

        System.out.println(p1.name);
        System.out.println(p2.name);
    }

    @Test
    public void test7() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world"; //通过查看字节码文件发现调用了StringBuilder的toString()方法
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false

        String s8 = s5.intern(); //intern()方法返回字符串常量池中字面量的地址
        System.out.println(s3 == s8); //true
    }

    @Test
    public void test8() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = s1.concat(s2);
        String s4 = "hello".concat("world");
        String s5 = s1.concat("world");
        String s6 = "hello".concat(s2);

        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //false
        System.out.println(s4 == s5); //false
    }

    @Test
    public void test9() {
        String s1 = new String();
        String s2 = new String("");
        String s3 = new String(new char[]{'a', 'b', 'c'});
        System.out.println(s3);
    }

    @Test
    public void test10() throws UnsupportedEncodingException {
        int num = 10;
        //复习：基本数据类型、包装类 to String
        String s1 = num + "";
        String s2 = String.valueOf(num);
        //复习：String to 基本数据类型、包装类
        String s3 = "123";
        int i1 = Integer.parseInt(s3);

        //String to char[]，调用String的toCharArray()方法
        String s4 = "hello";
        char[] c_arr = s4.toCharArray();
        for (char c : c_arr) {
            System.out.println(c);
        }
        //char[] to String
        String s5 = new String(c_arr);
        System.out.println(s5);

        //String to byte[]，调用String的getBytes()方法
        String s6 = "abc中国";
        byte[] b_arr = s6.getBytes(); //使用默认字符集
        for (byte b : b_arr) {
            System.out.println(b);
        }
        String s8 = "ABC中国";
        byte[] b_arr1 = s8.getBytes("GBK"); //使用默认字符集
        for (byte b : b_arr1) {
            System.out.println(b);
        }
        //byte[] to String
        String s7 = new String(b_arr);
        System.out.println(s7);
        String s9 = new String(b_arr1, "GBK");
        System.out.println(s9);
    }

    @Test
    public void test11() {
        String s1 = "";
        String s2 = new String();
        String s3 = new String("");

        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s3.isEmpty());

//        String s4 = null;
//        System.out.println(s4.isEmpty()); //NullPointerException

        String s5 = "hello";
        System.out.println(s5.length());

        String s6 = " world";
        String s7 = s5.concat(s6);
        System.out.println(s7);

        String s8 = "Hello";
        System.out.println(s5.equals(s8));
        System.out.println(s5.equalsIgnoreCase(s8));

        System.out.println(s5.compareTo(s8)); //正数，调用方法的String大
        System.out.println(s5.compareToIgnoreCase(s8));//0，两个String一样大

        String s9 = "AhU";
        System.out.println(s9.toLowerCase());
        System.out.println(s9.toUpperCase());

        String s10 = "   Ah U   ";
        System.out.println(s10.trim()); //除去字符串前后的空格

        String s11 = "helloolleh";
        System.out.println(s11.contains("e"));
        System.out.println(s11.indexOf("ll"));
        System.out.println(s11.indexOf("A")); //没有返回-1
        System.out.println(s11.indexOf("ll", 3));
        System.out.println(s11.lastIndexOf("ll"));
        System.out.println(s11.lastIndexOf("ll", 3));

        System.out.println(s11.substring(5));
        System.out.println(s11.substring(0, 5));

        String s12 = "AHU";
        System.out.println(s12.charAt(1));

        String s13 = String.valueOf(new char[]{'a', 'b', 'c'});
        String s14 = String.copyValueOf(new char[]{'a', 'b', 'c'});
        System.out.println(s13);
        System.out.println(s14);
        System.out.println(s13 == s14);

        System.out.println(s12.startsWith("A"));
        System.out.println(s12.startsWith("H", 1));
        System.out.println(s12.endsWith("U"));

        String s15 = "hhh";
        String s16 = s15.replace("h", "wu");
        System.out.println(s16);
    }
}
