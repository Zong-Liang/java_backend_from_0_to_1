# [23_合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)

难度：困难

## 问题描述：

给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

**示例 1：**

```
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
```

**示例 2：**

```
输入：lists = []
输出：[]
```

**示例 3：**

```
输入：lists = [[]]
输出：[]
```

## 解题思路：



## Java代码：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // 创建优先队列（最小堆）
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 将所有链表的头节点加入队列
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        
        // 哑节点，简化操作
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 从队列中取出最小节点，添加到结果链表
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            
            // 如果取出的节点还有下一个节点，将其加入队列
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
```

