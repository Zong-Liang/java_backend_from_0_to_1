package com.leetcode.code_02.p_15_threeSum;

import java.util.*;

public class Solution {
    // 解题方法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // 数组长度小于 3，无法形成三元组
        if (n < 3) {
            return result;
        }
        
        // 排序
        Arrays.sort(nums);
        
        // 固定第一个元素 i
        for (int i = 0; i < n - 2; i++) {
            // 如果 nums[i] > 0，后面的元素都大于 0，三数之和不可能为 0
            if (nums[i] > 0) {
                break;
            }
            
            // 去重：跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 双指针
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // 找到一个三元组，加入结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 去重：跳过重复的 nums[left] 和 nums[right]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和太小，left 右移
                    left++;
                } else {
                    // 和太大，right 左移
                    right--;
                }
            }
        }
        
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("测试用例 1:");
        System.out.println("输入: " + arrayToString(nums1));
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println("输出: " + result1);
        
        // 测试用例 2
        int[] nums2 = {0, 1, 1};
        System.out.println("\n测试用例 2:");
        System.out.println("输入: " + arrayToString(nums2));
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println("输出: " + result2);
        
        // 测试用例 3
        int[] nums3 = {0, 0, 0};
        System.out.println("\n测试用例 3:");
        System.out.println("输入: " + arrayToString(nums3));
        List<List<Integer>> result3 = solution.threeSum(nums3);
        System.out.println("输出: " + result3);
    }
    
    // 辅助方法：将数组转换为字符串以便打印
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
