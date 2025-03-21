package com.practice.prac11.set_test.hashset_test;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    @Test
    public void test1() {
        // 创建HashSet对象
        Set<String> hashSet = new HashSet<>();

        // 添加元素
        hashSet.add("Apple");               // 添加元素
        hashSet.add("Banana");
        hashSet.add("Apple");               // 重复元素不会添加
        System.out.println("初始集合: " + hashSet);

        // 删除元素
        hashSet.remove("Banana");           // 删除指定元素
        System.out.println("删除后: " + hashSet);

        // 查询
        System.out.println("是否包含Apple: " + hashSet.contains("Apple"));
        System.out.println("集合大小: " + hashSet.size());

                // 清空集合
                hashSet.clear();
        System.out.println("清空后: " + hashSet);
    }
}
