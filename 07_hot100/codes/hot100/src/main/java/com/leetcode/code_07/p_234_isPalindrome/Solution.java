package com.leetcode.code_07.p_234_isPalindrome;

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
     * 快慢指针 + 反转链表解法 (O(1) 空间)
     *
     * 算法思路：
     * 为了在不使用额外空间的情况下判断回文，我们可以将链表的后半部分反转，
     * 然后将前半部分与反转后的后半部分进行比较。
     *
     * 整个过程分为三步：
     * 1. **找到链表的中点**:
     *    - 使用快慢指针法。`slow` 指针每次走一步，`fast` 指针每次走两步。
     *    - 当 `fast` 指针到达链表末尾时，`slow` 指针恰好位于链表的中点。
     *
     * 2. **反转后半部分链表**:
     *    - 从中点 `slow` 的下一个节点开始，对链表的后半部分执行标准的链表反转操作。
     *
     * 3. **比较前后两半**:
     *    - 设置两个指针，一个指向原始头节点 `head`，另一个指向反转后后半部分的头节点。
     *    - 同时遍历这两部分，比较对应节点的值。
     *    - 如果在任何时候发现值不相等，则链表不是回文。
     *    - 如果两部分都顺利遍历完毕，则链表是回文。
     *
     * (可选) 4. **恢复链表**:
     *    - 为了保持原始链表结构不变（在某些面试场景下可能要求），可以再次反转后半部分链表，
     *      将其恢复到原始状态。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分链表
        ListNode secondHalfHead = reverse(slow.next);

        // 3. 比较前后两半
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;
        while (isPalindrome && p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. (可选) 恢复链表
        slow.next = reverse(secondHalfHead);

        return isPalindrome;
    }

    // 辅助函数：反转链表
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        ListNode head1 = createLinkedList(new int[]{1, 2, 2, 1});
        boolean result1 = solution.isPalindrome(head1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [1,2,2,1]");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        ListNode head2 = createLinkedList(new int[]{1, 2});
        boolean result2 = solution.isPalindrome(head2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [1,2]");
        System.out.println("输出: " + result2); // 应输出 false
    }
}
