# [437_路径总和 III](https://leetcode.cn/problems/path-sum-iii/)

难度：中等

## 问题描述：

给定一个二叉树的根节点 `root` ，和一个整数 `targetSum` ，求该二叉树里节点值之和等于 `targetSum` 的 **路径** 的数目。

**路径** 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

**示例 1：**

![img](../../assets/imgs/pathsum3-1-tree.jpg)

```java
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
```

**示例 2：**

```java
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        // 以当前节点为起点的路径数量 + 左子树中的路径数量 + 右子树中的路径数量
        return pathSumFromNode(root, targetSum) + 
               pathSum(root.left, targetSum) + 
               pathSum(root.right, targetSum);
    }
    
    // 计算以node为起点，和为targetSum的路径数量
    private int pathSumFromNode(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        // 如果当前节点值等于目标值，找到一条路径
        if (node.val == targetSum) {
            count++;
        }
        
        // 继续向下寻找路径
        count += pathSumFromNode(node.left, targetSum - node.val);
        count += pathSumFromNode(node.right, targetSum - node.val);
        
        return count;
    }
}
```

```java
import java.util.HashMap;
import java.util.Map;

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
    public int pathSum(TreeNode root, int targetSum) {
        // 哈希表：前缀和 -> 出现次数
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 初始化：前缀和为0的路径出现1次
        prefixSumCount.put(0L, 1);
        
        // 开始DFS
        return dfs(root, 0, targetSum, prefixSumCount);
    }
    
    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }
        
        // 更新当前路径上的前缀和
        currentSum += node.val;
        
        // 查找有多少条路径的和为targetSum
        // currentSum - targetSum 是我们要找的前缀和
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        // 更新前缀和的出现次数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // 继续遍历左右子树
        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // 回溯：恢复状态，移除当前节点的前缀和
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return count;
    }
}
```

