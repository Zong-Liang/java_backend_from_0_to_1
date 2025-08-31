package com.leetcode.code_08.p_108_sortedArrayToBST;

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
     * 递归 (分治) 解法
     *
     * 算法思路：
     * 要将一个有序数组转换为一个高度平衡的二叉搜索树 (BST)，最直观的方法是选择数组的中间元素作为树的根节点。
     * 这样可以确保分配给左子树和右子树的节点数量尽可能地相等，从而保证树的平衡性。
     *
     * 1. **选择根节点**:
     *    - 对于给定的有序数组（或其子数组），选择中间位置的元素作为当前子树的根节点。
     *
     * 2. **构建子树**:
     *    - 数组中位于中间元素左边的部分，是所有小于根节点值的元素，它们将构成左子树。
     *    - 数组中位于中间元素右边的部分，是所有大于根节点值的元素，它们将构成右子树。
     *
     * 3. **递归**:
     *    - 我们定义一个辅助函数，该函数接收数组的左右边界作为参数，并递归地为左右子数组执行相同的构建过程。
     *
     * 4. **递归的终止条件 (Base Case)**:
     *    - 当左边界 `left` 大于右边界 `right` 时，说明当前的子数组为空，没有节点需要创建，返回 `null`。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 递归辅助函数，用于构建树
     * @param nums 原始数组
     * @param left 当前子数组的左边界
     * @param right 当前子数组的右边界
     * @return 构建好的子树的根节点
     */
    private TreeNode build(int[] nums, int left, int right) {
        // 终止条件：如果左边界大于右边界，子数组为空
        if (left > right) {
            return null;
        }

        // 找到中间位置作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左子树
        root.left = build(nums, left, mid - 1);
        // 递归构建右子树
        root.right = build(nums, mid + 1, right);

        return root;
    }

    // 辅助函数，用于打印树（层序遍历），方便测试
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        java.util.List<String> list = new java.util.ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                list.add("null");
            }
        }
        // Trim trailing nulls for cleaner output
        int lastNonNull = -1;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("null")) {
                lastNonNull = i;
            }
        }
        System.out.println(list.subList(0, lastNonNull + 1));
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode result1 = solution.sortedArrayToBST(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [-10, -3, 0, 5, 9]");
        System.out.print("输出: ");
        printTree(result1); // 可能的输出: [0, -3, 9, -10, null, 5] 或 [0, -10, 5, null, -3, null, 9]

        // 示例 2
        int[] nums2 = {1, 3};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [1, 3]");
        System.out.print("输出: ");
        printTree(result2); // 可能的输出: [3, 1] 或 [1, null, 3]
    }
}
