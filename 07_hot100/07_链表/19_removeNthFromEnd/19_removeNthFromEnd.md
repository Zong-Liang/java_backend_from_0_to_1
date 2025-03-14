# [19_删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

难度：中等

## 问题描述：

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

**示例 1：**

![img](../../assets/imgs/remove_ex1.jpg)

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

**示例 2：**

```
输入：head = [1], n = 1
输出：[]
```

**示例 3：**

```
输入：head = [1,2], n = 1
输出：[1]
```

**进阶：**你能尝试使用一趟扫描实现吗？

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头节点，指向链表头部
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 创建快慢两个指针，初始都指向虚拟头节点
        ListNode first = dummy;
        ListNode second = dummy;
        
        // 先让快指针前进 n+1 步
        for (int i = 0; i <= n; i++) {
            first = first.next;
            // 注意这里处理的是 n+1 步，而不是 n 步
            // 这样当 first 为 null 时，second 就指向了待删除节点的前一个节点
        }
        
        // 同时移动两个指针，直到快指针到达链表末尾
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // 此时 second 指向待删除节点的前一个节点
        // 执行删除操作
        second.next = second.next.next;
        
        // 返回链表头节点
        return dummy.next;
    }
}
```

