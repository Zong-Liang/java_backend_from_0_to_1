package com.leetcode.code_04.p_560_subarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 哈希表，键是前缀和，值是该前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化：前缀和为 0 的情况出现 1 次
        map.put(0, 1);
        
        int prefixSum = 0; // 当前前缀和
        int count = 0;     // 满足条件的子数组个数
        
        // 遍历数组
        for (int num : nums) {
            // 累加前缀和
            prefixSum += num;
            
            // 如果存在 prefixSum - k，说明有子数组和为 k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            
            // 更新哈希表，记录当前前缀和的出现次数
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 示例 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("示例 1 输出: " + solution.subarraySum(nums1, k1)); // 应输出 2
        
        // 示例 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("示例 2 输出: " + solution.subarraySum(nums2, k2)); // 应输出 2
    }
}
