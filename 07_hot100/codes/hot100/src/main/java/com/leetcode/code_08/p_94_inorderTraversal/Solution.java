package com.leetcode.code_08.p_94_inorderTraversal;

import java.util.ArrayList;
import java.util.List;
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

    // ================= 方法一: 递归解法 =================
    /**
     * 算法思路：
     * 中序遍历的顺序是：左子树 -> 根节点 -> 右子树。
     * 递归是实现这种结构最自然的方式。
     *
     * 1. 定义一个辅助函数 `dfs(node, result)`。
     * 2. **终止条件**: 如果当前节点 `node` 为 `null`，则直接返回。
     * 3. **递归步骤**:
     *    a. 递归地遍历左子树：`dfs(node.left, result)`。
     *    b. 访问根节点：将 `node.val` 添加到结果列表中。
     *    c. 递归地遍历右子树：`dfs(node.right, result)`。
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }


    // ================= 方法二: 迭代解法 (进阶) =================
    /**
     * 算法思路：
     * 我们可以使用一个栈（Stack）来模拟递归的过程，从而实现迭代遍历。
     *
     * 1. 初始化一个空栈和一个指向 `root` 的 `current` 指针。
     * 2. 当 `current` 不为 `null` 或者栈不为空时，循环继续。
     * 3. **向左深入**: 只要 `current` 不为 `null`，就不断地将 `current` 节点压入栈中，并更新 `current` 为其左子节点 (`current = current.left`)。
     *    这一步模拟了递归中“先访问左子树”的部分，直到找到最左边的节点。
     * 4. **访问节点**: 当 `current` 变为 `null` 时，说明已经到达了最左侧。此时从栈中弹出一个节点，这个节点就是当前应该访问的节点。
     *    我们将该节点的值添加到结果列表中。
     * 5. **转向右侧**: 访问完节点后，将 `current` 指针更新为该节点的右子节点 (`current = node.right`)，
     *    以便接下来处理右子树。然后循环回到第 2 步。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
            result.add(current.val);

            // 转向右子树
            current = current.right;
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [1,null,2,3]
        //   1
        //    \
        //     2
        //    /
        //   3
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        List<Integer> result1 = solution.inorderTraversal(root1);
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,null,2,3]");
        System.out.println("输出: " + result1); // 应输出 [1, 3, 2]

        // 示例 2: root = []
        TreeNode root2 = null;
        List<Integer> result2 = solution.inorderTraversal(root2);
        System.out.println("\n示例 2:");
        System.out.println("输入: root = []");
        System.out.println("输出: " + result2); // 应输出 []

        // 示例 3: root = [1]
        TreeNode root3 = new TreeNode(1);
        List<Integer> result3 = solution.inorderTraversal(root3);
        System.out.println("\n示例 3:");
        System.out.println("输入: root = [1]");
        System.out.println("输出: " + result3); // 应输出 [1]
    }
}
