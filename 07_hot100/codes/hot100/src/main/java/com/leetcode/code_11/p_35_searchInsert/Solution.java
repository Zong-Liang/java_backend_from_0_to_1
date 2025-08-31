package com.leetcode.code_11.p_35_searchInsert;

import java.util.Arrays;

public class Solution {
    /**
     * 二分查找解法
     *
     * 算法思路：
     * 这个问题要求我们在一个排序数组中找到目标值，如果找不到，则返回其应该插入的位置，
     * 并且时间复杂度要求为 O(log n)，这是使用二分查找的典型标志。
     *
     * 1. **核心思想**：
     *    我们维护一个搜索区间 `[left, right]`。在每次迭代中，我们取中间位置 `mid`，
     *    并比较 `nums[mid]` 和 `target` 的大小，以决定是保留左半部分还是右半部分作为新的搜索区间。
     *
     * 2. **查找过程**：
     *    - 如果 `nums[mid] == target`，我们找到了目标值，直接返回 `mid`。
     *    - 如果 `nums[mid] < target`，说明目标值（如果存在）必定在 `mid` 的右侧，因此我们将搜索区间的左边界更新为 `mid + 1`。
     *    - 如果 `nums[mid] > target`，说明目标值（如果存在）必定在 `mid` 的左侧，因此我们将搜索区间的右边界更新为 `mid - 1`。
     *
     * 3. **处理未找到的情况 (插入位置)**：
     *    - 循环的终止条件是 `left > right`。
     *    - 当循环结束时，如果目标值仍未被找到，那么 `left` 指针所在的位置就是目标值应该被插入的位置。
     *    - 为什么是 `left`？因为 `left` 始终指向搜索区间的第一个元素，在循环的最后，它会停在第一个大于或等于 `target` 的元素的位置上，这正是插入点。
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 循环结束后，left 的位置就是插入位置
        return left;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int result1 = solution.searchInsert(nums1, target1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("输出: " + result1); // 应输出 2

        // 示例 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出: " + result2); // 应输出 1

        // 示例 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("输出: " + result3); // 应输出 4
    }
}
