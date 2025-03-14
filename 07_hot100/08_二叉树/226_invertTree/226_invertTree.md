# [226_翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/)

难度：简单

## 问题描述：

给你一棵二叉树的根节点 `root` ，翻转这棵二叉树，并返回其根节点。

**示例 1：**

![img](../../assets/imgs/invert1-tree.jpg)

```
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```

**示例 2：**

![img](../../assets/imgs/invert2-tree.jpg)

```java
输入：root = [2,1,3]
输出：[2,3,1]
```

**示例 3：**

```java
输入：root = []
输出：[]
```



## 解题思路：



## Java代码：

```java
/**
 * 二叉树节点定义
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 翻转二叉树的解决方案
 */
class Solution {
    /**
     * 递归方法实现翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        // 基本情况：空树直接返回
        if (root == null) {
            return null;
        }
        
        // 递归翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // 交换左右子树
        root.left = right;
        root.right = left;
        
        // 返回翻转后的根节点
        return root;
    }
    
    /**
     * 迭代方法实现翻转二叉树（使用队列）
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // 使用队列进行层序遍历
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            // 交换当前节点的左右子节点
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            
            // 将非空的左右子节点加入队列
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        
        return root;
    }
}
```

