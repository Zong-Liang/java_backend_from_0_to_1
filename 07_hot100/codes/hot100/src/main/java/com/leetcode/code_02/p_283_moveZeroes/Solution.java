package com.leetcode.code_02.p_283_moveZeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        // 定义非零元素应该放置的位置
        int nonZeroIndex = 0;
        
        // 第一次遍历：将非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        
        // 第二次操作：将剩余位置填 0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("测试用例 1:");
        System.out.println("输入: " + Arrays.toString(nums1));
        solution.moveZeroes(nums1);
        System.out.println("输出: " + Arrays.toString(nums1));

        // 测试用例 2
        int[] nums2 = {0};
        System.out.println("\n测试用例 2:");
        System.out.println("输入: " + Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("输出: " + Arrays.toString(nums2));
    }
}
