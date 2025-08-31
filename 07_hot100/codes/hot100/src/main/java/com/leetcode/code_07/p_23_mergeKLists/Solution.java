package com.leetcode.code_07.p_23_mergeKLists;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * LeetCode 提供的链表节点定义。
 * 在实际 LeetCode 环境中无需自己定义。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    /**
     * 优先队列 (最小堆) 解法
     *
     * 算法思路：
     * 这个问题可以看作是“合并两个有序链表”的扩展。一个直接的方法是两两合并，但效率不高。
     * 更高效的方法是使用一个最小堆（在 Java 中由 `PriorityQueue` 实现）来维护 K 个链表的当前头节点。
     *
     * 1. **初始化**:
     *    - 创建一个最小堆，用于存储链表节点。我们需要自定义比较器，使其根据节点的 `val` 值进行排序。
     *    - 遍历输入的链表数组 `lists`，将每个非空链表的头节点加入到最小堆中。
     *
     * 2. **构建合并链表**:
     *    - 创建一个哑节点 `dummyHead` 和一个 `tail` 指针，用于构建最终的合并链表。
     *    - 当最小堆不为空时，循环继续：
     *      a. 从堆中取出（`poll`）当前值最小的节点 `minNode`。这个节点就是合并后链表的下一个节点。
     *      b. 将 `minNode` 连接到 `tail.next`，然后移动 `tail` 指针。
     *      c. 检查 `minNode` 是否有下一个节点 `minNode.next`。如果有，将其加入最小堆。
     *         这样，堆中始终保存着 K 个链表中“待选”的最小节点。
     *
     * 3. **返回结果**:
     *    - 循环结束后，所有节点都已被正确地连接到新链表中。返回 `dummyHead.next` 即可。
     *
     * **复杂度分析**:
     * - 假设总共有 N 个节点，K 个链表。
     * - 时间复杂度: O(N log K)。堆中最多有 K 个元素，每个节点都会入堆和出堆一次（log K），总共 N 个节点。
     * - 空间复杂度: O(K)，用于存储堆中的 K 个节点。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建一个最小堆，并定义比较器
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将所有链表的头节点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        // 不断从堆中取出最小节点，并将其下一个节点加入堆中
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummyHead.next;
    }

    // 辅助函数：根据数组创建链表
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // 辅助函数：打印链表
    public static String printLinkedList(ListNode head) {
        if (head == null) return "[]";
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.toString();
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        ListNode[] lists1 = {
                createLinkedList(new int[]{1, 4, 5}),
                createLinkedList(new int[]{1, 3, 4}),
                createLinkedList(new int[]{2, 6})
        };
        ListNode result1 = solution.mergeKLists(lists1);
        System.out.println("示例 1:");
        System.out.println("输入: lists = [[1,4,5],[1,3,4],[2,6]]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [1, 1, 2, 3, 4, 4, 5, 6]

        // 示例 2
        ListNode[] lists2 = {};
        ListNode result2 = solution.mergeKLists(lists2);
        System.out.println("\n示例 2:");
        System.out.println("输入: lists = []");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 []

        // 示例 3
        ListNode[] lists3 = {createLinkedList(new int[]{})};
        ListNode result3 = solution.mergeKLists(lists3);
        System.out.println("\n示例 3:");
        System.out.println("输入: lists = [[]]");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 []
    }
}
