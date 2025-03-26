package com.leetcode.code_02.p_11_maxArea;

public class Solution {
    // 解题方法
    public int maxArea(int[] height) {
        int maxArea = 0; // 记录最大面积
        int left = 0; // 左指针
        int right = height.length - 1; // 右指针

        // 当左指针小于右指针时，继续循环
        while (left < right) {
            // 计算当前面积
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * width;

            // 更新最大面积
            maxArea = Math.max(maxArea, area);

            // 移动较短的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("测试用例 1:");
        System.out.println("输入: " + arrayToString(height1));
        int result1 = solution.maxArea(height1);
        System.out.println("输出: " + result1);

        // 测试用例 2
        int[] height2 = {1, 1};
        System.out.println("\n测试用例 2:");
        System.out.println("输入: " + arrayToString(height2));
        int result2 = solution.maxArea(height2);
        System.out.println("输出: " + result2);
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
