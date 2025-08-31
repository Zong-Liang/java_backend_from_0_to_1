package com.leetcode.code_05.p_238_productExceptSelf;

import java.util.Arrays;

public class Solution {

    /**
     * 前缀积与后缀积解法 (O(1) 额外空间)
     *
     * 算法思路：
     * 题目要求我们计算 `answer[i]`，它等于 `nums` 中 `nums[i]` 左边所有元素的乘积，乘以 `nums[i]` 右边所有元素的乘积。
     * 我们可以分两步来计算这个结果，并巧妙地利用输出数组 `answer` 来存储中间结果，从而达到 O(1) 的额外空间复杂度。
     *
     * 1. **第一遍遍历：计算前缀积**
     *    - 我们从左到右遍历数组。
     *    - 对于每个位置 `i`，我们将 `answer[i]` 设置为 `nums[i]` 左边所有元素的乘积。
     *    - 我们可以用一个变量 `prefixProduct` 来维护从左到右的累积乘积。
     *    - 遍历时，先将 `prefixProduct` 存入 `answer[i]`，然后再更新 `prefixProduct`。
     *
     * 2. **第二遍遍历：计算后缀积并得出最终结果**
     *    - 我们从右到左遍历数组。
     *    - 同样，我们用一个变量 `suffixProduct` 来维护从右到左的累积乘积。
     *    - 遍历时，`answer[i]` 已经存储了左侧的前缀积。我们只需要将它乘以右侧的后缀积 `suffixProduct` 即可得到最终结果。
     *    - 同样地，先用 `suffixProduct` 更新 `answer[i]`，然后再更新 `suffixProduct` 以供下一个位置使用。
     *
     * **示例: nums = [1, 2, 3, 4]**
     * - **第一遍 (前缀积)**:
     *   - i=0: answer[0] = 1. prefixProduct 更新为 1 * 1 = 1.  `answer` -> `[1, _, _, _]`
     *   - i=1: answer[1] = 1. prefixProduct 更新为 1 * 2 = 2.  `answer` -> `[1, 1, _, _]`
     *   - i=2: answer[2] = 2. prefixProduct 更新为 2 * 3 = 6.  `answer` -> `[1, 1, 2, _]`
     *   - i=3: answer[3] = 6. prefixProduct 更新为 6 * 4 = 24. `answer` -> `[1, 1, 2, 6]`
     *
     * - **第二遍 (后缀积)**:
     *   - i=3: answer[3] *= 1. suffixProduct 更新为 1 * 4 = 4.  `answer` -> `[1, 1, 2, 6]`
     *   - i=2: answer[2] *= 4. suffixProduct 更新为 4 * 3 = 12. `answer` -> `[1, 1, 8, 6]`
     *   - i=1: answer[1] *= 12. suffixProduct 更新为 12 * 2 = 24.`answer` -> `[1, 12, 8, 6]`
     *   - i=0: answer[0] *= 24. suffixProduct 更新为 24 * 1 = 24.`answer` -> `[24, 12, 8, 6]` (最终结果)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. 第一遍遍历：计算前缀积，并存入 answer 数组
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // 2. 第二遍遍历：计算后缀积，并与 answer 数组中的前缀积相乘
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + Arrays.toString(result1)); // 应输出 [24, 12, 8, 6]

        // 示例 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + Arrays.toString(result2)); // 应输出 [0, 0, 9, 0, 0]
    }
}
