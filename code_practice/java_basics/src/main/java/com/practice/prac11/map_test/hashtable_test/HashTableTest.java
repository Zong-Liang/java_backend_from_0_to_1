package com.practice.prac11.map_test.hashtable_test;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Zong Liang
 * HashTable 是⼀个古⽼的哈希表实现，其⽅法都是同步的，因此是线程安全的。
 * 但它的使⽤已经不太推荐，通常建议使⽤ HashMap 。
 */
public class HashTableTest {
    @Test
    public void test1() {
        // 创建Hashtable对象（线程安全，不允许null键或值）
        Map<String, Integer> hashtable = new Hashtable<>();

        // 添加键值对
        hashtable.put("David", 35);
        hashtable.put("Eve", 29);
        System.out.println("初始映射: " + hashtable);

        // 获取值
        System.out.println("David的年龄: " + hashtable.get("David"));

        // 删除键值对
        hashtable.remove("Eve");
        System.out.println("删除后: " + hashtable);

        // 查询
        System.out.println("键集: " + hashtable.keySet());
        System.out.println("值集: " + hashtable.values());
        
    }
}
