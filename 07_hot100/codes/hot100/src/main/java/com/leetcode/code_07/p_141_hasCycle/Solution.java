package com.leetcode.code_07.p_141_hasCycle;

/**
 * LeetCode 提供的链表节点定义。
 * 在实际 LeetCode 环境中无需自己定义。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    /**
     * 快慢指针解法 (Floyd 判环算法)
     *
     * 算法思路：
     * 我们可以把链表想象成一个跑道。如果这个跑道是环形的，那么一个跑得快的选手（快指针）
     * 最终一定会从后面追上一个跑得慢的选手（慢指针）。如果跑道是线性的，快选手只会先到达终点。
     *
     * 1. **初始化指针**:
     *    - 创建两个指针，`slow` 和 `fast`，都从链表的头节点 `head` 开始。
     *
     * 2. **移动指针**:
     *    - 在一个循环中，`slow` 指针每次向前移动一步。
     *    - `fast` 指针每次向前移动两步。
     *
     * 3. **判断条件**:
     *    - **相遇**: 如果在移动过程中，`fast` 指针和 `slow` 指针指向了同一个节点 (`fast == slow`)，
     *      这就证明链表中存在一个环。我们返回 `true`。
     *    - **到达终点**: 如果 `fast` 指针或者 `fast.next` 变成了 `null`，说明快指针已经到达了链表的末尾，
     *      这意味着链表中没有环。我们返回 `false`。
     *
     * 4. **空间复杂度**:
     *    - 这个算法只使用了两个额外的指针，所以空间复杂度是 O(1)，满足了题目的进阶要求。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // 如果快指针到达末尾，说明没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果循环结束，说明 slow 和 fast 相遇了
        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node0;
        node0.next = node_4;
        node_4.next = node2; // 形成环
        boolean result1 = solution.hasCycle(head1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [3,2,0,-4], pos = 1");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // 形成环
        boolean result2 = solution.hasCycle(head2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [1,2], pos = 0");
        System.out.println("输出: " + result2); // 应输出 true

        // 示例 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);
        boolean result3 = solution.hasCycle(head3);
        System.out.println("\n示例 3:");
        System.out.println("输入: head = [1], pos = -1");
        System.out.println("输出: " + result3); // 应输出 false
    }
}
