package com.leetcode.code_11.p_33_search;

import java.util.Arrays;

public class Solution {
    /**
     * 改进的二分查找解法
     *
     * 算法思路：
     * 这个问题要求我们在一个旋转过的排序数组中查找元素，并且时间复杂度为 O(log n)，这提示我们必须使用二分查找。
     * 但是，常规的二分查找依赖于数组的完全有序性。由于数组被旋转过，我们不能简单地通过比较 `target` 和 `nums[mid]` 来决定搜索哪一半。
     *
     * 核心思想是，当我们通过 `mid` 将数组分成两半时，其中至少有一半是保持有序的。
     *
     * 1. **确定有序部分**：
     *    - 比较 `nums[mid]` 和 `nums[left]` 的值。
     *    - 如果 `nums[left] <= nums[mid]`，那么从 `left` 到 `mid` 的左半部分是单调递增的。
     *    - 否则，从 `mid` 到 `right` 的右半部分是单调递增的。
     *
     * 2. **确定搜索范围**：
     *    - 一旦我们确定了哪一半是有序的，我们就可以判断 `target` 是否位于这个有序的区间内。
     *    - **如果左半部分有序**:
     *      - 检查 `target` 是否在 `[nums[left], nums[mid])` 这个区间内。
     *      - 如果是，我们就收缩右边界 (`right = mid - 1`)，在左半部分继续查找。
     *      - 否则，`target` 只能在右半部分，我们收缩左边界 (`left = mid + 1`)。
     *    - **如果右半部分有序**:
     *      - 检查 `target` 是否在 `(nums[mid], nums[right]]` 这个区间内。
     *      - 如果是，我们就收缩左边界 (`left = mid + 1`)，在右半部分继续查找。
     *      - 否则，`target` 只能在左半部分，我们收缩右边界 (`right = mid - 1`)。
     *
     * 3. **循环与终止**：
     *    - 重复这个过程，直到 `left > right`，如果此时仍未找到 `target`，则说明它不存在于数组中。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断左半部分 [left, mid] 是否有序
            if (nums[left] <= nums[mid]) {
                // target 在左半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else { // target 在右半部分
                    left = mid + 1;
                }
            } else { // 否则，右半部分 [mid, right] 是有序的
                // target 在右半部分
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else { // target 在左半部分
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = solution.search(nums1, target1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("输出: " + result1); // 应输出 4

        // 示例 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = solution.search(nums2, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出: " + result2); // 应输出 -1

        // 示例 3
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solution.search(nums3, target3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("输出: " + result3); // 应输出 -1
    }
}
