package com.leetcode.code_02.p_283_moveZeroes;

import java.util.Arrays;

public class Solution {

    /**
     * 双指针解法 (一次遍历优化)
     *
     * 算法思路：
     * 我们可以将问题看作是将所有非零元素“压缩”到数组的前面，然后将剩余的位置填充为零。
     *
     * 1. **快慢指针**:
     *    - 我们使用一个“慢指针” `slow`，它指向下一个应该被非零元素填充的位置。
     *    - 我们使用一个“快指针” `fast`，它负责遍历整个数组，寻找非零元素。
     *
     * 2. **遍历与填充**:
     *    - `slow` 初始为 0，`fast` 从 0 开始遍历数组。
     *    - 当 `fast` 指针遇到一个非零元素 `nums[fast]` 时：
     *      a. 我们将这个非零元素放到 `slow` 指针所在的位置：`nums[slow] = nums[fast]`。
     *      b. 然后，将 `slow` 指针向后移动一位：`slow++`。
     *    - 如果 `fast` 遇到的是零，`slow` 指针保持不动，`fast` 继续前进。
     *    - 这样，`slow` 指针就有效地将所有遇到的非零元素按原顺序紧凑地排列在了数组的开头。
     *
     * 3. **填充末尾的零**:
     *    - 当 `fast` 指针遍历完整个数组后，`slow` 指针停留的位置就是非零元素序列的末尾。
     *    - 此时，从 `slow` 到数组末尾的所有位置都应该被填充为 0。
     *    - 我们用一个循环将 `nums[slow]` 到 `nums[n-1]` 的所有元素都设置为 0。
     *
     * **优化**:
     * 在第一遍遍历中，当 `fast` 遇到非零元素时，如果 `slow` 和 `fast` 不在同一个位置，
     * 我们可以进行交换 `swap(nums, slow, fast)`，而不是简单的赋值。
     * 但更优化的写法是，先完成所有非零元素的移动，再一次性地填充后面的零，这样写操作的总数最少。
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0; // 指向下一个非零元素应存放的位置

        // 第一次遍历：将所有非零元素移动到数组前面
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 第二次遍历：将 slow 之后的所有位置填充为 0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.toString(nums1));
        solution.moveZeroes(nums1);
        System.out.println("输出: " + Arrays.toString(nums1)); // 应输出: [1, 3, 12, 0, 0]

        // 示例 2
        int[] nums2 = {0};
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("输出: " + Arrays.toString(nums2)); // 应输出: [0]
    }
}
