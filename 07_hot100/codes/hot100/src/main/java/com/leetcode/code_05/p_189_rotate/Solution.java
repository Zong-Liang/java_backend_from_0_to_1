package com.leetcode.code_05.p_189_rotate;

import java.util.Arrays;

public class Solution {

    /**
     * 三次反转解法 (原地算法 O(1) 空间)
     *
     * 算法思路：
     * 这是一种非常巧妙的原地算法。将数组向右旋转 k 步可以分解为以下三个步骤：
     *
     * 1. **整体反转**: 将整个数组的所有元素进行反转。
     *    例如：`[1,2,3,4,5,6,7]` 反转后变为 `[7,6,5,4,3,2,1]`。
     *
     * 2. **反转前 k 个元素**: 将反转后数组的前 k 个元素再次进行反转。
     *    例如：`[7,6,5,4,3,2,1]` 的前 3 个元素是 `[7,6,5]`，反转后变为 `[5,6,7]`。
     *    此时数组变为 `[5,6,7,4,3,2,1]`。
     *
     * 3. **反转剩余的 n-k 个元素**: 将数组中剩余的 `n-k` 个元素进行反转。
     *    例如：`[5,6,7,4,3,2,1]` 的剩余部分是 `[4,3,2,1]`，反转后变为 `[1,2,3,4]`。
     *    此时数组变为 `[5,6,7,1,2,3,4]`，这正是我们想要的结果。
     *
     * **注意**:
     * - `k` 的值可能大于数组的长度 `n`。向右旋转 `n` 步等于没有旋转，所以我们实际需要旋转的步数是 `k % n`。
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 实际需要旋转的步数
        k %= n;

        // 1. 整体反转
        reverse(nums, 0, n - 1);
        // 2. 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 3. 反转剩余的 n-k 个元素
        reverse(nums, k, n - 1);
    }

    /**
     * 辅助函数，用于反转数组的指定部分
     * @param nums 数组
     * @param start 起始索引
     * @param end 结束索引
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        solution.rotate(nums1, k1);
        System.out.println("输出: " + Arrays.toString(nums1)); // 应输出: [5, 6, 7, 1, 2, 3, 4]

        // 示例 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        solution.rotate(nums2, k2);
        System.out.println("输出: " + Arrays.toString(nums2)); // 应输出: [3, 99, -1, -100]
    }
}
