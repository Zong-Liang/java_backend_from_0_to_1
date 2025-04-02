package com.leetcode.code_04.p_239_maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // 结果数组的长度
        Deque<Integer> deque = new ArrayDeque<>(); // 单调队列，存储索引
        
        // 遍历数组
        for (int i = 0; i < n; i++) {
            // 1. 移除不在窗口内的元素
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            
            // 2. 维护单调递减队列，移除尾部小于当前元素的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. 将当前元素的索引加入队列
            deque.offerLast(i);
            
            // 4. 当窗口形成时，记录最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 示例 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.print("示例 1 输出: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [3, 3, 5, 5, 6, 7]
        
        // 示例 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.print("示例 2 输出: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // 应输出 [1]
    }
}
