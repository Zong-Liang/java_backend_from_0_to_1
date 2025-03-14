# [234_回文链表](https://leetcode.cn/problems/palindrome-linked-list/)

难度：简单

## 问题描述：

给你一个单链表的头节点 `head` ，请你判断该链表是否为回文链表。如果是，返回 `true` ；否则，返回 `false` 。

**示例 1：**

![img](../../assets/imgs/pal1linked-list.jpg)

```
输入：head = [1,2,2,1]
输出：true
```

**示例 2：**

![img](../../assets/imgs/pal2linked-list.jpg)

```java
输入：head = [1,2]
输出：false
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
public class Solution {
    /**
     * 判断链表是否为回文链表
     * @param head 链表头节点
     * @return 如果是回文链表返回true，否则返回false
     */
    public boolean isPalindrome(ListNode head) {
        // 如果链表为空或只有一个节点，则为回文链表
        if (head == null || head.next == null) {
            return true;
        }
        
        // 1. 使用快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;      // 慢指针每次移动一步
            fast = fast.next.next; // 快指针每次移动两步
        }
        
        // 如果链表长度为奇数，slow指向中间节点，需要再前进一步
        if (fast != null) {
            slow = slow.next;
        }
        
        // 2. 反转后半部分链表
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        
        // 3. 比较前半部分和反转后的后半部分是否相同
        boolean isPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // 4. 恢复链表结构（可选）
        // reverseList(slow);
        
        return isPalindrome;
    }
    
    /**
     * 反转链表
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    private ListNode reverseList(ListNode head) {
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
}
```

