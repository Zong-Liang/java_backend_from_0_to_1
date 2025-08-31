package com.leetcode.code_07.p_160_getIntersectionNode;

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
     * 双指针解法
     *
     * 算法思路：
     * 我们可以设置两个指针 `pA` 和 `pB`，分别从两个链表的头节点 `headA` 和 `headB` 开始遍历。
     * 核心的技巧是，当一个指针到达链表的末尾时，我们让它跳转到另一个链表的头节点继续遍历。
     *
     * 1. **路径长度对齐**:
     *    - 假设链表 A 在相交点前的长度为 `a`，链表 B 在相交点前的长度为 `b`，相交后的公共部分长度为 `c`。
     *    - 指针 `pA` 走过的路径是 `A -> B`，总长度为 `a + c + b`。
     *    - 指针 `pB` 走过的路径是 `B -> A`，总长度为 `b + c + a`。
     *    - 可以看到，两条路径的长度是完全相等的。
     *
     * 2. **相遇点**:
     *    - 由于两个指针走过的总路程相同，并且速度也相同（每次一步），那么如果存在相交点，
     *      它们必然会在相交点相遇。
     *    - 如果两个链表不相交，那么 `pA` 走完 `A -> B` 后会变为 `null`，同时 `pB` 走完 `B -> A` 后也会变为 `null`。
     *      它们会在 `null` 这个点“相遇”，此时循环终止，函数返回 `null`，符合题意。
     *
     * 3. **算法流程**:
     *    a. 初始化 `pA = headA`, `pB = headB`。
     *    b. 进入一个循环，当 `pA != pB` 时继续。
     *    c. 在循环内部：
     *       - 移动 `pA`：如果 `pA` 不为空，则 `pA = pA.next`；否则，`pA = headB`。
     *       - 移动 `pB`：如果 `pB` 不为空，则 `pB = pB.next`；否则，`pB = headA`。
     *    d. 当循环结束时（`pA == pB`），`pA`（或 `pB`）就是相交节点或 `null`。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // 当 pA == pB 时，循环结束，找到了交点或都到达了末尾(null)
        while (pA != pB) {
            // 如果 pA 到达末尾，则切换到 headB
            pA = (pA == null) ? headB : pA.next;
            // 如果 pB 到达末尾，则切换到 headA
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        ListNode headA1 = new ListNode(4);
        headA1.next = new ListNode(1);
        headA1.next.next = commonNode;

        ListNode headB1 = new ListNode(5);
        headB1.next = new ListNode(6);
        headB1.next.next = new ListNode(1);
        headB1.next.next.next = commonNode;

        ListNode result1 = solution.getIntersectionNode(headA1, headB1);
        System.out.println("示例 1:");
        System.out.println("输出: " + (result1 != null ? "Intersected at '" + result1.val + "'" : "No intersection")); // 应输出 8

        // 示例 2: 不相交
        ListNode headA2 = new ListNode(2);
        headA2.next = new ListNode(6);
        headA2.next.next = new ListNode(4);

        ListNode headB2 = new ListNode(1);
        headB2.next = new ListNode(5);

        ListNode result2 = solution.getIntersectionNode(headA2, headB2);
        System.out.println("\n示例 2 (自定义不相交):");
        System.out.println("输出: " + (result2 != null ? "Intersected at '" + result2.val + "'" : "No intersection")); // 应输出 No intersection
    }
}
