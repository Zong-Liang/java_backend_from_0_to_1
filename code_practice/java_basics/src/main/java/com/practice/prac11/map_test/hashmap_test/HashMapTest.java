package com.practice.prac11.map_test.hashmap_test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    @Test
    public void test1() {
        // 创建HashMap对象
        Map<String, Integer> hashMap = new HashMap<>();

        // 添加键值对
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Alice", 26);           // 键重复会覆盖
        System.out.println("初始映射: " + hashMap);

        // 获取值
        System.out.println("Bob的年龄: " + hashMap.get("Bob"));

        // 删除键值对
        hashMap.remove("Alice");
        System.out.println("删除后: " + hashMap);

        // 查询
        System.out.println("是否包含键Bob: " + hashMap.containsKey("Bob"));
        System.out.println("是否包含值30: " + hashMap.containsValue(30));
        System.out.println("映射大小: " + hashMap.size());

        // 遍历
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("键: " + entry.getKey() + ", 值: " + entry.getValue());
        }
    }
}
