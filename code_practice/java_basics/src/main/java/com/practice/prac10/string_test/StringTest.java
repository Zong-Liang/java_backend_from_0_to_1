package com.practice.prac10.string_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class StringTest {
    @Test
    public void test1() {
        String str = "Hello";
        str = str + " World"; // 看似修改了 str，但实际上创建了一个新的字符串对象
        System.out.println(str); // 输出：Hello World
        System.out.println("字符串'Hello World'的长度：" + str.length()); // 5);
        System.out.println(str.substring(0, 5));
        System.out.println(str.toUpperCase());
        System.out.println(str.contains("Hello"));
        System.out.println(str.indexOf("World"));
        System.out.println(str.replace("World", "Java"));
        System.out.println(str.lastIndexOf("o"));
        System.out.println(str.trim());

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2); // 输出：true，因为它们引用的是同一个对象

        String str3 = new String("Hello");
        System.out.println(str1 == str3); // 输出：false，因为 str3 是通过 new 创建的，不会使用常量池
        System.out.println(str1.equals(str3)); // 输出：true，因为 equals 方法比较的是字符串的内容
    }
}
