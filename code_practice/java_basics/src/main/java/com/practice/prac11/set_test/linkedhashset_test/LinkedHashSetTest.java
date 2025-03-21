package com.practice.prac11.set_test.linkedhashset_test;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    @Test
    public void test1() {
        // 创建LinkedHashSet对象（保持插入顺序）
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // 添加元素
        linkedHashSet.add("Dog");
        linkedHashSet.add("Cat");
        linkedHashSet.add("Bird");
        System.out.println("初始集合: " + linkedHashSet);

        // 删除元素
        linkedHashSet.remove("Cat");
        System.out.println("删除后: " + linkedHashSet);

        // 查询
        System.out.println("是否包含Bird: " + linkedHashSet.contains("Bird"));
        System.out.println("集合大小: " + linkedHashSet.size());
    }
}
