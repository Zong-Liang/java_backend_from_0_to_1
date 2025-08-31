package com.leetcode.code_08.p_230_kthSmallest;

import java.util.Stack;

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
     * 迭代中序遍历解法
     *
     * 算法思路：
     * 二叉搜索树（BST）的一个关键特性是，对它进行中序遍历（左 -> 根 -> 右）会得到一个升序的节点值序列。
     * 因此，第 k 小的元素就是这个升序序列中的第 k 个元素。
     *
     * 我们可以通过迭代的方式执行中序遍历，并在遍历过程中计数，当访问到第 k 个节点时，立即返回其值。
     * 这种方法避免了完整遍历整棵树，一旦找到答案就可以提前终止。
     *
     * 1. **使用栈模拟递归**: 我们使用一个栈来模拟递归调用，实现迭代的中序遍历。
     *
     * 2. **遍历过程**:
     *    a. 初始化一个空栈和一个指向 `root` 的 `current` 指针。
     *    b. **向左深入**: 只要 `current` 不为空，就不断地将 `current` 节点压入栈中，并更新 `current` 为其左子节点 (`current = current.left`)。
     *       这一步会一直走到当前子树的最左边。
     *    c. **访问节点**: 当 `current` 变为 `null` 时，从栈中弹出一个节点。这个节点就是按中序顺序当前应该访问的节点。
     *    d. **计数与返回**: 每当访问一个节点，我们就将计数器 `k` 减 1。如果 `k` 变为 0，说明当前弹出的节点就是我们要找的第 k 小的元素，直接返回它的值。
     *    e. **转向右侧**: 访问完节点后，将 `current` 指针更新为该节点的右子节点 (`current = node.right`)，以便接下来处理右子树。
     *
     * 3. **循环**: 整个过程在一个大循环中进行，直到栈为空并且 `current` 也为空。
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 不断将左子节点压入栈中
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 当没有更多左子节点时，从栈中弹出节点并访问
            current = stack.pop();

            // 每访问一个节点，k 就减 1
            k--;
            // 如果 k 变为 0，说明找到了第 k 小的元素
            if (k == 0) {
                return current.val;
            }

            // 转向右子树
            current = current.right;
        }

        // 题目保证 k 有效，理论上不会执行到这里
        return -1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [3,1,4,null,2], k = 1
        //     3
        //    / \
        //   1   4
        //    \
        //     2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1, null, new TreeNode(2));
        root1.right = new TreeNode(4);
        int k1 = 1;
        int result1 = solution.kthSmallest(root1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [3,1,4,null,2], k = " + k1);
        System.out.println("输出: " + result1); // 应输出 1

        // 示例 2: root = [5,3,6,2,4,null,null,1], k = 3
        //        5
        //       / \
        //      3   6
        //     / \
        //    2   4
        //   /
        //  1
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        root2.right = new TreeNode(6);
        int k2 = 3;
        int result2 = solution.kthSmallest(root2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [5,3,6,2,4,null,null,1], k = " + k2);
        System.out.println("输出: " + result2); // 应输出 3
    }
}
