# [152_乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/)

难度：中等

## 问题描述：

给你一个整数数组 `nums` ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 **32-位** 整数。

**示例 1:**

```java
输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
```

**示例 2:**

```java
输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
```

**提示：**`nums` 的任何子数组的乘积都 **保证** 是一个 **32-位** 整数



## 解题思路：



## Java代码：

```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化最大乘积和最小乘积为第一个元素
        int maxProduct = nums[0];
        int minProduct = nums[0];

        // 初始化结果为第一个元素
        int result = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素是负数，交换最大乘积和最小乘积
            // 因为负数会使最大变最小，最小变最大
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // 更新最大乘积和最小乘积
            // 注意这里的比较：要么从当前元素重新开始，要么继续之前的乘积
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // 更新结果
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
```

