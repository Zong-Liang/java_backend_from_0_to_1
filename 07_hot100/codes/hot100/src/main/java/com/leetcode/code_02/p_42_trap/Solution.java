package com.leetcode.code_02.p_42_trap;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // 数组长度小于 3，无法接雨水
        }

        int water = 0; // 总雨水量
        int left = 0; // 左指针
        int right = height.length - 1; // 右指针
        int leftMax = 0; // 左边最大高度
        int rightMax = 0; // 右边最大高度

        // 当左指针小于右指针时，继续循环
        while (left < right) {
            // 比较左右两侧高度，处理较矮的一侧
            if (height[left] < height[right]) {
                // 更新左边最大高度
                leftMax = Math.max(leftMax, height[left]);
                // 当前位置能接的雨水量
                water += leftMax - height[left];
                // 左指针右移
                left++;
            } else {
                // 更新右边最大高度
                rightMax = Math.max(rightMax, height[right]);
                // 当前位置能接的雨水量
                water += rightMax - height[right];
                // 右指针左移
                right--;
            }
        }

        return water;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("测试用例 1:");
        System.out.println("输入: " + arrayToString(height1));
        int result1 = solution.trap(height1);
        System.out.println("输出: " + result1);

        // 测试用例 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("\n测试用例 2:");
        System.out.println("输入: " + arrayToString(height2));
        int result2 = solution.trap(height2);
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
