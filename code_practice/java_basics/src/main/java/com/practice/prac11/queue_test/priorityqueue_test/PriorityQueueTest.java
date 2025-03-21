package com.practice.prac11.queue_test.priorityqueue_test;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    @Test
    public void test1() {
        // 创建PriorityQueue对象（默认最小堆）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 添加元素
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        System.out.println("初始队列: " + priorityQueue);

        // 查看队首元素
        System.out.println("队首元素: " + priorityQueue.peek());

        // 出队
        System.out.println("出队: " + priorityQueue.poll());
        System.out.println("出队后: " + priorityQueue);
        
    }
}
