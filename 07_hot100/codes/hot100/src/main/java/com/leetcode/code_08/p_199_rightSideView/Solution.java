package com.leetcode.code_08.p_199_rightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * 广度优先搜索 (BFS) 解法
     *
     * 算法思路：
     * “右视图”看到的是二叉树每一层的最右边的那个节点。这启发我们使用层序遍历（即广度优先搜索）来解决问题。
     *
     * 1. **层序遍历**:
     *    - 我们使用一个队列来进行标准的层序遍历，逐层处理树的节点。
     *
     * 2. **识别最右节点**:
     *    - 在遍历每一层时，我们首先记录下当前层的节点数量 `levelSize`。
     *    - 然后，我们循环 `levelSize` 次，处理当前层的所有节点。
     *    - 由于我们是从左到右将节点加入队列，并在下一轮处理，所以当循环进行到第 `levelSize - 1` 次（即最后一次）时，
     *      我们正在处理的节点就是当前层的最右边节点。
     *
     * 3. **收集结果**:
     *    - 在每一层的遍历中，当我们处理到该层的最后一个节点时，就将它的值添加到结果列表中。
     *
     * 4. **算法流程**:
     *    a. 初始化一个结果列表 `result` 和一个队列 `queue`。
     *    b. 如果根节点不为空，将其加入队列。
     *    c. 当队列不为空时，循环开始：
     *       i. 获取当前队列大小 `levelSize`。
     *       ii. 循环 `i` 从 0 到 `levelSize - 1`：
     *           - 出队一个节点 `node`。
     *           - 如果 `i == levelSize - 1`，将 `node.val` 加入 `result`。
     *           - 将 `node` 的非空左、右子节点依次入队。
     *    d. 循环结束后，返回 `result`。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 如果是当前层的最后一个节点，则加入结果集
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // 将下一层的节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [1,2,3,null,5,null,4]
        //      1
        //     / \
        //    2   3
        //     \   \
        //      5   4
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, null, new TreeNode(5));
        root1.right = new TreeNode(3, null, new TreeNode(4));
        List<Integer> result1 = solution.rightSideView(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,2,3,null,5,null,4]");
        System.out.println("输出: " + result1); // 应输出 [1, 3, 4]

        // 示例 2: root = [1,2,3,4,null,null,null,null,5]
        //      1
        //     / \
        //    2   3
        //   /
        //  4
        // /
        //5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null);
        root2.right = new TreeNode(3);
        List<Integer> result2 = solution.rightSideView(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [1,2,3,4,null,null,null,null,5]");
        System.out.println("输出: " + result2); // 应输出 [1, 3, 4, 5]

        // 示例 3
        TreeNode root3 = new TreeNode(1, null, new TreeNode(3));
        List<Integer> result3 = solution.rightSideView(root3);
        System.out.println("\n示例 3:");
        System.out.println("输入: root = [1,null,3]");
        System.out.println("输出: " + result3); // 应输出 [1, 3]

        // 示例 4
        TreeNode root4 = null;
        List<Integer> result4 = solution.rightSideView(root4);
        System.out.println("\n示例 4:");
        System.out.println("输入: root = []");
        System.out.println("输出: " + result4); // 应输出 []
    }
}
