package com.leetcode.code_01.p_128_longestConsecutive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 哈希集合解法
     *
     * 算法思路：
     * 如果我们先对数组排序，那么问题就变得简单了，但这需要 O(n log n) 的时间。
     * 为了达到 O(n) 的时间复杂度，我们可以使用哈希集合来以空间换时间。
     *
     * 1. **预处理**:
     *    - 创建一个哈希集合 `numSet`。
     *    - 遍历输入数组 `nums`，将所有数字添加到 `numSet` 中。
     *      这一步不仅可以去重，还使得我们能在 O(1) 的时间内检查一个数字是否存在。
     *
     * 2. **遍历与计算**:
     *    - 再次遍历输入数组 `nums` 中的每一个数字 `num`。
     *    - **核心优化**: 对于每个 `num`，我们首先检查 `num - 1` 是否存在于 `numSet` 中。
     *      - 如果 `num - 1` **存在**，说明 `num` 不是一个连续序列的起点，我们可以跳过它，
     *        因为它肯定会被从真正的起点开始的序列所覆盖。
     *      - 如果 `num - 1` **不存在**，说明 `num` 是一个潜在的连续序列的起点。
     *
     * 3. **寻找序列长度**:
     *    - 当我们找到一个起点 `num` 后，我们进入一个循环，不断检查 `num + 1`, `num + 2`, ... 是否存在于 `numSet` 中。
     *    - 我们用一个 `currentLength` 变量来记录当前连续序列的长度。
     *    - 循环结束后，我们用 `currentLength` 来更新全局的最大长度 `maxLength`。
     *
     * 4. **返回结果**:
     *    - 遍历完所有数字后，`maxLength` 中存储的就是最长连续序列的长度。
     *
     * **复杂度分析**:
     * 虽然代码中有嵌套循环，但内层循环（寻找序列长度）只有在遇到序列的起点时才会执行。
     * 每个数字最多被访问两次（一次是外层循环，一次可能是在内层循环中作为连续序列的一部分），
     * 因此总的时间复杂度仍然是 O(n)。
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // 确保我们只从一个序列的起点开始计算
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 计算以 currentNum 为起点的序列长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = solution.longestConsecutive(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1); // 应输出 4

        // 示例 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result2 = solution.longestConsecutive(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // 应输出 9

        // 示例 3
        int[] nums3 = {1, 0, 1, 2};
        int result3 = solution.longestConsecutive(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + result3); // 应输出 3
    }
}
