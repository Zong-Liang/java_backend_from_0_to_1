package com.leetcode.code_07.p_142_detectCycle;

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
     * 快慢指针解法 (Floyd 判环算法的扩展)
     *
     * 算法思路：
     * 这个问题分为两步：
     * 1. 判断链表是否有环。
     * 2. 如果有环，找到环的入口节点。
     *
     * **第一步：判断是否有环**
     * - 我们使用标准的快慢指针法。`slow` 指针每次走一步，`fast` 指针每次走两步。
     * - 如果 `fast` 指针能够追上 `slow` 指针（即 `fast == slow`），则链表有环。
     * - 如果 `fast` 指针到达链表末尾（`fast == null` 或 `fast.next == null`），则链表无环。
     *
     * **第二步：找到环的入口**
     * - 这是一个有数学证明的巧妙技巧。当 `fast` 和 `slow` 第一次相遇时，我们可以证明：
     *   `从头节点(head)到环入口的距离` == `从相遇点到环入口的距离`
     * - **证明简述**:
     *   设头节点到环入口的距离为 a，环的长度为 b。
     *   当 slow 和 fast 相遇时，slow 走了 `a + k` 步，fast 走了 `a + k + n*b` 步 (fast 比 slow 多走了 n 圈)。
     *   又因为 fast 速度是 slow 的两倍，所以 `2 * (a + k) = a + k + n*b`。
     *   化简得到 `a + k = n*b`，进一步得到 `a = n*b - k`。
     *   这个公式的含义是：从头节点走 `a` 步可以到达环入口。从相遇点走 `n*b - k` 步，也恰好能回到环入口。
     * - **算法实现**:
     *   a. 当快慢指针相遇后，我们将其中一个指针（例如 `slow`）重新指向头节点 `head`。
     *   b. 另一个指针 `fast` 保持在相遇点不动。
     *   c. 然后，两个指针都以相同的速度（每次一步）向前移动。
     *   d. 它们下一次相遇的节点，就是环的入口节点。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // 第一步：判断是否有环，并找到相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 如果没有环，直接返回 null
        if (!hasCycle) {
            return null;
        }

        // 第二步：找到环的入口
        // 将一个指针重置回头节点
        slow = head;
        // 两个指针以相同速度前进，相遇点即为环入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        ListNode node2_1 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);
        head1.next = node2_1;
        node2_1.next = node0;
        node0.next = node_4;
        node_4.next = node2_1; // 环入口是 node2_1
        ListNode result1 = solution.detectCycle(head1);
        System.out.println("示例 1:");
        System.out.println("输入: head = [3,2,0,-4], pos = 1");
        System.out.println("输出: " + (result1 != null ? "返回索引为 1 的链表节点 (值为 " + result1.val + ")" : "null")); // 应输出节点 2

        // 示例 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // 环入口是 head2
        ListNode result2 = solution.detectCycle(head2);
        System.out.println("\n示例 2:");
        System.out.println("输入: head = [1,2], pos = 0");
        System.out.println("输出: " + (result2 != null ? "返回索引为 0 的链表节点 (值为 " + result2.val + ")" : "null")); // 应输出节点 1

        // 示例 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);
        ListNode result3 = solution.detectCycle(head3);
        System.out.println("\n示例 3:");
        System.out.println("输入: head = [1], pos = -1");
        System.out.println("输出: " + (result3 != null ? "返回节点 " + result3.val : "null")); // 应输出 null
    }
}
