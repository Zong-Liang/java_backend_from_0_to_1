package com.leetcode.code_04.p_560_subarraySum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 前缀和 + 哈希表优化解法
     *
     * 算法思路：
     * 暴力解法是枚举所有的连续子数组并计算它们的和，时间复杂度为 O(n^2)，会超时。
     * 我们可以通过“前缀和”的思想来优化。
     *
     * 1. **前缀和**:
     *    - 定义 `prefixSum[i]` 为 `nums[0...i-1]` 的元素之和。
     *    - 那么，任意一个连续子数组 `nums[i...j]` 的和就可以表示为 `prefixSum[j+1] - prefixSum[i]`。
     *
     * 2. **问题转换**:
     *    - 我们需要找到满足 `sum(nums[i...j]) == k` 的 `(i, j)` 对的数量。
     *    - 这等价于找到满足 `prefixSum[j+1] - prefixSum[i] == k` 的 `(i, j)` 对的数量。
     *    - 对公式进行变形，得到：`prefixSum[i] = prefixSum[j+1] - k`。
     *
     * 3. **哈希表优化**:
     *    - 当我们从左到右遍历数组，并计算当前的前缀和 `currentSum` (相当于 `prefixSum[j+1]`) 时，
     *      我们需要知道在它之前，有多少个 `prefixSum[i]` 满足 `prefixSum[i] = currentSum - k`。
     *    - 这正是哈希表擅长的场景。我们可以使用一个哈希表 `prefixSumCount` 来存储：
     *      - `key`: 出现过的前缀和的值。
     *      - `value`: 该前缀和出现的次数。
     *
     * 4. **算法流程**:
     *    a. 初始化一个哈希表 `prefixSumCount`，并放入 `(0, 1)`。
     *       这表示和为 0 的前缀和（即在遍历开始前）出现过 1 次。这个初始值是为了正确处理那些从索引 0 开始就满足条件的子数组。
     *    b. 初始化 `count = 0` 和 `currentSum = 0`。
     *    c. 遍历数组 `nums` 中的每个数字 `num`：
     *       i. 更新当前前缀和：`currentSum += num`。
     *       ii. 在哈希表中查找 `key = currentSum - k`。如果存在，说明找到了若干个以当前元素结尾的有效子数组，
     *           将其对应的 `value` (出现次数) 累加到 `count` 中。
     *       iii. 将当前的 `currentSum` 更新到哈希表中，使其出现次数加 1。
     *    d. 遍历结束后，`count` 就是最终的结果。
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // Key: 前缀和, Value: 该前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // 初始化：和为 0 的前缀和出现 1 次（空数组）
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // 查找是否存在 currentSum - k 的前缀和
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // 将当前前缀和存入哈希表
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = solution.subarraySum(nums1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("输出: " + result1); // 应输出 2

        // 示例 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        int result2 = solution.subarraySum(nums2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("输出: " + result2); // 应输出 2
    }
}
