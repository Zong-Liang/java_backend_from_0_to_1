package com.leetcode.code_13.p_347_topKFrequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 哈希表 + 最小堆 解法
     *
     * 算法思路：
     * 这个问题可以分解为两个主要步骤：
     * 1. 统计数组中每个元素的出现频率。
     * 2. 找出频率最高的 K 个元素。
     *
     * 为了高效地完成这两步，我们结合使用哈希表和最小堆。
     *
     * 1. **统计频率**:
     *    - 我们遍历一次输入数组 `nums`。
     *    - 使用一个哈希表 `frequencyMap` 来存储每个数字及其出现的次数。
     *    - 这一步的时间复杂度是 O(n)。
     *
     * 2. **找出前 K 个高频元素**:
     *    - 我们创建一个大小为 K 的最小堆 (Min-Heap)。堆中的元素按照它们的频率进行排序，频率最低的元素在堆顶。
     *    - 遍历 `frequencyMap` 中的每一个元素（数字）。
     *    - 对于每个数字，我们将其加入最小堆。
     *    - 如果堆的大小超过了 K，我们就将堆顶元素（即当前堆中频率最低的元素）移除。
     *    - 遍历结束后，堆中剩下的 K 个元素就是整个数组中频率最高的 K 个元素。
     *    - 这一步的时间复杂度是 O(m log k)，其中 m 是不同元素的数量。由于 m <= n，所以复杂度为 O(n log k)。
     *
     * 3. **结果**:
     *    - 将最小堆中的元素取出，放入结果数组中即可。
     *
     * 这种方法的总时间复杂度为 O(n log k)，优于题目要求的 O(n log n)。
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 使用哈希表统计每个元素的频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. 创建一个最小堆，用于筛选前 K 个高频元素
        // PriorityQueue 默认是最小堆，我们自定义比较器，使其按频率比较
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        // 遍历哈希表，维护大小为 k 的最小堆
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除堆顶（频率最小的）元素
            }
        }

        // 3. 将堆中的元素存入结果数组
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("输出: " + Arrays.toString(result1)); // 应输出 [1, 2] 或 [2, 1]

        // 示例 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("输出: " + Arrays.toString(result2)); // 应输出 [1]

        // 示例 3
        int[] nums3 = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k3 = 2;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("输出: " + Arrays.toString(result3)); // 应输出 [1, 2] 或 [2, 1]
    }
}
