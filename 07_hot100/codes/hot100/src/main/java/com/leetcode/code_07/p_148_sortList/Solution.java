package com.leetcode.code_07.p_148_sortList;

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
     * 自底向上归并排序解法
     *
     * 算法思路：
     * 传统的递归归并排序需要 O(log n) 的递归栈空间。为了实现 O(1) 的空间复杂度，
     * 我们可以采用自底向上的迭代式归并排序。
     *
     * 1. **核心思想**:
     *    - 首先，我们将链表中的每个节点看作是一个长度为 1 的已排序子链表。
     *    - 然后，我们两两合并这些子链表，得到若干个长度为 2 的已排序子链表。
     *    - 接着，我们再两两合并这些长度为 2 的子链表，得到长度为 4 的...
     *    - 这个过程不断重复，每次将子链表的长度 `subLen` 翻倍 (`1, 2, 4, 8, ...`)，
     *      直到 `subLen` 大于或等于整个链表的长度，此时整个链表就已经排序完毕。
     *
     * 2. **算法流程**:
     *    a. 首先计算链表的总长度 `length`。
     *    b. 创建一个哑节点 `dummyHead` 指向原始头节点，这有助于处理头部的合并操作。
     *    c. 外层循环 `for (int subLen = 1; subLen < length; subLen <<= 1)`，控制每次合并的子链表长度。
     *    d. 内层循环负责遍历整个链表，找出需要合并的每一对子链表 (`h1` 和 `h2`)。
     *       - `prev` 指针用于连接合并后的子链表。
     *       - `curr` 指针用于在链表中前进，定位每一组的起点。
     *    e. **分割与合并**:
     *       - 从 `prev.next` 开始，找到长度为 `subLen` 的第一个子链表 `h1`。
     *       - 从 `h1` 的末尾开始，找到长度为 `subLen` 的第二个子链表 `h2`。
     *       - **关键**: 切断 `h1` 和 `h2` 与后面链表的连接，以隔离出两个待合并的子链表。
     *       - 调用一个 `merge(h1, h2)` 函数（与“合并两个有序链表”问题相同）来合并这两个子链表。
     *       - 将合并后的子链表连接到 `prev` 后面。
     *       - 移动 `prev` 指针到合并后子链表的末尾，为下一对的连接做准备。
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        // 2. 自底向上归并
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;

            while (curr != null) {
                // 找到第一段 h1
                ListNode h1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }

                // 找到第二段 h2
                ListNode h2 = curr.next;
                curr.next = null; // 切断 h1 和 h2
                curr = h2;
                if (curr != null) {
                    for (int i = 1; i < subLen && curr.next != null; i++) {
                        curr = curr.next;
                    }
                }

                ListNode nextGroup = null;
                if (curr != null) {
                    nextGroup = curr.next;
                    curr.next = null; // 切断 h2 和后续链表
                }

                // 合并 h1 和 h2
                ListNode merged = merge(h1, h2);
                prev.next = merged;

                // 移动 prev 到合并后链表的末尾
                while (prev.next != null) {
                    prev = prev.next;
                }

                // curr 指向下一组的开头
                curr = nextGroup;
            }
        }
        return dummyHead.next;
    }

    // 合并两个有序链表的辅助函数
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
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
        tail.next = (l1 != null) ? l1 : l2;
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
        ListNode head1 = createLinkedList(new int[]{4, 2, 1, 3});
        ListNode result1 = solution.sortList(head1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [4,2,1,3]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [1, 2, 3, 4]

        // 示例 2
        ListNode head2 = createLinkedList(new int[]{-1, 5, 3, 4, 0});
        ListNode result2 = solution.sortList(head2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [-1,5,3,4,0]");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 [-1, 0, 3, 4, 5]

        // 示例 3
        ListNode head3 = createLinkedList(new int[]{});
        ListNode result3 = solution.sortList(head3);
        System.out.println("\n示例 3:");
        System.out.println("输入: head = []");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 []
    }
}
