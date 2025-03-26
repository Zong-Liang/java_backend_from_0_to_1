package com.leetcode.code_01.p_128_longestConsecutive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // 边界情况：如果数组为空，返回 0
        if (nums.length == 0) {
            return 0;
        }
        
        // 将所有数字存入哈希集合
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLength = 0; // 最长连续序列的长度
        
        // 遍历数组
        for (int num : set) {
            // 只有当 num 是连续序列的起点时才计算
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                // 向后检查连续序列
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                // 更新最长长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = solution.longestConsecutive(nums1);
        System.out.println("示例 1: " + result1); // 应输出 4

        // 测试用例 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result2 = solution.longestConsecutive(nums2);
        System.out.println("示例 2: " + result2); // 应输出 9

        // 测试用例 3
        int[] nums3 = {1, 0, 1, 2};
        int result3 = solution.longestConsecutive(nums3);
        System.out.println("示例 3: " + result3); // 应输出 3
    }
}
