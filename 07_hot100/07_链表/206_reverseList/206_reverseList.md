# [206_反转链表](https://leetcode.cn/problems/reverse-linked-list/)

难度：简单

## 问题描述：

给你单链表的头节点 `head` ，请你反转链表，并返回反转后的链表。

**示例 1：**

![img](../../assets/imgs/rev1ex1.jpg)

```java
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
```

**示例 2：**

![img](../../assets/imgs/rev1ex2.jpg)

```java
输入：head = [1,2]
输出：[2,1]
```

**示例 3：**

```java
输入：head = []
输出：[]
```





## 解题思路：

## Java代码：

```java
// 定义链表节点
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {
    
    // 方法一：迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            // 保存下一个节点，防止链接断开后无法继续遍历
            ListNode next = curr.next;
            // 反转当前节点的指针
            curr.next = prev;
            // 更新prev和curr，移动到下一个位置
            prev = curr;
            curr = next;
        }
        
        // 返回新的头节点
        return prev;
    }
    
    // 方法二：递归法
    public ListNode reverseListRecursive(ListNode head) {
        // 基本情况：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        
        // 递归反转子链表，获得新的头节点
        ListNode newHead = reverseListRecursive(head.next);
        
        // 处理当前节点: head.next的下一个应该指向head
        head.next.next = head;
        // 防止循环引用
        head.next = null;
        
        // 返回新的头节点
        return newHead;
    }
    
    // 辅助方法：创建链表
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    // 辅助方法：打印链表
    public static void printLinkedList(ListNode head) {
        System.out.print("[");
        
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        
        System.out.println("]");
    }
    
    // 测试代码
    public static void main(String[] args) {
        // 测试用例1: [1,2,3,4,5]
        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = createLinkedList(values1);
        System.out.print("原链表: ");
        printLinkedList(head1);
        
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // 使用迭代法
        ListNode reversed1 = solution.reverseList(head1);
        System.out.print("迭代法反转后: ");
        printLinkedList(reversed1);
        
        // 测试用例2: [1,2]
        int[] values2 = {1, 2};
        ListNode head2 = createLinkedList(values2);
        System.out.print("原链表: ");
        printLinkedList(head2);
        
        // 使用递归法
        ListNode reversed2 = solution.reverseListRecursive(head2);
        System.out.print("递归法反转后: ");
        printLinkedList(reversed2);
        
        // 测试用例3: []
        ListNode head3 = null;
        System.out.print("原链表: ");
        printLinkedList(head3);
        
        // 使用迭代法
        ListNode reversed3 = solution.reverseList(head3);
        System.out.print("迭代法反转后: ");
        printLinkedList(reversed3);
    }
}
```

