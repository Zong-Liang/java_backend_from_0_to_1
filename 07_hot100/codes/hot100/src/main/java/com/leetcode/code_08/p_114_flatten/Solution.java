package com.leetcode.code_08.p_114_flatten;

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

    // ================= 方法一: 后序遍历递归解法 =================
    private TreeNode prev = null;

    /**
     * 算法思路：
     * 题目要求展开后的顺序是前序遍历的顺序。如果我们反向思考，展开后的链表的最后一个节点是原树最右下的节点。
     * 我们可以采用一种“反向”的前序遍历（右 -> 左 -> 根），这实际上就是一种后序遍历的变体。
     *
     * 1. 我们维护一个全局（或通过参数传递）的指针 `prev`，它始终指向刚刚处理过的节点。
     * 2. 递归地处理右子树。
     * 3. 递归地处理左子树。
     * 4. 处理当前根节点：
     *    - 将当前根节点的 `right` 指针指向 `prev`。
     *    - 将当前根节点的 `left` 指针设为 `null`。
     *    - 更新 `prev` 为当前根节点。
     *
     * 这样从最右下的节点开始，一步步将树的节点串联起来，最终形成所需的链表。
     */
    public void flattenRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归处理右子树
        flattenRecursive(root.right);
        // 递归处理左子树
        flattenRecursive(root.left);

        // 将当前节点的 right 指向 prev (前一个处理的节点)
        root.right = prev;
        // 左子节点设为 null
        root.left = null;
        // 更新 prev 为当前节点
        prev = root;
    }


    // ================= 方法二: 原地算法 (进阶 O(1) 空间) =================
    /**
     * 算法思路：
     * 这种方法不使用递归栈或显式栈，实现了 O(1) 的额外空间复杂度。
     * 核心思想是为每个节点找到其左子树中的“前驱”节点（即左子树中最右边的节点），
     * 然后将原节点的右子树连接到这个前驱节点的右侧。
     *
     * 1. 遍历树，只要当前节点 `curr` 不为空。
     * 2. 如果 `curr` 有左子树：
     *    a. 找到左子树的最右节点（前驱节点 `predecessor`）。
     *    b. 将 `curr` 的右子树 `curr.right` 连接到 `predecessor.right`。
     *    c. 将 `curr` 的左子树移动到其右侧，成为新的 `curr.right`。
     *    d. 将 `curr` 的左子树设为 `null`。
     * 3. 无论 `curr` 是否有左子树，处理完后都移动到下一个节点（即新的 `curr.right`）。
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // 找到左子树的最右节点
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // 将原右子树连接到前驱节点
                predecessor.right = curr.right;

                // 将左子树移动到右侧
                curr.right = curr.left;
                curr.left = null;
            }
            // 移动到下一个节点
            curr = curr.right;
        }
    }


    // 辅助函数，用于打印展开后的链表，方便测试
    public static void printFlattenedTree(TreeNode root) {
        System.out.print("[");
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val);
            if(curr.left != null) System.out.print(",left:" + curr.left.val); // Should be null
            if (curr.right != null) {
                System.out.print(",null,");
            }
            curr = curr.right;
        }
        System.out.println("]");
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,2,5,3,4,null,6]");
        solution.flatten(root1); // 使用原地算法
        System.out.print("输出: ");
        printFlattenedTree(root1); // 应输出 [1,null,2,null,3,null,4,null,5,null,6]

        // 示例 2
        TreeNode root2 = null;
        System.out.println("\n示例 2:");
        System.out.println("输入: root = []");
        solution.flatten(root2);
        System.out.print("输出: ");
        printFlattenedTree(root2); // 应输出 []

        // 示例 3
        TreeNode root3 = new TreeNode(0);
        System.out.println("\n示例 3:");
        System.out.println("输入: root = [0]");
        solution.flatten(root3);
        System.out.print("输出: ");
        printFlattenedTree(root3); // 应输出 [0]
    }
}
