package com.leetcode.code_08.p_101_isSymmetric;

import java.util.LinkedList;
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

    // ================= 方法一: 递归解法 =================
    /**
     * 算法思路：
     * 一棵树是对称的，当且仅当它的左子树和右子树是镜像对称的。
     * 两个树 `p` 和 `q` 是镜像对称的，需要满足三个条件：
     * 1. 它们的根节点值相等 (`p.val == q.val`)。
     * 2. `p` 的左子树与 `q` 的右子树是镜像对称的。
     * 3. `p` 的右子树与 `q` 的左子树是镜像对称的。
     *
     * 我们可以定义一个辅助递归函数 `isMirror(p, q)` 来实现这个逻辑。
     *
     * 1. **终止条件 (Base Cases)**:
     *    - 如果 `p` 和 `q` 都为 `null`，它们是镜像的，返回 `true`。
     *    - 如果 `p` 和 `q` 中只有一个为 `null`，或者它们的值不相等，它们不是镜像的，返回 `false`。
     *
     * 2. **递归步骤**:
     *    - 递归地比较 `p.left` 和 `q.right`，以及 `p.right` 和 `q.left`。
     *    - 只有当这两个递归调用都返回 `true` 时，`p` 和 `q` 才是镜像对称的。
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }


    // ================= 方法二: 迭代解法 (进阶) =================
    /**
     * 算法思路：
     * 我们可以使用一个队列（Queue）来实现迭代的、层序遍历的检查。
     *
     * 1. 初始化一个队列，并将根节点的左子节点和右子节点成对地加入队列。
     * 2. 当队列不为空时，循环继续。
     * 3. 每次从队列中取出两个节点 `p` 和 `q` 进行比较。
     * 4. **比较逻辑**:
     *    - 如果 `p` 和 `q` 都为 `null`，说明这对节点是对称的，继续下一轮循环。
     *    - 如果 `p` 和 `q` 中只有一个为 `null`，或者它们的值不相等，说明树不对称，直接返回 `false`。
     * 5. **入队逻辑**:
     *    - 为了检查下一层是否对称，我们需要按照镜像的顺序将它们的子节点成对地加入队列：
     *      - `p.left` 和 `q.right`
     *      - `p.right` 和 `q.left`
     * 6. 如果循环正常结束（队列为空），说明所有层次的节点都通过了对称性检查，返回 `true`。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;

            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [1,2,2,3,4,4,3]
        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean result1 = solution.isSymmetric(root1); // 测试迭代法
        boolean result1_rec = solution.isSymmetricRecursive(root1); // 测试递归法
        System.out.println("示例 1:");
        System.out.println("输入: root = [1,2,2,3,4,4,3]");
        System.out.println("输出 (迭代): " + result1); // 应输出 true
        System.out.println("输出 (递归): " + result1_rec); // 应输出 true

        // 示例 2: root = [1,2,2,null,3,null,3]
        //      1
        //     / \
        //    2   2
        //     \   \
        //      3   3
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        boolean result2 = solution.isSymmetric(root2); // 测试迭代法
        boolean result2_rec = solution.isSymmetricRecursive(root2); // 测试递归法
        System.out.println("\n示例 2:");
        System.out.println("输入: root = [1,2,2,null,3,null,3]");
        System.out.println("输出 (迭代): " + result2); // 应输出 false
        System.out.println("输出 (递归): " + result2_rec); // 应输出 false
    }
}
