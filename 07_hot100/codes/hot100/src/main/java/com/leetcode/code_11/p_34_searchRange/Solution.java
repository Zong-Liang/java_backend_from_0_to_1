package com.leetcode.code_11.p_34_searchRange;

import java.util.Arrays;

public class Solution {
    /**
     * 二分查找解法
     *
     * 算法思路：
     * 这个问题要求我们在 O(log n) 的时间内找到目标值的起始和结束位置，这表明我们需要使用二分查找。
     * 我们可以通过执行两次二分查找来解决这个问题：
     * 1. 第一次查找：找到目标值的第一个（最左边）出现的位置。
     * 2. 第二次查找：找到目标值的最后一个（最右边）出现的位置。
     *
     * **查找第一个位置 (findFirstPosition)**:
     * - 我们执行一个标准的二分查找。
     * - 当 `nums[mid] == target` 时，我们找到了一个目标值。但这不一定是第一个，所以我们将这个位置记录下来，并尝试在左半部分（`right = mid - 1`）继续寻找，看是否能找到更早出现的位置。
     * - 如果 `nums[mid] < target`，目标在右侧，`left = mid + 1`。
     * - 如果 `nums[mid] > target`，目标在左侧，`right = mid - 1`。
     *
     * **查找最后一个位置 (findLastPosition)**:
     * - 同样执行二分查找。
     * - 当 `nums[mid] == target` 时，我们找到了一个目标值。但这不一定是最后一个，所以我们将这个位置记录下来，并尝试在右半部分（`left = mid + 1`）继续寻找，看是否能找到更晚出现的位置。
     * - 其他逻辑与标准二分查找相同。
     *
     * 最后，我们将两次查找的结果组合成一个数组返回。
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }

    // 查找第一个等于 target 的位置
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPos = mid; // 找到了一个，但继续向左找
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPos;
    }

    // 查找最后一个等于 target 的位置
    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastPos = mid; // 找到了一个，但继续向右找
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastPos;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("输出: " + Arrays.toString(result1)); // 应输出 [3, 4]

        // 示例 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出: " + Arrays.toString(result2)); // 应输出 [-1, -1]

        // 示例 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("输出: " + Arrays.toString(result3)); // 应输出 [-1, -1]
    }
}
