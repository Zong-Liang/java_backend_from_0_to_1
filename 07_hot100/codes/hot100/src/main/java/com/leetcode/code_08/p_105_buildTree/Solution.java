package com.leetcode.code_08.p_105_buildTree;

import java.util.HashMap;
import java.util.Map;

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

    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;

    /**
     * 递归解法
     *
     * 算法思路：
     * 我们可以利用前序遍历和中序遍历的特性来唯一地确定一棵二叉树。
     *
     * 1. **前序遍历 (Preorder)** `[根节点, [左子树], [右子树]]`
     *    - 第一个元素总是当前子树的根节点。
     *
     * 2. **中序遍历 (Inorder)** `[[左子树], 根节点, [右子树]]`
     *    - 根节点左边的所有元素都属于左子树。
     *    - 根节点右边的所有元素都属于右子树。
     *
     * **构建过程**:
     * a. 从前序遍历序列中取出第一个元素，它就是当前树的根节点。
     * b. 在中序遍历序列中找到这个根节点的位置。
     * c. 中序遍历中根节点左边的部分就是左子树的中序遍历，右边的部分就是右子树的中序遍历。
     * d. 根据左子树的节点数量，我们可以在前序遍历序列中确定左子树的前序遍历范围。
     * e. 递归地对左子树和右子树执行相同的构建过程。
     *
     * **优化**:
     * 为了快速在中序遍历中找到根节点的位置，我们可以预先将中序遍历的结果存入一个哈希表中，
     * 这样就可以在 O(1) 的时间内定位根节点。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化前序遍历的根节点索引
        preorderIndex = 0;
        // 构建中序遍历的 <值, 索引> 映射，用于快速查找
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // 调用递归辅助函数开始构建
        return build(preorder, 0, inorder.length - 1);
    }

    /**
     * 递归辅助函数
     * @param preorder 前序遍历数组
     * @param inorderLeft 当前子树在中序遍历中的左边界
     * @param inorderRight 当前子树在中序遍历中的右边界
     * @return 构建好的子树的根节点
     */
    private TreeNode build(int[] preorder, int inorderLeft, int inorderRight) {
        // 终止条件：如果左边界大于右边界，说明子树为空
        if (inorderLeft > inorderRight) {
            return null;
        }

        // 1. 从前序遍历中获取根节点值，并递增索引
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // 2. 在中序遍历中找到根节点的位置，以分割左右子树
        int inorderRootIndex = inorderMap.get(rootVal);

        // 3. 递归构建左子树
        // 左子树的范围是 [inorderLeft, inorderRootIndex - 1]
        root.left = build(preorder, inorderLeft, inorderRootIndex - 1);

        // 4. 递归构建右子树
        // 右子树的范围是 [inorderRootIndex + 1, inorderRight]
        root.right = build(preorder, inorderRootIndex + 1, inorderRight);

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
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("示例 1:");
        System.out.println("输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]");
        System.out.print("输出: ");
        printTree(root1); // 预期输出 [3, 9, 20, null, null, 15, 7]

        // 示例 2
        // 需要重置实例变量
        solution = new Solution();
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("\n示例 2:");
        System.out.println("输入: preorder = [-1], inorder = [-1]");
        System.out.print("输出: ");
        printTree(root2); // 预期输出 [-1]
    }
}
