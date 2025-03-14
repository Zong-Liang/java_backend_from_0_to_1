# [141_环形链表](https://leetcode.cn/problems/linked-list-cycle/)

难度：简单

## 问题描述：

给你一个链表的头节点 `head` ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。**注意：`pos` 不作为参数进行传递** 。仅仅是为了标识链表的实际情况。

*如果链表中存在环* ，则返回 `true` 。 否则，返回 `false` 。

**示例 1：**

![img](../../assets/imgs/circularlinkedlist1.png)

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例 2：**

![img](../../assets/imgs/circularlinkedlist_test22.png)

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例 3：**

![img](../../assets/imgs/circularlinkedlist_test33.png)

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```





**进阶：**你能用 $O(1)$（即，常量）内存解决此问题吗？

## 解题思路：



## Java代码：

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 如果链表为空或只有一个节点，则不可能有环
        if (head == null || head.next == null) {
            return false;
        }
        
        // 初始化快慢指针
        ListNode slow = head;
        ListNode fast = head;
        
        // 快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 慢指针走一步
            fast = fast.next.next;     // 快指针走两步
            
            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        
        // 如果快指针到达了链表末尾，说明没有环
        return false;
    }
}
```

