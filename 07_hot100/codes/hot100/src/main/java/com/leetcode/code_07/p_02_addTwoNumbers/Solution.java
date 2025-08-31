package com.leetcode.code_07.p_02_addTwoNumbers;

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
     * 模拟加法解法
     *
     * 算法思路：
     * 这个问题模拟了我们手动进行加法计算的过程。由于两个数字的位数是逆序存储在链表中的，
     * 我们可以从两个链表的头部开始，同时遍历它们，将对应位置的数字相加，并处理好进位。
     *
     * 1. **初始化**:
     *    - 创建一个“哑节点”（dummy head）作为结果链表的头节点的前一个节点。这可以简化代码，避免对头节点的特殊处理。
     *    - 创建一个 `current` 指针，用于构建新的结果链表，初始时指向 `dummyHead`。
     *    - 初始化一个 `carry` (进位) 变量为 0。
     *
     * 2. **遍历与相加**:
     *    - 我们使用一个循环，只要两个输入链表 `l1` 或 `l2` 中任意一个还有节点，或者 `carry` 不为 0，就继续计算。
     *    - 在循环的每一步：
     *      a. 获取 `l1` 和 `l2` 当前节点的值。如果某个链表已经遍历完毕，就将其值视为 0。
     *      b. 计算当前位的总和：`sum = value1 + value2 + carry`。
     *      c. 更新进位：`carry = sum / 10`。
     *      d. 创建一个新节点，其值为当前位的数字 `sum % 10`。
     *      e. 将新节点连接到结果链表的末尾，并移动 `current` 指针。
     *      f. 将 `l1` 和 `l2` 的指针移向下一个节点（如果存在）。
     *
     * 3. **返回结果**:
     *    - 循环结束后，`dummyHead.next` 就是我们构建好的结果链表的头节点。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null || carry != 0) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
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
        ListNode l1_1 = createLinkedList(new int[]{2, 4, 3});
        ListNode l2_1 = createLinkedList(new int[]{5, 6, 4});
        ListNode result1 = solution.addTwoNumbers(l1_1, l2_1);
        System.out.println("示例 1:");
        System.out.println("输入: l1 = [2,4,3], l2 = [5,6,4]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [7, 0, 8]

        // 示例 2
        ListNode l1_2 = createLinkedList(new int[]{0});
        ListNode l2_2 = createLinkedList(new int[]{0});
        ListNode result2 = solution.addTwoNumbers(l1_2, l2_2);
        System.out.println("\n示例 2:");
        System.out.println("输入: l1 = [0], l2 = [0]");
        System.out.println("输出: " + printLinkedList(result2)); // 应输出 [0]

        // 示例 3
        ListNode l1_3 = createLinkedList(new int[]{9,9,9,9,9,9,9});
        ListNode l2_3 = createLinkedList(new int[]{9,9,9,9});
        ListNode result3 = solution.addTwoNumbers(l1_3, l2_3);
        System.out.println("\n示例 3:");
        System.out.println("输入: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]");
        System.out.println("输出: " + printLinkedList(result3)); // 应输出 [8, 9, 9, 9, 0, 0, 0, 1]
    }
}
