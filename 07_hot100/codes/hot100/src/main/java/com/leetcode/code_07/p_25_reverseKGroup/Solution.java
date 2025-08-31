package com.leetcode.code_07.p_25_reverseKGroup;

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
     * 递归解法
     *
     * 算法思路：
     * 我们可以将原问题分解为子问题：
     * 1. 翻转链表的前 k 个节点。
     * 2. 将翻转后的这 k 个节点的尾部，连接到对剩余链表递归调用相同操作的结果上。
     *
     * 1. **检查与分组**:
     *    - 首先，我们需要检查当前链表 `head` 是否还有足够的 `k` 个节点可供翻转。
     *    - 我们可以用一个指针从 `head` 开始向前走 `k` 步。如果中途遇到 `null`，说明剩余节点不足 `k` 个，
     *      那么根据题意，我们不需要翻转它们，直接返回 `head` 即可。
     *
     * 2. **翻转当前组**:
     *    - 如果有足够的节点，我们就需要翻转从 `head` 开始的这 `k` 个节点。
     *    - 我们可以使用一个辅助函数 `reverse(head, tail)` 或者在主函数内实现标准的链表翻转逻辑。
     *    - 翻转后，原来的头节点 `head` 会变成这组的尾节点，而原来的第 `k` 个节点会成为新的头节点 `newHead`。
     *
     * 3. **连接子问题**:
     *    - 翻转完成后，原来的头节点 `head`（现在是尾节点）的 `next` 指针需要指向下一组翻转后的结果。
     *    - 我们通过递归调用 `reverseKGroup(kthNode, k)` 来获取下一组翻转后的头节点，并将其连接到 `head.next`。
     *      这里的 `kthNode` 是指原链表中第 k+1 个节点，即下一组的开始。
     *
     * 4. **返回结果**:
     *    - 递归的每一层都返回当层翻转后产生的新头节点 `newHead`。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 检查剩余部分是否有足够的 k 个节点
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                // 不足 k 个，不翻转，直接返回原头节点
                return head;
            }
            curr = curr.next;
        }

        // 2. 翻转当前 k 个节点
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        // 3. 连接子问题
        // 此时，`prev` 是翻转后新组的头，`head` 是翻转后新组的尾
        // `current` 指向下一组的头
        if (current != null) {
            head.next = reverseKGroup(current, k);
        }

        // 4. 返回当前组翻转后的头节点
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
        int k1 = 2;
        ListNode result1 = solution.reverseKGroup(head1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [1,2,3,4,5], k = 2");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [2, 1, 4, 3, 5]

        // 示例 2
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        int k2 = 3;
        ListNode result2 = solution.reverseKGroup(head2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [1,2,3,4,5], k = 3");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 [3, 2, 1, 4, 5]
    }
}
