package com.leetcode.code_17.p_31_nextPermutation;

public class Solution {
    // 标准解法
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 从右向左找到第一个非降序的位置 i
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果找到了这样的 i
        if (i >= 0) {
            // 从右向左找到第一个大于 nums[i] 的位置 j
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 反转 i+1 到末尾的部分
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.print("示例 1: [");
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]);
            if (k < nums1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [1, 3, 2]

        // 示例 2
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.print("示例 2: [");
        for (int k = 0; k < nums2.length; k++) {
            System.out.print(nums2[k]);
            if (k < nums2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [1, 2, 3]

        // 示例 3
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.print("示例 3: [");
        for (int k = 0; k < nums3.length; k++) {
            System.out.print(nums3[k]);
            if (k < nums3.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [1, 5, 1]
    }
}
