# [46_全排列](https://leetcode.cn/problems/permutations/)

难度：中等

## 问题描述：

给定一个不含重复数字的数组 `nums` ，返回其 *所有可能的全排列* 。你可以 **按任意顺序** 返回答案。

**示例 1：**

```
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**示例 2：**

```
输入：nums = [0,1]
输出：[[0,1],[1,0]]
```

**示例 3：**

```
输入：nums = [1]
输出：[[1]]
```

**提示：**`nums` 中的所有整数 **互不相同**

## 解题思路：



## Java代码：

```java
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 将数组转换为List，方便操作
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        permuteHelper(result, numList, 0);
        return result;
    }
    
    private void permuteHelper(List<List<Integer>> result, List<Integer> nums, int start) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i = start; i < nums.size(); i++) {
            // 交换元素
            Collections.swap(nums, start, i);
            // 递归处理剩余元素
            permuteHelper(result, nums, start + 1);
            // 恢复原状
            Collections.swap(nums, start, i);
        }
    }
}
```

