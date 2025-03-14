# [114_二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/)

难度：中等

## 问题描述：

给你二叉树的根结点 `root` ，请你将它展开为一个单链表：

- 展开后的单链表应该同样使用 `TreeNode` ，其中 `right` 子指针指向链表中下一个结点，而左子指针始终为 `null` 。
- 展开后的单链表应该与二叉树 [**先序遍历**](https://baike.baidu.com/item/先序遍历/6442839?fr=aladdin) 顺序相同。

**示例 1：**

![img](../../assets/imgs/flaten.jpg)

```java
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
```

**示例 2：**

```java
输入：root = []
输出：[]
```

**示例 3：**

```java
输入：root = [0]
输出：[0]
```

**进阶：**你可以使用原地算法（$O(1)$ 额外空间）展开这棵树吗？

## 解题思路：



## Java代码：
