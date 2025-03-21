package com.practice.prac11.queue_test.arraydeque_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class ArrayDequeTest {
    @Test
    public void test1() {
        // 创建ArrayDeque对象（双端队列）
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        // 添加元素
        arrayDeque.addFirst("Apple");       // 添加到头部
        arrayDeque.addLast("Banana");       // 添加到尾部
        arrayDeque.push("Orange");          // 添加到头部（栈操作）
        System.out.println("初始队列: " + arrayDeque);

        // 获取元素
        System.out.println("第一个元素: " + arrayDeque.getFirst());
        System.out.println("最后一个元素: " + arrayDeque.getLast());

        // 删除元素
        arrayDeque.pollFirst();             // 删除头部
        System.out.println("删除后: " + arrayDeque);
        
    }
}
