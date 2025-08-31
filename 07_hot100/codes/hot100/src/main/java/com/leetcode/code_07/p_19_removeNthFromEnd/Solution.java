package com.leetcode.code_07.p_19_removeNthFromEnd;

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
     * 快慢指针解法 (一次遍历)
     *
     * 算法思路：
     * 要删除倒数第 n 个节点，我们需要找到这个节点的前一个节点。
     * 使用快慢两个指针，我们可以巧妙地定位到这个位置。
     *
     * 1. **设置哑节点 (Dummy Head)**:
     *    - 创建一个哑节点，并让它指向链表的头节点 `head`。
     *    - 这样做的好处是，即使要删除的是头节点本身（即倒数第 `sz` 个节点），我们也能统一处理，
     *      因为此时要找的是头节点的前一个节点，也就是哑节点。
     *
     * 2. **初始化快慢指针**:
     *    - `fast` 和 `slow` 两个指针都初始化为哑节点 `dummy`。
     *
     * 3. **拉开距离**:
     *    - 让 `fast` 指针先向前移动 `n` 步。
     *    - 这样，`fast` 和 `slow` 之间就有了 `n` 个节点的距离。
     *
     * 4. **同步移动**:
     *    - 接着，同时移动 `fast` 和 `slow` 指针，一步一步地向前，直到 `fast.next` 为 `null`。
     *    - 当 `fast` 到达链表末尾时，`slow` 指针恰好位于要删除节点的前一个位置。
     *      （因为它们之间始终保持着 `n` 个节点的距离）。
     *
     * 5. **删除节点**:
     *    - 执行删除操作：`slow.next = slow.next.next`。
     *
     * 6. **返回结果**:
     *    - 返回 `dummy.next`，即为新链表的头节点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑节点，用于处理删除头节点的情况
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时走，直到快指针到达链表末尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时 slow 指向的是待删除节点的前一个节点
        // 执行删除操作
        slow.next = slow.next.next;

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
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        int n1 = 2;
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [1,2,3,4,5], n = 2");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [1, 2, 3, 5]

        // 示例 2
        ListNode head2 = createLinkedList(new int[]{1});
        int n2 = 1;
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [1], n = 1");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 []

        // 示例 3
        ListNode head3 = createLinkedList(new int[]{1, 2});
        int n3 = 1;
        ListNode result3 = solution.removeNthFromEnd(head3, n3);
        System.out.println("\n示例 3:");
        System.out.println("输入: head = [1,2], n = 1");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 [1]
    }
}
