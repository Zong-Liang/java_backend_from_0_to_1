package com.leetcode.code_08.p_104_maxDepth;

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
     * 深度优先搜索 (DFS) / 递归解法
     *
     * 算法思路：
     * 这个问题可以很自然地用递归来解决。一棵二叉树的最大深度，等于其左子树和右子树中较大深度值，再加上根节点自身的深度 1。
     *
     * 1. **递归的终止条件 (Base Case)**:
     *    - 如果当前节点 `root` 为 `null`，说明已经到达了叶子节点的下一层，其深度为 0。
     *      这是递归的终点。
     *
     * 2. **递归的分解与合并**:
     *    - 如果当前节点不为 `null`，我们分别递归地计算其左子树的最大深度 `leftDepth` 和右子树的最大深度 `rightDepth`。
     *      - `leftDepth = maxDepth(root.left)`
     *      - `rightDepth = maxDepth(root.right)`
     *    - 当前树的最大深度就是 `max(leftDepth, rightDepth) + 1`。
     *      这里的 `+ 1` 是因为要计算当前根节点这一层。
     */
    public int maxDepth(TreeNode root) {
        // 终止条件：如果节点为空，深度为 0
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的深度
        int leftDepth = maxDepth(root.left);
        // 递归计算右子树的深度
        int rightDepth = maxDepth(root.right);

        // 返回左右子树深度的较大值 + 1 (当前节点)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [3,9,20,null,null,15,7]
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result1 = solution.maxDepth(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [3,9,20,null,null,15,7]");
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2: root = [1,null,2]
        //   1
        //    \
        //     2
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        int result2 = solution.maxDepth(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [1,null,2]");
        System.out.println("输出: " + result2); // 应输出 2
    }
}
