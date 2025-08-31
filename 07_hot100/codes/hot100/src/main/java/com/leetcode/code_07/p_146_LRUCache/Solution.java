package com.leetcode.code_07.p_146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表节点
 */
class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {}
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * 核心解法：LRUCache 类的实现
 *
 * 算法思路 (哈希表 + 双向链表):
 * 为了同时满足 O(1) 的查找和 O(1) 的插入/删除，单一的数据结构无法胜任。
 * - **哈希表 (HashMap)**: 提供了 O(1) 的查找能力。我们可以用它来存储 `key` 到链表节点的映射。
 * - **双向链表 (Doubly Linked List)**: 提供了 O(1) 的节点插入和删除能力。我们可以用它来维护数据的“最近使用”顺序。
 *
 * **具体实现**:
 * 1. **数据结构**:
 *    - `cache`: 一个 `HashMap<Integer, DLinkedNode>`，用于快速定位节点。
 *    - `head`, `tail`: 两个哑节点，构成双向链表的头尾，简化边界操作。
 *    - `size`: 当前缓存的大小。
 *    - `capacity`: 缓存的总容量。
 *
 * 2. **链表顺序**:
 *    - 我们规定，越靠近 `head` 的节点表示越“最近使用”。
 *    - 越靠近 `tail` 的节点表示越“最久未使用”。
 *
 * 3. **核心操作**:
 *    - `moveToHead(node)`: 将一个已存在的节点移动到链表头部（`head` 之后）。
 *    - `removeNode(node)`: 从链表中删除一个节点。
 *    - `addToHead(node)`: 将一个新节点添加到链表头部。
 *    - `removeTail()`: 删除链表尾部的节点（最久未使用的）。
 *
 * 4. **`get(key)` 方法**:
 *    - 通过哈希表查找 `key` 对应的节点。
 *    - 如果不存在，返回 -1。
 *    - 如果存在，将该节点通过 `moveToHead` 操作移到链表头部，表示它刚刚被使用过。
 *    - 返回节点的值。
 *
 * 5. **`put(key, value)` 方法**:
 *    - 通过哈希表查找 `key` 对应的节点。
 *    - **如果节点已存在**:
 *      - 更新节点的值。
 *      - 将该节点通过 `moveToHead` 操作移到链表头部。
 *    - **如果节点不存在**:
 *      - 创建一个新节点。
 *      - 将新节点添加到哈希表和链表头部 (`addToHead`)。
 *      - `size` 加 1。
 *      - 检查 `size` 是否超过 `capacity`。如果是，则删除链表尾部最久未使用的节点 (`removeTail`)，并从哈希表中移除它，`size` 减 1。
 */
class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用哑节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，则通过 moveToHead 操作将其移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 如果 key 已存在，修改 value 并移到头部
            node.value = value;
            moveToHead(node);
        } else {
            // 如果 key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            if (size > capacity) {
                // 如果超出容量，删除尾部节点
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


// 这是为了匹配题目要求的格式而创建的测试类
public class Solution {
    public static void main(String[] args) {
        // 示例
        LRUCache lRUCache = new LRUCache(2);
        System.out.println("LRUCache lRUCache = new LRUCache(2);");

        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.println("lRUCache.put(1, 1);");

        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println("lRUCache.put(2, 2);");

        int val1 = lRUCache.get(1); // 返回 1
        System.out.println("lRUCache.get(1);      // 返回 " + val1);

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println("lRUCache.put(3, 3);");

        int val2 = lRUCache.get(2); // 返回 -1 (未找到)
        System.out.println("lRUCache.get(2);      // 返回 " + val2);

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println("lRUCache.put(4, 4);");

        int val3 = lRUCache.get(1); // 返回 -1 (未找到)
        System.out.println("lRUCache.get(1);      // 返回 " + val3);

        int val4 = lRUCache.get(3); // 返回 3
        System.out.println("lRUCache.get(3);      // 返回 " + val4);

        int val5 = lRUCache.get(4); // 返回 4
        System.out.println("lRUCache.get(4);      // 返回 " + val5);
    }
}
