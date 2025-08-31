package com.leetcode.code_08.p_124_maxPathSum;

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

    // 使用一个全局变量（或实例变量）来存储和更新遍历过程中遇到的最大路径和。
    // 初始化为最小值，以处理所有节点值都为负数的情况。
    private int maxSum = Integer.MIN_VALUE;

    /**
     * 深度优先搜索 (DFS) / 递归解法
     *
     * 算法思路：
     * 这个问题需要我们找到任意两个节点之间的路径，使其和最大。这个路径可能穿过某个节点，也可能完全位于其子树中。
     * 关键在于，对于任何一个节点 `node`，我们需要区分两个概念：
     * 1. **“贡献值” (Gain)**: 从 `node` 出发，向下延伸到其子树中的一条单边路径的最大和。
     *    这个值是 `node.val + max(leftGain, rightGain)`。这个“贡献值”是递归函数需要向上返回的，
     *    因为它能被父节点用来构建更长的路径。如果这个贡献值为负，我们应该舍弃它，返回 0，因为走这条路会“亏本”。
     * 2. **“路径和” (Path Sum)**: 以 `node` 为“拐点”的路径的最大和。
     *    这个值是 `node.val + leftGain + rightGain`。这个“路径和”不能向上返回，因为它已经形成了一个完整的“拱形”路径，
     *    不能再被父节点连接。但我们需要用它来更新全局的 `maxSum`。
     *
     * **递归函数 `maxGain(node)`**:
     * - **功能**: 计算从 `node` 出发的单边最大贡献值。
     * - **终止条件**: 如果 `node` 为 `null`，它不能提供任何贡献，返回 0。
     * - **递归步骤**:
     *   a. 递归计算左子树的最大贡献值 `leftGain` 和右子树的最大贡献值 `rightGain`。
     *      重要：如果子树的贡献值为负，我们取 0，表示不走这条路。`Math.max(maxGain(node.left), 0)`。
     *   b. **更新全局最大和**: 计算以当前 `node` 为拐点的路径和 `node.val + leftGain + rightGain`，
     *      并用它来尝试更新 `maxSum`。
     *   c. **返回单边贡献值**: 向上一层返回当前节点能提供的最大单边贡献值，即 `node.val + Math.max(leftGain, rightGain)`。
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        // 终止条件
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的“贡献值”
        // 如果子树的贡献是负数，则不选择该子树，贡献为 0
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 计算以当前节点为“拐点”的路径和，并更新全局最大值
        int newPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathSum);

        // 返回当前节点能为父节点提供的“单边”最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result1 = solution.maxPathSum(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,2,3]");
        System.out.println("输出: " + result1); // 应输出 6

        // 示例 2
        // 需要重置实例变量
        solution = new Solution();
        TreeNode root2 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result2 = solution.maxPathSum(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [-10,9,20,null,null,15,7]");
        System.out.println("输出: " + result2); // 应输出 42
    }
}
