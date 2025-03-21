package com.practice.prac11.set_test.treeset_test;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test1() {
        // 创建TreeSet对象（自然排序）
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 添加元素
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        System.out.println("初始集合: " + treeSet);

        // 获取元素
        System.out.println("第一个元素: " + treeSet.first());
        System.out.println("最后一个元素: " + treeSet.last());

        // 删除元素
        treeSet.remove(20);
        System.out.println("删除后: " + treeSet);

        // 子集操作
        System.out.println("子集(10-30): " + treeSet.subSet(10, true, 30, true));
    }
}
