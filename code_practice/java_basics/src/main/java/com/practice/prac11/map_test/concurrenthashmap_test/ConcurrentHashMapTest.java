package com.practice.prac11.map_test.concurrenthashmap_test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Zong Liang
 * ConcurrentHashMap 是 Java 集合框架中位于 java.util.concurrent 包下的一个线程安全的哈希表实现。
 * 它是 HashMap 的并发版本，专为多线程环境设计，提供高效的并发访问支持。
 * 相比传统的 Hashtable（也是线程安全的），ConcurrentHashMap 在性能上更优，
 * 因为它采用了分段锁（Java 7）或 CAS + 同步机制（Java 8+）来减少锁竞争。
 */
public class ConcurrentHashMapTest {
    @Test
    public void test1() throws InterruptedException {
        // 创建ConcurrentHashMap实例，初始容量16，加载因子0.75，并发级别8
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>(16, 0.75f, 8);

        // 1. 基本操作示例
        // 添加键值对
        concurrentMap.put("Alice", 25);
        concurrentMap.put("Bob", 30);
        System.out.println("初始映射: " + concurrentMap);

        // 获取值
        System.out.println("Alice的年龄: " + concurrentMap.get("Alice"));

        // 键不存在时添加
        concurrentMap.putIfAbsent("Charlie", 28);
        System.out.println("添加Charlie后: " + concurrentMap);

        // 删除键值对
        concurrentMap.remove("Bob");
        System.out.println("删除Bob后: " + concurrentMap);

        // 计算操作：对指定键的值加10
        concurrentMap.compute("Alice", (key, value) -> value == null ? 0 : value + 10);
        System.out.println("计算后Alice的年龄: " + concurrentMap.get("Alice"));

        // 查询大小（仅近似值）
        System.out.println("映射大小: " + concurrentMap.size());

        // 2. 多线程并发操作示例
        ExecutorService executor = Executors.newFixedThreadPool(3); // 创建线程池

        // 线程1：添加键值对
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                concurrentMap.put("Thread1-Key" + i, i);
                System.out.println(Thread.currentThread().getName() + " 添加: Thread1-Key" + i);
                try {
                    Thread.sleep(100); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 线程2：读取键值对
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " 读取Alice: " + concurrentMap.get("Alice"));
                try {
                    Thread.sleep(150); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 线程3：更新键值对
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                concurrentMap.compute("Charlie", (key, value) -> value == null ? 0 : value + 1);
                System.out.println(Thread.currentThread().getName() + " 更新Charlie: " + concurrentMap.get("Charlie"));
                try {
                    Thread.sleep(200); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 关闭线程池并等待任务完成
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // 输出最终结果
        System.out.println("\n最终映射: " + concurrentMap);

        // 3. 遍历示例
        System.out.println("\n遍历键值对:");
        concurrentMap.forEach((key, value) -> System.out.println("键: " + key + ", 值: " + value));
    }
}
