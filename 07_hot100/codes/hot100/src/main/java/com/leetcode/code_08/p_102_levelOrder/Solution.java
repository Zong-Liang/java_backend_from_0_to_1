package com.leetcode.code_08.p_102_levelOrder;

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
     * 层序遍历，顾名思义，就是按层级从上到下、从左到右地访问树中的所有节点。
     * 广度优先搜索（BFS）是实现层序遍历的完美算法，它通常借助队列（先进先出）数据结构来完成。
     *
     * 1. **初始化**:
     *    - 创建一个最终要返回的结果列表 `result` (List<List<Integer>>)。
     *    - 如果根节点 `root` 为空，直接返回空的 `result`。
     *    - 创建一个队列 `queue`，并将根节点 `root` 加入队列中。
     *
     * 2. **逐层遍历**:
     *    - 当队列不为空时，我们就开始处理树的一个新层级。
     *    - 首先，记录下当前队列的大小 `levelSize`。这个大小代表了当前层级所包含的节点数。
     *    - 创建一个列表 `currentLevel` 来存储当前层级所有节点的值。
     *    - 循环 `levelSize` 次，处理当前层级的所有节点：
     *      a. 从队列中取出一个节点 `node`。
     *      b. 将 `node.val` 添加到 `currentLevel` 列表中。
     *      c. 如果该节点有左子节点，将其左子节点加入队列。
     *      d. 如果该节点有右子节点，将其右子节点加入队列。
     *    - 循环结束后，`currentLevel` 列表就包含了当前层级所有节点的值。将其加入到 `result` 列表中。
     *    - 重复此过程，直到队列为空。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
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
        List<List<Integer>> result1 = solution.levelOrder(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [3,9,20,null,null,15,7]");
        System.out.println("输出: " + result1); // 应输出 [[3], [9, 20], [15, 7]]

        // 示例 2: root = [1]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [1]");
        System.out.println("输出: " + result2); // 应输出 [[1]]

        // 示例 3: root = []
        TreeNode root3 = null;
        List<List<Integer>> result3 = solution.levelOrder(root3);
        System.out.println("\n示例 3:");
        System.out.println("输入: root = []");
        System.out.println("输出: " + result3); // 应输出 []
    }
}
