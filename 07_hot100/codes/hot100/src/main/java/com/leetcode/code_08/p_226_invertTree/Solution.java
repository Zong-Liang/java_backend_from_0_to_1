package com.leetcode.code_08.p_226_invertTree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
     * 要翻转整棵树，我们可以将其分解为一个个子问题：对于树中的每一个节点，我们只需要交换它的左子节点和右子节点即可。
     * 然后，我们再对交换后的左子树和右子树递归地执行同样的操作。
     * 这是一个典型的自顶向下的递归过程。
     *
     * 1. **递归的终止条件 (Base Case)**:
     *    - 如果当前节点 `root` 为 `null`，说明它是一棵空树或到达了叶子节点的子节点，无需任何操作，直接返回 `null`。
     *
     * 2. **递归的分解与合并**:
     *    a. **先递归翻转子树**:
     *       - `invertTree(root.left)`: 递归地翻转左子树。
     *       - `invertTree(root.right)`: 递归地翻转右子树。
     *       （注意：先翻转子树再交换当前节点，或者先交换当前节点再翻转子树，结果是一样的。）
     *
     *    b. **处理当前节点**:
     *       - 创建一个临时变量 `temp` 保存左子节点。
     *       - 将根节点的左子节点指向原来的右子节点。
     *       - 将根节点的右子节点指向保存在 `temp` 中的原左子节点。
     *
     *    c. **返回结果**:
     *       - 返回处理完毕的当前节点 `root`。
     */
    public TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }

        // 递归翻转左子树和右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 交换当前节点的左右子节点
        root.left = right;
        root.right = left;

        return root;
    }

    // 辅助函数，用于打印树（层序遍历），方便验证结果
    public static List<Integer> levelOrderPrint(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("示例 1:");
        System.out.println("输入: " + levelOrderPrint(root1)); // 原始树的层序遍历
        TreeNode invertedRoot1 = solution.invertTree(root1);
        System.out.println("输出: " + levelOrderPrint(invertedRoot1)); // 翻转后树的层序遍历

        // 示例 2
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("\n示例 2:");
        System.out.println("输入: " + levelOrderPrint(root2));
        TreeNode invertedRoot2 = solution.invertTree(root2);
        System.out.println("输出: " + levelOrderPrint(invertedRoot2));

        // 示例 3
        TreeNode root3 = null;
        System.out.println("\n示例 3:");
        System.out.println("输入: " + levelOrderPrint(root3));
        TreeNode invertedRoot3 = solution.invertTree(root3);
        System.out.println("输出: " + levelOrderPrint(invertedRoot3));
    }
}
