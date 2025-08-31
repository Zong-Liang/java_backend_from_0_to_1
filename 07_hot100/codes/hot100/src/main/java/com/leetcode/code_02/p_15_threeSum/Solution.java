package com.leetcode.code_02.p_15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 排序 + 双指针解法
     *
     * 算法思路：
     * 暴力解法是使用三层循环，时间复杂度为 O(n^3)，会超时。
     * 我们可以通过固定一个数，然后在其右侧的数组中寻找另外两个数，将问题从“三数之和”降维为“两数之和”。
     *
     * 1. **排序**:
     *    - 首先，对整个数组进行升序排序。排序的好处有两个：
     *      a. 方便我们使用双指针法快速查找。
     *      b. 方便我们跳过重复的元素，避免产生重复的三元组结果。
     *
     * 2. **主循环 (固定第一个数)**:
     *    - 我们用一个 `for` 循环遍历数组，将 `nums[i]` 作为我们三元组中的第一个固定的数。
     *    - **剪枝**: 如果 `nums[i]` 大于 0，由于数组已排序，后面的数都将大于 0，它们的和不可能为 0，所以可以直接中断循环。
     *    - **去重**: 如果 `i > 0` 并且 `nums[i] == nums[i-1]`，说明这个数我们已经作为“第一个数”处理过了，
     *      为了避免重复，直接 `continue` 到下一次循环。
     *
     * 3. **双指针查找 (两数之和)**:
     *    - 对于每一个固定的 `nums[i]`，我们在它右侧的子数组 `[i+1, n-1]` 中寻找两个数，
     *      使得它们的和等于 `target = -nums[i]`。
     *    - 我们设置左指针 `left = i + 1` 和右指针 `right = n - 1`。
     *    - 当 `left < right` 时，循环继续：
     *      a. 计算 `sum = nums[left] + nums[right]`。
     *      b. **如果 `sum == target`**:
     *         - 我们找到了一个有效的三元组 `(nums[i], nums[left], nums[right])`，将其加入结果列表。
     *         - **关键去重**: 为了避免 `(1, -1, 0)` 和 `(1, -1, 0)` 这样的重复（如果数组中有重复元素），
     *           我们需要移动 `left` 和 `right` 指针，并跳过所有与当前 `nums[left]` 和 `nums[right]` 相等的元素。
     *      c. **如果 `sum < target`**: 说明和太小了，我们需要一个更大的数，所以将左指针 `left` 右移。
     *      d. **如果 `sum > target`**: 说明和太大了，我们需要一个更小的数，所以将右指针 `right` 左移。
     *
     * 4. **返回结果**:
     *    - 遍历结束后，返回包含所有不重复三元组的结果列表。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 1. 排序
        Arrays.sort(nums);

        // 2. 主循环
        for (int i = 0; i < nums.length - 2; i++) {
            // 剪枝
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3. 双指针查找
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 关键去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else { // sum > target
                    right--;
                }
            }
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1); // 应输出: [[-1, -1, 2], [-1, 0, 1]]

        // 示例 2
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // 应输出: []

        // 示例 3
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> result3 = solution.threeSum(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + result3); // 应输出: [[0, 0, 0]]
    }
}
