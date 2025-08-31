package com.leetcode.code_07.p_21_mergeTwoLists;

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
     * 我们可以创建一个新的链表来存储合并后的结果。通过同时遍历两个输入的有序链表 `l1` 和 `l2`，
     * 比较它们当前节点的值，并将较小的节点连接到新链表的末尾。
     *
     * 1. **设置哑节点 (Dummy Head)**:
     *    - 创建一个哑节点 `dummyHead` 作为新链表的虚拟头节点。这有助于简化代码，
     *      因为我们不需要特殊处理第一个节点的插入。
     *    - 创建一个 `tail` 指针，用于追踪新链表的最后一个节点，初始时指向 `dummyHead`。
     *
     * 2. **遍历与比较**:
     *    - 当 `l1` 和 `l2` 都不为空时，进入循环：
     *      a. 比较 `l1.val` 和 `l2.val`。
     *      b. 如果 `l1.val` 更小，就将 `l1` 连接到 `tail.next`，然后将 `l1` 指针后移。
     *      c. 否则，将 `l2` 连接到 `tail.next`，然后将 `l2` 指针后移。
     *      d. 无论连接了哪个节点，都需要将 `tail` 指针移动到新链表的末尾。
     *
     * 3. **处理剩余部分**:
     *    - 循环结束后，`l1` 和 `l2` 中最多只有一个还不为空。
     *    - 我们需要将这个非空的链表的剩余部分直接连接到 `tail.next`。
     *
     * 4. **返回结果**:
     *    - 返回 `dummyHead.next`，即为合并后链表的真正头节点。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建哑节点
        ListNode dummyHead = new ListNode(0);
        // tail 指针用于构建新链表
        ListNode tail = dummyHead;

        // 当两个链表都不为空时
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 连接剩余的非空链表
        tail.next = (l1 != null) ? l1 : l2;

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
        ListNode l1_1 = createLinkedList(new int[]{1, 2, 4});
        ListNode l2_1 = createLinkedList(new int[]{1, 3, 4});
        ListNode result1 = solution.mergeTwoLists(l1_1, l2_1);
        System.out.println("示例 1:");
        System.out.println("输入: l1 = [1,2,4], l2 = [1,3,4]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [1, 1, 2, 3, 4, 4]

        // 示例 2
        ListNode l1_2 = createLinkedList(new int[]{});
        ListNode l2_2 = createLinkedList(new int[]{});
        ListNode result2 = solution.mergeTwoLists(l1_2, l2_2);
        System.out.println("\n示例 2:");
        System.out.println("输入: l1 = [], l2 = []");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 []

        // 示例 3
        ListNode l1_3 = createLinkedList(new int[]{});
        ListNode l2_3 = createLinkedList(new int[]{0});
        ListNode result3 = solution.mergeTwoLists(l1_3, l2_3);
        System.out.println("\n示例 3:");
        System.out.println("输入: l1 = [], l2 = [0]");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 [0]
    }
}
