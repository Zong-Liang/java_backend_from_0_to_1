package com.practice.prac11.map_test.linkedhashmap_test;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    @Test
    public void test1() {
        // 创建LinkedHashMap对象（保持插入顺序）
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // 添加键值对
        linkedHashMap.put("Charlie", 28);
        linkedHashMap.put("Alice", 22);
        linkedHashMap.put("Bob", 27);
        System.out.println("初始映射: " + linkedHashMap);

        // 获取值
        System.out.println("Alice的年龄: " + linkedHashMap.get("Alice"));

        // 删除键值对
        linkedHashMap.remove("Bob");
        System.out.println("删除后: " + linkedHashMap);
    }
}
