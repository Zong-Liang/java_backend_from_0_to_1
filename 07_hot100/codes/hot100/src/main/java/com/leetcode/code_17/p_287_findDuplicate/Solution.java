package com.leetcode.code_17.p_287_findDuplicate;

public class Solution {
    // 龟兔赛跑算法（弗洛伊德循环检测）
    public int findDuplicate(int[] nums) {
        // 初始化慢指针和快指针
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：找到相遇点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 第二阶段：重置慢指针到起点，找到循环入口（重复数）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // 返回重复数
        return slow;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 3, 4, 2, 2};
        int result1 = solution.findDuplicate(nums1);
        System.out.println("示例 1: " + result1); // 应输出 2

        // 示例 2
        int[] nums2 = {3, 1, 3, 4, 2};
        int result2 = solution.findDuplicate(nums2);
        System.out.println("示例 2: " + result2); // 应输出 3

        // 示例 3
        int[] nums3 = {3, 3, 3, 3, 3};
        int result3 = solution.findDuplicate(nums3);
        System.out.println("示例 3: " + result3); // 应输出 3
    }
}
