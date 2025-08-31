package com.leetcode.code_11.p_4_findMedianSortedArrays;

import java.util.Arrays;

public class Solution {
    /**
     * 二分查找解法
     *
     * 算法思路：
     * 这个问题要求我们在对数时间内找到两个有序数组的中位数。直接合并数组（O(m+n)）会超时。
     * 核心思想是利用二分查找来找到一个“分割点”，这个分割点能将两个数组的所有元素划分为“左半部分”和“右半部分”，
     * 并且满足以下两个条件：
     * 1. 左半部分所有元素的最大值 <= 右半部分所有元素的最小值。
     * 2. 左半部分的元素数量等于（或在总数为奇数时，多于）右半部分的元素数量。
     *
     * 1. **问题转换**：
     *    我们不需要真的合并数组，只需要找到中位数的位置。中位数将合并后的数组分为数量相等的两半。
     *    我们的目标是在较短的数组（假设为 `nums1`）中找到一个分割点 `i`，
     *    它和 `nums2` 中对应的分割点 `j` 能够满足上述条件。
     *    `i` 和 `j` 的关系是 `i + j = (m + n + 1) / 2`，这样可以保证左半部分的总元素数量正确。
     *
     * 2. **二分查找**：
     *    - 我们在较短的数组上进行二分查找，以确定分割点 `i` 的位置。
     *    - 对于每一个 `i`，我们都能计算出对应的 `j`。
     *    - 然后我们检查分割是否满足条件：`nums1[i-1] <= nums2[j]` 并且 `nums2[j-1] <= nums1[i]`。
     *
     * 3. **调整边界**：
     *    - 如果 `nums1[i-1] > nums2[j]`，说明 `nums1` 的分割点 `i` 太靠右了，我们需要在 `nums1` 的左侧继续查找（缩小 `high`）。
     *    - 如果 `nums2[j-1] > nums1[i]`，说明 `nums1` 的分割点 `i` 太靠左了，我们需要在 `nums1` 的右侧继续查找（增大 `low`）。
     *
     * 4. **计算中位数**：
     *    - 一旦找到了正确的分割点，中位数就可以由左半部分的最大值和右半部分的最小值来确定。
     *    - 如果总元素数量 `(m+n)` 是奇数，中位数就是左半部分的最大值 `max(nums1[i-1], nums2[j-1])`。
     *    - 如果是偶数，中位数就是 `(max(左半部分) + min(右半部分)) / 2`。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，以优化二分查找的范围
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            // i 是 nums1 的分割点，j 是 nums2 的分割点
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            // 获取分割线两侧的四个关键值
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 检查是否找到了正确的分割点
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // 如果总长度是偶数
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else { // 如果总长度是奇数
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // i 太大了，需要向左移动
                high = i - 1;
            } else {
                // i 太小了，需要向右移动
                low = i + 1;
            }
        }

        // 题目保证输入有效，理论上不会执行到这里
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1_1 = {1, 3};
        int[] nums2_1 = {2};
        double result1 = solution.findMedianSortedArrays(nums1_1, nums2_1);
        System.out.println("示例 1:");
        System.out.println("输入: nums1 = " + Arrays.toString(nums1_1) + ", nums2 = " + Arrays.toString(nums2_1));
        System.out.println("输出: " + result1); // 应输出 2.00000

        // 示例 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        double result2 = solution.findMedianSortedArrays(nums1_2, nums2_2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums1 = " + Arrays.toString(nums1_2) + ", nums2 = " + Arrays.toString(nums2_2));
        System.out.println("输出: " + result2); // 应输出 2.50000
    }
}
