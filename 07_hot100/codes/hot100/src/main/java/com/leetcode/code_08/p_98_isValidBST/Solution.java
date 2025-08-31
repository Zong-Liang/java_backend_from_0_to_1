package com.leetcode.code_08.p_98_isValidBST;

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
     * 递归解法 (带范围限制)
     *
     * 算法思路：
     * 验证一个二叉树是否为二叉搜索树 (BST)，仅仅检查每个节点的左右子节点是不够的。
     * 例如，在 `[5, 1, 6, null, null, 3, 7]` 中，节点 6 的左子节点 3 小于 6，但 3 同时也小于根节点 5，这违反了 BST 的定义。
     *
     * 正确的方法是，对于树中的每一个节点，我们不仅要确保 `node.left.val < node.val` 和 `node.right.val > node.val`，
     * 还需要确保其整个左子树的所有节点值都小于 `node.val`，整个右子树的所有节点值都大于 `node.val`。
     *
     * 我们可以通过一个递归函数来实现这一点，该函数在递归时传递当前子树必须满足的数值范围 `(lower, upper)`。
     *
     * 1. **定义递归辅助函数 `validate(node, lower, upper)`**:
     *    - `node`: 当前正在验证的节点。
     *    - `lower`: 当前节点值必须大于的下界。
     *    - `upper`: 当前节点值必须小于的上界。
     *
     * 2. **递归逻辑**:
     *    a. **终止条件**: 如果 `node` 为 `null`，它是一个有效的 BST (空树也是 BST)，返回 `true`。
     *    b. **验证当前节点**: 检查 `node.val` 是否在 `(lower, upper)` 范围内。
     *       如果 `node.val <= lower` 或 `node.val >= upper`，则违反了 BST 的定义，返回 `false`。
     *    c. **递归验证子树**:
     *       - 对于左子树，其所有节点的值必须在 `(lower, node.val)` 范围内。递归调用 `validate(node.left, lower, node.val)`。
     *       - 对于右子树，其所有节点的值必须在 `(node.val, upper)` 范围内。递归调用 `validate(node.right, node.val, upper)`。
     *    d. 只有当当前节点、左子树和右子树都有效时，才返回 `true`。
     *
     * 3. **初始调用**:
     *    - 我们从根节点开始调用 `validate(root, null, null)`，初始的上下界是无限的（用 `null` 表示）。
     *      使用 `Long` 类型来处理边界值，避免 `Integer.MIN_VALUE` 和 `Integer.MAX_VALUE` 带来的问题。
     */
    public boolean isValidBST(TreeNode root) {
        // 初始调用，根节点的有效范围是 (负无穷, 正无穷)
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        // 空树是有效的 BST
        if (node == null) {
            return true;
        }

        // 检查当前节点的值是否在有效范围内
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }

        // 递归检查左子树和右子树，并更新范围
        // 左子树的值必须在 (lower, node.val) 之间
        // 右子树的值必须在 (node.val, upper) 之间
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [2,1,3]
        //   2
        //  / \
        // 1   3
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result1 = solution.isValidBST(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [2,1,3]");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2: root = [5,1,4,null,null,3,6]
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        boolean result2 = solution.isValidBST(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [5,1,4,null,null,3,6]");
        System.out.println("输出: " + result2); // 应输出 false
    }
}
