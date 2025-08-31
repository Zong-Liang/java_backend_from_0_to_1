package com.leetcode.code_08.p_236_lowestCommonAncestor;

/**
 * LeetCode 提供的二叉树节点定义。
 * 在实际 LeetCode 环境中无需自己定义。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    /**
     * 递归 (后序遍历) 解法
     *
     * 算法思路：
     * 这是一个经典的树的递归问题。我们可以定义一个递归函数，该函数在给定的树（或子树）中查找 p 和 q，并根据查找结果返回信息。
     *
     * 1. **递归函数的定义 `lowestCommonAncestor(root, p, q)`**:
     *    - **功能**: 在以 `root` 为根的树中查找 `p` 和 `q` 的最近公共祖先 (LCA)。
     *    - **返回值**:
     *      - 如果在 `root` 子树中能同时找到 `p` 和 `q`，则返回它们的 LCA。
     *      - 如果在 `root` 子树中只能找到 `p` 或 `q` 中的一个，则返回找到的那个节点。
     *      - 如果在 `root` 子树中 `p` 和 `q` 都找不到，则返回 `null`。
     *
     * 2. **递归逻辑 (后序遍历思想)**:
     *    a. **终止条件 (Base Case)**:
     *       - 如果 `root` 为 `null`，说明已经到达叶子节点的子节点，直接返回 `null`。
     *       - 如果 `root` 本身就是 `p` 或 `q`，根据定义，它就是其自身的祖先。
     *         由于我们是从上往下搜索，第一次遇到的 `p` 或 `q` 就是这两个节点（如果一个在另一个的子树中）的 LCA，所以直接返回 `root`。
     *
     *    b. **递归分解 (深入子树)**:
     *       - `left = lowestCommonAncestor(root.left, p, q)`: 在左子树中查找 LCA。
     *       - `right = lowestCommonAncestor(root.right, p, q)`: 在右子树中查找 LCA。
     *
     *    c. **处理当前层 (合并结果)**:
     *       - **情况 1**: 如果 `left` 和 `right` 都**不为 null**，这意味着 `p` 和 `q` 分别位于当前 `root` 节点的左右两侧。
     *         因此，当前 `root` 节点就是它们的最近公共祖先。我们返回 `root`。
     *       - **情况 2**: 如果 `left` **不为 null** 而 `right` 为 `null`，说明 `p` 和 `q` 都在左子树中。
     *         LCA 也在左子树中，并且 `left` 就是那个 LCA。我们返回 `left`。
     *       - **情况 3**: 如果 `right` **不为 null** 而 `left` 为 `null`，说明 `p` 和 `q` 都在右子树中。
     *         我们返回 `right`。
     *       - **情况 4**: 如果 `left` 和 `right` 都**为 null**，说明左右子树中都找不到 `p` 和 `q`。返回 `null`。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case 1: 如果树为空，或找到 p 或 q，则返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归搜索左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归搜索右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况 1: p 和 q 分布在 root 的两侧
        if (left != null && right != null) {
            return root;
        }

        // 情况 2 & 3: p 和 q 都在左子树或右子树中
        // 如果 left 不为空，则返回 left；否则返回 right (可能为 null)
        return left != null ? left : right;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 构建示例 1 的树: root = [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        // 示例 1
        TreeNode p1 = root1.left; // 节点 5
        TreeNode q1 = root1.right; // 节点 1
        TreeNode result1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("示例 1:");
        System.out.println("输入: p = 5, q = 1");
        System.out.println("输出: " + (result1 != null ? result1.val : "null")); // 应输出 3

        // 示例 2
        TreeNode p2 = root1.left; // 节点 5
        TreeNode q2 = root1.left.right.right; // 节点 4
        TreeNode result2 = solution.lowestCommonAncestor(root1, p2, q2);
        System.out.println("\n示例 2:");
        System.out.println("输入: p = 5, q = 4");
        System.out.println("输出: " + (result2 != null ? result2.val : "null")); // 应输出 5

        // 构建示例 3 的树: root = [1,2]
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        TreeNode p3 = root3;       // 节点 1
        TreeNode q3 = root3.left;  // 节点 2
        TreeNode result3 = solution.lowestCommonAncestor(root3, p3, q3);
        System.out.println("\n示例 3:");
        System.out.println("输入: p = 1, q = 2");
        System.out.println("输出: " + (result3 != null ? result3.val : "null")); // 应输出 1
    }
}
