package com.practice.prac11.list_test.linkedlist_test;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class LinkedListTest {
    @Test
    public void test1() {
        // 创建LinkedList对象
        LinkedList<String> linkedList = new LinkedList<>();

        // 添加元素
        linkedList.add("Cat");              // 添加到末尾
        linkedList.addFirst("Dog");         // 添加到头部
        linkedList.addLast("Bird");         // 添加到尾部
        System.out.println("初始列表: " + linkedList);

        // 获取元素
        System.out.println("第一个元素: " + linkedList.getFirst());
        System.out.println("最后一个元素: " + linkedList.getLast());

        // 删除元素
        linkedList.removeFirst();           // 删除头部
        linkedList.removeLast();            // 删除尾部
        System.out.println("删除后: " + linkedList);

        // 查询
        System.out.println("列表大小: " + linkedList.size());
        System.out.println("是否包含Cat: " + linkedList.contains("Cat"));

        // 作为队列使用
        linkedList.offer("Fish");           // 入队
        System.out.println("入队后: " + linkedList);
        System.out.println("出队: " + linkedList.poll()); // 出队
    }
}
