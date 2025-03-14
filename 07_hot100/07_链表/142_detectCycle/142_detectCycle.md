# [142_环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/)

难度：中等

## 问题描述：

给定一个链表的头节点  `head` ，返回链表开始入环的第一个节点。 *如果链表无环，则返回 `null`。*

如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 `pos` 来表示链表尾连接到链表中的位置（**索引从 0 开始**）。如果 `pos` 是 `-1`，则在该链表中没有环。**注意：`pos` 不作为参数进行传递**，仅仅是为了标识链表的实际情况。

**不允许修改** 链表。

**示例 1：**

![img](../../assets/imgs/circularlinkedlist.png)

```java
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例 2：**

![img](../../assets/imgs/circularlinkedlist_test2.png)

```
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例 3：**

![img](../../assets/imgs/circularlinkedlist_test3.png)

```java
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
```









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
    public ListNode detectCycle(ListNode head) {
        // 如果链表为空或只有一个节点，则不可能有环
        if (head == null || head.next == null) {
            return null;
        }
        
        // 初始化快慢指针
        ListNode slow = head;
        ListNode fast = head;
        
        // 第一阶段：检测是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 慢指针每次走一步
            fast = fast.next.next;     // 快指针每次走两步
            
            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                // 第二阶段：找到环的入口
                // 将其中一个指针重置到链表头
                slow = head;
                
                // 两个指针以相同速度移动，直到再次相遇
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // 相遇点即为环的入口
                return slow;
            }
        }
        
        // 如果快指针到达了链表末尾，说明没有环
        return null;
    }
}
```

