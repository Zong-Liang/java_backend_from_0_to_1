package com.leetcode.code_14.p_121_maxProfit;

import java.util.Arrays;

public class Solution {
    /**
     * 一次遍历 (贪心) 解法
     *
     * 算法思路：
     * 我们的目标是找到一个历史最低点买入，并在之后的一个最高点卖出，以获得最大利润。
     * 这个过程可以通过一次遍历来完成。
     *
     * 1. 维护两个变量：
     *    - `minPrice`: 记录到目前为止所遇到的最低股价。
     *    - `maxProfit`: 记录到目前为止所能获得的最大利润。
     *
     * 2. 遍历股价数组：
     *    - 从第一天开始，我们遍历整个价格数组。
     *    - 对于当天的价格 `price`：
     *      a) 如果 `price` 比我们记录的 `minPrice` 还要低，那么我们就找到了一个更好的买入时机。
     *         更新 `minPrice = price`。
     *      b) 如果 `price` 不低于 `minPrice`，我们就计算在今天卖出能获得的利润 `price - minPrice`。
     *         然后，我们将这个利润与我们已经记录的 `maxProfit` 进行比较，并保留较大的那个作为新的 `maxProfit`。
     *
     * 3. 初始化：
     *    - `minPrice` 初始化为一个非常大的数 (如 `Integer.MAX_VALUE`)，以确保第一天的价格会成为初始的最低价。
     *    - `maxProfit` 初始化为 0，因为如果没有交易，利润就是 0。
     *
     * 4. 结果：
     *    遍历结束后，`maxProfit` 中存储的就是整个时间段内的最大利润。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // 检查是否是更低的买入价格
            if (price < minPrice) {
                minPrice = price;
            } else {
                // 否则，计算在今天卖出的利润，并更新最大利润
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.toString(prices1));
        System.out.println("输出: " + result1); // 应输出 5

        // 示例 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(prices2);
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.toString(prices2));
        System.out.println("输出: " + result2); // 应输出 0
    }
}
