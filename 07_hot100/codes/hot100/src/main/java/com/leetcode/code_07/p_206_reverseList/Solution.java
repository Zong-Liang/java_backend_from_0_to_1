package com.leetcode.code_07.p_206_reverseList;

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

    // ================= 方法一: 迭代解法 =================
    /**
     * 算法思路：
     * 我们可以通过遍历链表，逐个地将节点的 `next` 指针指向其前一个节点，从而实现反转。
     *
     * 1. **需要指针**:
     *    - `prev`: 指向当前节点的前一个节点。初始时为 `null`，因为它将成为反转后链表的尾节点。
     *    - `curr`: 指向当前正在处理的节点。初始时为 `head`。
     *
     * 2. **遍历与反转**:
     *    - 当 `curr` 不为 `null` 时，循环继续。
     *    - 在循环的每一步：
     *      a. **保存下一个节点**: `ListNode nextTemp = curr.next;`
     *         (必须先保存，因为下一步 `curr.next` 会被修改)。
     *      b. **反转指针**: `curr.next = prev;` (将当前节点的 `next` 指向前一个节点)。
     *      c. **移动指针**: 将 `prev` 和 `curr` 都向前移动一步。
     *         `prev = curr;`
     *         `curr = nextTemp;`
     *
     * 3. **返回结果**:
     *    - 循环结束后，`curr` 会变为 `null`，而 `prev` 会指向原链表的最后一个节点，
     *      即新链表的头节点。返回 `prev` 即可。
     */
    public ListNode reverseList(ListNode head) {
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


    // ================= 方法二: 递归解法 (进阶) =================
    /**
     * 算法思路：
     * 递归的本质是将大问题分解为规模更小的相同子问题。
     * 假设我们有一个函数 `reverseList(head)`，它的功能是反转以 `head` 为头的链表，并返回反转后的新头节点。
     *
     * 1. **递归的终止条件 (Base Case)**:
     *    - 如果 `head` 为 `null` 或者 `head.next` 为 `null`，说明链表为空或只有一个节点，
     *      无需反转，直接返回 `head`。
     *
     * 2. **递归的分解**:
     *    - 我们假设从 `head.next` 开始的剩余部分已经被成功反转了。
     *    - 我们调用 `reversedHead = reverseList(head.next)`。
     *    - `reversedHead` 就是反转后整个链表的新头节点（即原链表的最后一个节点）。
     *
     * 3. **处理当前层**:
     *    - 此时，`head` 仍然指向原来的下一个节点 `head.next`，而 `head.next` 经过反转后，
     *      它的 `next` 指针现在指向 `null`。
     *    - 我们需要做的是：
     *      a. `head.next.next = head;` (让原来的下一个节点指向当前节点)。
     *      b. `head.next = null;` (断开当前节点与原来下一个节点的连接，避免形成环)。
     *
     * 4. **返回结果**:
     *    - 返回 `reversedHead`，因为它始终是新链表的头。
     */
    public ListNode reverseListRecursive(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转 head 之后的链表
        ListNode reversedHead = reverseListRecursive(head.next);

        // 将当前节点连接到反转后的链表末尾
        head.next.next = head;
        head.next = null;

        // 返回新的头节点
        return reversedHead;
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
        ListNode result1 = solution.reverseList(head1); // 使用迭代法
        System.out.println("示例 1 (迭代):");
        System.out.println("输入: head = [1,2,3,4,5]");
        System.out.println("输出: " + printLinkedList(result1)); // 应输出 [5, 4, 3, 2, 1]

        ListNode head1_rec = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result1_rec = solution.reverseListRecursive(head1_rec); // 使用递归法
        System.out.println("示例 1 (递归):");
        System.out.println("输入: head = [1,2,3,4,5]");
        System.out.println("输出: " + printLinkedList(result1_rec)); // 应输出 [5, 4, 3, 2, 1]
    }
}
