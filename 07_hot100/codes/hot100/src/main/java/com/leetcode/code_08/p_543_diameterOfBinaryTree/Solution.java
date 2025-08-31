package com.leetcode.code_08.p_543_diameterOfBinaryTree;

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

    // 使用一个实例变量来存储和更新遍历过程中遇到的最大直径。
    private int maxDiameter;

    /**
     * 深度优先搜索 (DFS) / 递归解法
     *
     * 算法思路：
     * 二叉树的直径是任意两个节点之间最长路径的长度。这条最长路径可能穿过根节点，也可能完全包含在某个子树中。
     *
     * 核心思想是，对于任何一个节点 `node`，穿过它的最长路径长度等于其左子树的深度加上其右子树的深度。
     * 因此，全局的直径就是所有节点上这个“穿过路径”长度的最大值。
     *
     * 我们可以设计一个递归函数，它在计算子树深度的同时，顺便更新全局的最大直径。
     *
     * 1. **定义递归辅助函数 `depth(node)`**:
     *    - **功能**: 这个函数有两个职责：
     *      a. **返回值**: 计算并返回以 `node` 为根的子树的深度（即从 `node` 到其最远叶子节点的边数）。
     *      b. **副作用**: 在计算深度的过程中，计算穿过 `node` 的路径长度（`左深度 + 右深度`），并用它来更新全局变量 `maxDiameter`。
     *
     * 2. **递归逻辑 (后序遍历)**:
     *    a. **终止条件 (Base Case)**: 如果 `node` 为 `null`，它是一个空树，其深度为 -1（因为我们计算的是边数，一个单节点深度为0）。为了方便计算，我们也可以定义空树深度为0，然后在计算时调整。这里我们采用更常见的定义：返回从该节点向下的最长边数。
     *    b. **递归分解**:
     *       - 递归调用 `depth(node.left)` 得到左子树的最大深度 `leftDepth`。
     *       - 递归调用 `depth(node.right)` 得到右子树的最大深度 `rightDepth`。
     *    c. **更新全局直径**:
     *       - 穿过当前节点 `node` 的路径长度为 `leftDepth + rightDepth`。
     *       - 更新 `maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth)`。
     *    d. **返回深度**:
     *       - 以 `node` 为根的子树的深度是其左右子树深度的较大值加 1。返回 `Math.max(leftDepth, rightDepth) + 1`。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树的深度
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // 更新最大直径：穿过当前节点的路径长度 = 左深度 + 右深度
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 返回当前树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        int result1 = solution.diameterOfBinaryTree(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,2,3,4,5]");
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        solution = new Solution(); // 重置实例变量
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        int result2 = solution.diameterOfBinaryTree(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [1,2]");
        System.out.println("输出: " + result2); // 应输出 1
    }
}
