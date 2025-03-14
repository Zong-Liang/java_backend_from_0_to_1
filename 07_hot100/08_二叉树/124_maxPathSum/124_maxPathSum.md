# [124_二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)

难度：困难

## 问题描述：

二叉树中的 **路径** 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 **至多出现一次** 。该路径 **至少包含一个** 节点，且不一定经过根节点。

**路径和** 是路径中各节点值的总和。

给你一个二叉树的根节点 `root` ，返回其 **最大路径和** 。

**示例 1：**

![img](../../assets/imgs/exx1.jpg)

```java
输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
```

**示例 2：**

![img](../../assets/imgs/exx2.jpg)

```java
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
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
    private int maxSum = Integer.MIN_VALUE; // 初始化为最小整数值
    
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxSum;
    }
    
    // 计算从当前节点出发向下的最大路径和
    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // 计算左右子树的最大路径和，如果为负数则取0（相当于不选这条路径）
        int leftMax = Math.max(0, maxPathDown(node.left));
        int rightMax = Math.max(0, maxPathDown(node.right));
        
        // 更新全局最大路径和（经过当前节点的最大路径和）
        maxSum = Math.max(maxSum, leftMax + node.val + rightMax);
        
        // 返回从当前节点出发向下的最大路径和（只能选择左子树或右子树中的一条路径）
        return Math.max(leftMax, rightMax) + node.val;
    }
}
```

