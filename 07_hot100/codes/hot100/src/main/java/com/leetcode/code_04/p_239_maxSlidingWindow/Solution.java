package com.leetcode.code_04.p_239_maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    /**
     * 单调队列解法
     *
     * 算法思路：
     * 暴力法（遍历每个窗口找最大值）的时间复杂度是 O(nk)，当 n 和 k 很大时会超时。
     * 一个高效的方法是使用一个双端队列（Deque）来维护一个“单调递减”的索引序列。
     *
     * 1. **队列的性质**:
     *    - 我们在双端队列中存储的是数组的 **索引**，而不是值。
     *    - 队列中的索引所对应的 `nums` 值是严格单调递减的。
     *    - 这样，队头（`deque.peekFirst()`）的索引就始终指向当前窗口中的最大值。
     *
     * 2. **算法流程**:
     *    - 我们遍历输入数组 `nums`。
     *    - 对于每一个要入窗的元素 `nums[i]`：
     *      a. **维护单调性 (清理队尾)**:
     *         从队尾开始，如果队尾索引对应的元素小于或等于 `nums[i]`，就将其从队尾移除。
     *         重复此过程，直到队尾元素大于 `nums[i]` 或队列为空。
     *         这一步确保了新加入的 `i` 不会破坏队列的单调递减性。
     *
     *      b. **入队**:
     *         将当前元素的索引 `i` 加入队尾。
     *
     *      c. **清理队头 (移除越界元素)**:
     *         检查队头索引是否已经滑出当前窗口的左边界。
     *         如果 `deque.peekFirst() <= i - k`，说明队头元素已过期，将其从队头移除。
     *
     *      d. **记录结果**:
     *         当窗口形成后（即 `i >= k - 1`），队头的索引就是当前窗口最大值的索引。
     *         我们将 `nums[deque.peekFirst()]` 存入结果数组。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 使用双端队列存储索引
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. 维护单调性：移除队尾所有小于当前值的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 2. 将当前索引加入队尾
            deque.offerLast(i);

            // 3. 清理队头：移除滑出窗口的元素
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 4. 记录结果：当窗口形成后，队头即为当前窗口最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("输出: " + Arrays.toString(result1)); // 应输出: [3, 3, 5, 5, 6, 7]

        // 示例 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("输出: " + Arrays.toString(result2)); // 应输出: [1]
    }
}
