package com.leetcode.code_13.p_215_findKthLargest;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private static final Random random = new Random();

    /**
     * 快速选择算法 (Quickselect)
     *
     * 算法思路：
     * 这个问题要求我们找到数组排序后的第 k 个最大元素。这等价于找到排序后索引为 `n - k` 的元素（其中 n 是数组长度）。
     * 我们可以借鉴快速排序的 `partition` (划分) 思想来解决这个问题，这就是快速选择算法。
     *
     * 1. **核心思想**：选择一个枢轴 (pivot)，将数组划分为两部分：一部分的元素都小于等于枢轴，另一部分的元素都大于等于枢轴。
     *    然后，我们检查枢轴的最终位置 `pivotIndex`。
     *
     * 2. **递归查找**：
     *    - 如果 `pivotIndex` 恰好等于我们想找的目标索引 `targetIndex = n - k`，那么我们就找到了答案，直接返回该元素。
     *    - 如果 `pivotIndex` 大于 `targetIndex`，说明我们要找的元素在枢轴的左边，我们就在左半部分继续进行划分查找。
     *    - 如果 `pivotIndex` 小于 `targetIndex`，说明我们要找的元素在枢轴的右边，我们就在右半部分继续进行划分查找。
     *
     * 3. **优化**：为了避免在有序或接近有序的数组上划分时性能退化到 O(n^2)，我们在选择枢轴时采用随机化策略。
     *    即在每次划分前，随机选择一个元素与区间的末尾元素交换，然后使用末尾元素作为枢轴。
     *
     * 4. **复杂度**：该算法的平均时间复杂度为 O(n)，最坏情况下的时间复杂度为 O(n^2)，但由于随机化的引入，最坏情况极难发生。
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 第 k 个最大元素，在升序排序后，其索引为 n - k
        int targetIndex = n - k;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            // 进行一次划分，并获取枢轴的最终位置
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex > targetIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        // 题目保证有解，理论上不会执行到这里
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        // 随机选择 pivot，避免最坏情况
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, randomIndex, right);

        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(new int[]{3, 2, 1, 5, 6, 4}) + ", k = " + k1);
        System.out.println("输出: " + result1); // 应输出 5

        // 示例 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}) + ", k = " + k2);
        System.out.println("输出: " + result2); // 应输出 4
    }
}
