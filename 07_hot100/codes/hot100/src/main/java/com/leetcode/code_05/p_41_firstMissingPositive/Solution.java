package com.leetcode.code_05.p_41_firstMissingPositive;

import java.util.Arrays;

public class Solution {

    /**
     * 原地哈希 / 循环排序解法
     *
     * 算法思路：
     * 题目要求我们用 O(n) 时间和 O(1) 空间来解决问题，这意味着我们不能使用额外的哈希表或进行常规排序。
     * 唯一的选择就是原地修改输入数组，利用数组的索引来作为“哈希表”。
     *
     * 核心思想是：我们希望将数字 `x` 放置到它“应该”在的位置，即索引 `x-1` 的位置。
     * 例如，数字 `1` 应该在索引 `0`，数字 `2` 应该在索引 `1`，以此类推。
     *
     * 1. **遍历与交换**:
     *    - 我们遍历整个数组。对于当前位置 `i` 的数字 `nums[i]`：
     *    - 我们只关心在 `[1, n]` 范围内的正数（其中 `n` 是数组长度），因为缺失的第一个正数必然也在此范围内（或者是 `n+1`）。
     *    - 设 `num = nums[i]`。如果 `num` 是一个我们关心的有效数字，它的目标位置应该是 `targetIndex = num - 1`。
     *    - 我们检查 `num` 是否已经在正确的位置上（即 `nums[targetIndex] == num`）。
     *    - 如果不在，我们就将 `nums[i]` 与 `nums[targetIndex]` 进行交换。
     *    - **关键**: 交换后，新的 `nums[i]` 可能仍然不是它应该在的位置，所以我们用一个 `while` 循环，
     *      不断地对当前位置 `i` 的新数字进行检查和交换，直到 `nums[i]` 是一个无效数字（负数、0、或 > n）或者它已经被放到了正确的位置。
     *
     * 2. **查找结果**:
     *    - 经过第一步的处理后，理想情况下，数组中 `nums[i]` 的值应该等于 `i + 1`。
     *    - 我们再次遍历数组，找到第一个 `nums[i] != i + 1` 的位置。
     *    - 那么，`i + 1` 就是我们苦苦寻找的“缺失的第一个正数”。
     *
     * 3. **处理边界情况**:
     *    - 如果第二次遍历结束后，发现所有位置都满足 `nums[i] == i + 1`，
     *      这说明数组中包含了从 `1` 到 `n` 的所有整数。
     *    - 那么，缺失的第一个正数就是 `n + 1`。
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. 原地交换，将数字放到对应的索引位置
        for (int i = 0; i < n; i++) {
            // 当 nums[i] 是有效正数，且不在正确位置时，进行交换
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }

        // 2. 查找第一个不在正确位置的数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. 如果 1 到 n 都在，则返回 n + 1
        return n + 1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 0};
        int result1 = solution.firstMissingPositive(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(new int[]{1,2,0}));
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        int[] nums2 = {3, 4, -1, 1};
        int result2 = solution.firstMissingPositive(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(new int[]{3,4,-1,1}));
        System.out.println("输出: " + result2); // 应输出 2

        // 示例 3
        int[] nums3 = {7, 8, 9, 11, 12};
        int result3 = solution.firstMissingPositive(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(new int[]{7,8,9,11,12}));
        System.out.println("输出: " + result3); // 应输出 1
    }
}
