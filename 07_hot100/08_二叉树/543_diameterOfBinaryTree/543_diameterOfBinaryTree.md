# [543_二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/)

难度：简单

## 问题描述：

给你一棵二叉树的根节点，返回该树的 **直径** 。

二叉树的 **直径** 是指树中任意两个节点之间最长路径的 **长度** 。这条路径可能经过也可能不经过根节点 `root` 。

两节点之间路径的 **长度** 由它们之间边数表示。

**示例 1：**

![img](../../assets/imgs/diamtree.jpg)

```java
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
```

**示例 2：**

```java
输入：root = [1,2]
输出：1
```

## 解题思路：



## Java代码：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // 计算树的最大深度，同时更新最大直径
        maxDepth(root);
        
        return maxDiameter;
    }
    
    /**
     * 计算以node为根的子树的最大深度
     * 同时更新经过node的最长路径
     */
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // 计算左右子树的最大深度
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        // 更新最大直径：经过当前节点的最长路径
        // 左子树深度 + 右子树深度 = 经过该节点的路径边数
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        // 返回以当前节点为根的子树的最大深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```

