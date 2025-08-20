package com.leetcode.code_17.p_75_sortColors;

public class Solution {
    // 荷兰国旗解法
    public void sortColors(int[] nums) {
        int left = 0;
        int current = 0;
        int rigth = nums.length - 1;

        while (current <= rigth) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, rigth);
                rigth--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        System.out.print("示例 1: [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
            if (i < nums1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [0, 0, 1, 1, 2, 2]

        // 测试用例 2
        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        System.out.print("示例 2: [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            if (i < nums2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [0, 1, 2]
    }
}
