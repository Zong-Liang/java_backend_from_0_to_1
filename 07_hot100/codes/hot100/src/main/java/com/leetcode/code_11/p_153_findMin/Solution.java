package com.leetcode.code_11.p_153_findMin;

import java.util.Arrays;

public class Solution {
    /**
     * 二分查找解法
     *
     * 算法思路：
     * 这个问题要求我们在 O(log n) 时间内找到旋转排序数组的最小值，这强烈暗示了需要使用二分查找。
     * 旋转后的数组可以看作是两个有序的子数组拼接而成，例如 `[4,5,6,7,0,1,2]`。最小值 `0` 正是第二个有序子数组的起始点，也是整个数组的“拐点”。
     * 我们的目标就是通过二分查找找到这个“拐点”。
     *
     * 1. **核心思想**：
     *    我们使用 `left` 和 `right` 指针来维护一个搜索区间。通过比较中间元素 `nums[mid]` 和右边界元素 `nums[right]`，我们可以判断最小值位于 `mid` 的哪一侧。
     *
     * 2. **查找过程**：
     *    - **情况 1: `nums[mid] < nums[right]`**
     *      - 这表明从 `mid` 到 `right` 的部分是单调递增的。
     *      - 那么，最小值（拐点）肯定不在 `(mid, right]` 这个区间内。
     *      - 它可能是 `nums[mid]` 本身，或者在 `mid` 的左侧。
     *      - 因此，我们收缩搜索区间的右边界：`right = mid`。
     *
     *    - **情况 2: `nums[mid] > nums[right]`**
     *      - 这表明从 `left` 到 `mid` 的部分是单调递增的，并且拐点（最小值）一定在 `mid` 的右侧。
     *      - 因此，我们收缩搜索区间的左边界：`left = mid + 1`。
     *
     * 3. **终止条件**：
     *    - 循环的终止条件是 `left == right`。当循环结束时，`left` 和 `right` 指针会汇合于最小元素的索引位置。
     *    - 我们返回 `nums[left]` (或 `nums[right]`) 即可。
     *
     * 4. **特殊情况**：
     *    - 如果数组没有旋转（或旋转了 n 次），它本身就是完全有序的。例如 `[11,13,15,17]`。
     *    - 我们的算法同样适用。在这种情况下，`nums[mid]` 总是小于 `nums[right]`，`right` 会不断向左收缩，最终 `left` 和 `right` 都会停在索引 0，即最小元素的位置。
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            // 根据题目约束，这不会发生，但作为健壮性检查
            throw new IllegalArgumentException("Input array is empty or null");
        }

        int left = 0;
        int right = nums.length - 1;

        // 当 left == right 时，循环结束，找到了最小值
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // 最小值在左半部分，或者就是 mid 本身
                right = mid;
            } else {
                // 最小值在右半部分
                left = mid + 1;
            }
        }

        // 循环结束后 left 指向的就是最小值的索引
        return nums[left];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = solution.findMin(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1); // 应输出 1

        // 示例 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = solution.findMin(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // 应输出 0

        // 示例 3
        int[] nums3 = {11, 13, 15, 17};
        int result3 = solution.findMin(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + result3); // 应输出 11
    }
}
