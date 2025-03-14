# [148_排序链表](https://leetcode.cn/problems/sort-list/)

难度：中等

## 问题描述：

给你链表的头结点 `head` ，请将其按 **升序** 排列并返回 **排序后的链表** 。

**示例 1：**

![img](../../assets/imgs/sort_list_1.jpg)

```
输入：head = [4,2,1,3]
输出：[1,2,3,4]
```

**示例 2：**

![img](../../assets/imgs/sort_list_2.jpg)

```
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
```

**示例 3：**

```
输入：head = []
输出：[]
```

**进阶：**你可以在 $O(n log n)$ 时间复杂度和常数级空间复杂度下，对链表进行排序吗？







## 解题思路：



## Java代码：

```java
/**
 * 链表节点定义
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    /**
     * 对链表进行排序
     * @param head 链表头节点
     * @return 排序后的链表头节点
     */
    public ListNode sortList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        
        // 找到链表的中点
        ListNode mid = findMiddle(head);
        
        // 断开链表，分成两半
        ListNode rightHead = mid.next;
        mid.next = null;
        
        // 分别对左右两半进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        
        // 合并两个排序好的子链表
        return merge(left, right);
    }
    
    /**
     * 找到链表的中点
     * 使用快慢指针法
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    /**
     * 合并两个已排序的链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        // 将剩余节点接上
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        
        return dummy.next;
    }
}
```

