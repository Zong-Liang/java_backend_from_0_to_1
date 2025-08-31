package com.leetcode.code_08.p_437_pathSum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 提供的二叉树节点定义。
 * 在实际 LeetCode 环境中无需自己定义。
 */
class TreeNode {
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

public class Solution {

    /**
     * 前缀和 + 深度优先搜索 (DFS) 解法
     *
     * 算法思路：
     * 这个问题要求我们找出所有和为 `targetSum` 的路径，路径可以从任意节点开始，到其任意子孙节点结束。
     * 暴力解法是为每个节点都进行一次 DFS 来查找以它为起点的路径，时间复杂度会很高。
     *
     * 一个更优化的方法是使用“前缀和”。前缀和是指从根节点到当前节点的路径上所有节点值的总和。
     * 假设我们当前在节点 `curr`，其前缀和为 `currentSum`。我们想知道是否存在一个祖先节点 `ancestor`，
     * 使得从 `ancestor` (不含) 到 `curr` (含) 的路径和等于 `targetSum`。
     * 这等价于：`currentSum - prefixSum(ancestor) = targetSum`
     * 变形后得到：`prefixSum(ancestor) = currentSum - targetSum`
     *
     * 这启发我们使用一个哈希表 `prefixSumCount` 来存储在当前路径上，每个前缀和出现的次数。
     *
     * 1. **定义递归函数 `dfs(node, currentSum)`**:
     *    - `node`: 当前遍历到的节点。
     *    - `currentSum`: 从根节点到当前节点的路径和。
     *    - `prefixSumCount`: 哈希表，`key` 是前缀和，`value` 是该前缀和在当前路径上出现的次数。
     *
     * 2. **递归逻辑**:
     *    a. **终止条件**: 如果 `node` 为 `null`，返回 0。
     *    b. **计算当前路径和**: `currentSum += node.val`。
     *    c. **查找并更新结果**:
     *       - 查找哈希表中是否存在 `key = currentSum - targetSum`。如果存在，说明找到了若干条以当前节点为终点的有效路径，
     *         其数量就是 `prefixSumCount.get(currentSum - targetSum)`。
     *       - 将这个数量累加到最终结果 `count` 中。
     *    d. **更新哈希表 (进入下一层前)**:
     *       - 将 `currentSum` 存入哈希表，使其出现次数加 1。
     *    e. **递归探索**:
     *       - 递归调用 `dfs` 探索左子树和右子树。
     *    f. **回溯 (离开当前节点后)**:
     *       - 当左右子树的探索都结束后，必须将 `currentSum` 从哈希表中移除（出现次数减 1）。
     *         这是回溯的关键，确保了哈希表只记录当前路径上的前缀和，避免影响到兄弟节点的计算。
     *
     * 3. **初始调用**:
     *    - 初始化哈希表，放入 `prefixSumCount.put(0L, 1)`。这表示和为 0 的前缀（即在根节点开始之前）出现了一次。
     *      这个初始值是为了处理那些从根节点开始就满足条件的路径。
     */
    private int target;
    private int count = 0;
    // 使用 Long 避免整数溢出
    private Map<Long, Integer> prefixSumCount;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.prefixSumCount = new HashMap<>();
        // 关键：初始化前缀和为0的路径有一条（空路径）
        prefixSumCount.put(0L, 1);
        dfs(root, 0L);
        return count;
    }

    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }

        // 计算到当前节点的前缀和
        currentSum += node.val;

        // 查找是否存在 `currentSum - target` 的前缀和
        count += prefixSumCount.getOrDefault(currentSum - target, 0);

        // 更新当前前缀和的计数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // 递归进入子树
        dfs(node.left, currentSum);
        dfs(node.right, currentSum);

        // 回溯：离开当前节点，恢复哈希表状态
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }

    // 测试代码
    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        int targetSum1 = 8;
        Solution solution1 = new Solution();
        int result1 = solution1.pathSum(root1, targetSum1);
        System.out.println("示例 1:");
        System.out.println("输入: targetSum = " + targetSum1);
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int targetSum2 = 22;
        Solution solution2 = new Solution();
        int result2 = solution2.pathSum(root2, targetSum2);
        System.out.println("\n示例 2:");
        System.out.println("输入: targetSum = " + targetSum2);
        System.out.println("输出: " + result2); // 应输出 3
    }
}
