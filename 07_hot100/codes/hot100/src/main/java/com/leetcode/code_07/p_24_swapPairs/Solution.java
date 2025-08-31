package com.leetcode.code_07.p_24_swapPairs;

import java.util.List;
import java.util.ArrayList;

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
     * 迭代解法
     *
     * 算法思路：
     * 我们可以通过迭代遍历链表，每次处理一对节点，并交换它们的位置。
     * 为了方便地处理头节点的交换，我们引入一个“哑节点”（dummy head），它指向原始链表的头。
     *
     * 1. **初始化**:
     *    - 创建一个哑节点 `dummy`，并使其 `next` 指向原始头节点 `head`。
     *    - 创建一个指针 `prev`，初始时指向 `dummy`。`prev` 将始终指向每一对要交换的节点的前一个节点。
     *
     * 2. **遍历与交换**:
     *    - 我们使用一个循环，只要 `prev` 后面至少还有两个节点（即 `prev.next` 和 `prev.next.next` 都不为空），就继续交换。
     *    - 在循环的每一步：
     *      a. 定义两个指针 `node1` 和 `node2`，分别指向要交换的两个相邻节点。
     *         `node1 = prev.next`
     *         `node2 = prev.next.next`
     *      b. **执行交换**: 这是一个关键的三步指针重定向过程。
     *         - `prev.next = node2;` (将前一个节点连接到第二个节点)
     *         - `node1.next = node2.next;` (将第一个节点连接到第二对的开头)
     *         - `node2.next = node1;` (将第二个节点连接回第一个节点)
     *      c. **更新 `prev` 指针**: 交换完成后，`node1` 已经成为了这对节点的第二个节点。
     *         我们将 `prev` 移动到 `node1` 的位置，为下一轮交换做准备。
     *
     * 3. **返回结果**:
     *    - 循环结束后，所有节点都已两两交换。返回 `dummy.next`，即为新链表的头节点。
     */
    public ListNode swapPairs(ListNode head) {
        // 创建一个哑节点，它的 next 指向头节点
        ListNode dummy = new ListNode(0, head);
        // prev 指向每次要交换的两个节点的前一个节点
        ListNode prev = dummy;

        // 确保 prev 后面至少有两个节点
        while (prev.next != null && prev.next.next != null) {
            // 定义要交换的两个节点
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;

            // 执行交换
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            // 移动 prev 指针，为下一对交换做准备
            prev = node1;
        }

        // 返回新链表的头节点
        return dummy.next;
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
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4});
        ListNode result1 = solution.swapPairs(head1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [1,2,3,4]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [2, 1, 4, 3]

        // 示例 2
        ListNode head2 = createLinkedList(new int[]{});
        ListNode result2 = solution.swapPairs(head2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = []");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 []

        // 示例 3
        ListNode head3 = createLinkedList(new int[]{1});
        ListNode result3 = solution.swapPairs(head3);
        System.out.println("\n示例 3:");
        System.out.println("输入: head = [1]");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 [1]
    }
}
