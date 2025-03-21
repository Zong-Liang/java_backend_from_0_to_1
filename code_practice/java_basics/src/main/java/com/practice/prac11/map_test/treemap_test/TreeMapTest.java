package com.practice.prac11.map_test.treemap_test;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class TreeMapTest {
    @Test
    public void test1() {
        // 创建TreeMap对象（键按自然顺序排序）
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // 添加键值对
        treeMap.put("Charlie", 28);
        treeMap.put("Alice", 22);
        treeMap.put("Bob", 27);
        System.out.println("初始映射: " + treeMap);

        // 获取值
        System.out.println("第一个键: " + treeMap.firstKey());
        System.out.println("最后一个键: " + treeMap.lastKey());

        // 子映射
        System.out.println("子映射: " + treeMap.subMap("Alice", "Charlie"));
    }
}
