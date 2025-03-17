package com.practice.prac10.string_builder_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * StringBuilder 是 Java 中一个非常实用的类，用于高效地处理字符串拼接操作。
 * 它是从 Java 1.5 开始引入的，旨在解决 String 类由于不可变性导致的性能问题。
 * 与 String 不同，StringBuilder 是可变的，这意味着它可以修改内容而不需要创建新的对象。
 */
public class StringBuilderTest {
    @Test
    public void test1() {
        // 创建 StringBuilder 对象
        StringBuilder sb = new StringBuilder("Hello");

        // 拼接字符串
        sb.append(" World");
        System.out.println(sb.toString());
        sb.append(123);
        System.out.println(sb.toString());

        // 插入字符串
        sb.insert(0, "Start: ");
        System.out.println(sb.toString());
        sb.insert(6, "Middle");
        System.out.println(sb.toString());

        // 删除子字符串
        sb.delete(6, 12);
        System.out.println(sb.toString());

        // 替换子字符串
        sb.replace(6, 11, "Java");
        System.out.println(sb.toString());

        // 反转字符串
        sb.reverse();
        System.out.println(sb.toString());

        // 获取和设置字符
        char c = sb.charAt(1);
        sb.setCharAt(1, 'a');

        // 转换为字符串
        //String result = sb.toString();

        // 输出结果
        System.out.println(sb.toString());
    }
}
