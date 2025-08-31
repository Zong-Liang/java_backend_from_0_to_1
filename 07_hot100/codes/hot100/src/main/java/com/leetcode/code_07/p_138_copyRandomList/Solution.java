package com.leetcode.code_07.p_138_copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 提供的带 random 指针的链表节点定义。
 * 在实际 LeetCode 环境中无需自己定义。
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Solution {

    /**
     * 哈希表解法
     *
     * 算法思路：
     * 复制这个链表的难点在于如何处理 `random` 指针。`random` 指针可以指向链表中的任何节点，
     * 当我们复制一个节点时，它 `random` 指针所指向的节点可能还没有被创建。
     *
     * 我们可以使用一个哈希表来解决这个问题。哈希表用于存储“原节点”到“新创建的对应节点”的映射。
     * 整个过程分为两步：
     *
     * 1. **第一遍遍历：复制节点值**
     *    - 遍历原始链表。
     *    - 对于每一个原节点 `curr`，创建一个新的节点 `newNode`，其 `val` 与 `curr.val` 相同。
     *    - 将这个映射关系 `(curr, newNode)` 存入哈希表中。
     *
     * 2. **第二遍遍历：复制 `next` 和 `random` 指针**
     *    - 再次遍历原始链表。
     *    - 对于每一个原节点 `curr`：
     *      a. 从哈希表中获取其对应的新节点 `newNode = map.get(curr)`。
     *      b. 设置 `newNode` 的 `next` 指针：`newNode.next = map.get(curr.next)`。
     *      c. 设置 `newNode` 的 `random` 指针：`newNode.random = map.get(curr.random)`。
     *    - 哈希表的 `get` 方法在键为 `null` 时会返回 `null`，这恰好能正确处理 `next` 或 `random` 指针为空的情况。
     *
     * 3. **返回结果**:
     *    - 返回原始头节点 `head` 在哈希表中对应的新节点 `map.get(head)`。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Key: 原节点, Value: 对应的克隆节点
        Map<Node, Node> map = new HashMap<>();

        // 第一遍：复制所有节点的值，并建立映射
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 第二遍：连接 next 和 random 指针
        curr = head;
        while (curr != null) {
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // 测试代码 (由于 random 指针复杂，这里只做简单演示)
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 构造示例 1 的链表
        // head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);

        n7.next = n13;
        n13.next = n11;
        n11.next = n10;
        n10.next = n1;

        n7.random = null;
        n13.random = n7;
        n11.random = n1;
        n10.random = n11;
        n1.random = n7;

        System.out.println("示例 1:");
        System.out.println("输入: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]");

        Node copiedHead = solution.copyRandomList(n7);

        // 验证复制结果
        System.out.print("输出: [");
        Node curr = copiedHead;
        Node orig_curr = n7;
        while (curr != null) {
            System.out.print("[" + curr.val + ",");
            if (curr.random != null) {
                // 验证 random 指针是否也指向了克隆链表中的正确节点
                // 这是一个简化的验证，实际应比较索引或内存地址
                if (curr.random.val == orig_curr.random.val) {
                    System.out.print(" correct_random");
                } else {
                    System.out.print(" wrong_random");
                }
            } else {
                System.out.print("null");
            }
            System.out.print("]");
            curr = curr.next;
            orig_curr = orig_curr.next;
        }
        System.out.println("]");
    }
}
