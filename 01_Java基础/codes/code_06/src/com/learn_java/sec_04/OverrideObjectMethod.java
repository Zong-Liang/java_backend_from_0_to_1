package com.learn_java.sec_04;

import java.io.File;
import java.util.Date;

//equals(Object obj)适用任何引用类型。自定义的类在没有重写equals()方法的情况下，调用的就是Object类中声明的equals()方法，比较的是两个对象的引用地址是否相同。
//对于像String、File、Date和包装类等，都重写了Object类中的equals()方法，比较的是两个对象的实体内容是否相等。
//平时在调用System.out.println()打印对象引用变量时，其实就是调用了对象的toString()方法。
public class OverrideObjectMethod {
    public static void main(String[] args) {
        User u1=new User("Tom", 25);
        User u2=new User("Tom", 25);
        System.out.println(u1.equals(u2));  //true after overwrite

        //对于像string、File、Date和包装类等，它们都重写了0bject类中的equals()
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));  //true

        File f1 = new File("test.txt");
        File f2 = new File("test.txt");
        System.out.println(f1.equals(f2));  //true

        //数组使用equals()
        int[] arr = new int[10];
        System.out.println(arr.equals(new int[10]));  //false

        User u3=new User("Jerry", 22);
        System.out.println(u3);  //User{name='Jerry', age=22}
        System.out.println(u3.toString());  //User{name='Jerry', age=22}

        //对于像string、File、Date和包装类等，它们都重写了0bject类中的toString()
        String s3 = "hello";
        System.out.println(s3);  //hello
        System.out.println(s3.toString());  //hello

        File f3 = new File("test.txt");
        System.out.println(f3);  //test.txt
        System.out.println(f3.toString());  //test.txt

        Date d1 = new Date();
        System.out.println(d1);  //Wed Dec 11 09:54:27 CST 2024
        System.out.println(d1.toString());  //Wed Dec 11 09:54:27 CST 2024
    }
}
