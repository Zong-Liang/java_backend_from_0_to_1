# [39_组合总和](https://leetcode.cn/problems/combination-sum/)

难度：中等

## 问题描述：

给你一个 **无重复元素** 的整数数组 `candidates` 和一个目标整数 `target` ，找出 `candidates` 中可以使数字和为目标数 `target` 的 所有 **不同组合** ，并以列表形式返回。你可以按 **任意顺序** 返回这些组合。

`candidates` 中的 **同一个** 数字可以 **无限制重复被选取** 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 `target` 的不同组合数少于 `150` 个。

**示例 1：**

```java
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
```

**示例 2：**

```java
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
```

**示例 3：**

```java
输入: candidates = [2], target = 1
输出: []
```

**提示：**`candidates` 的所有元素 **互不相同**

## 解题思路：



## Java代码：

```java
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        // 排序是可选的，但可以提高效率（便于剪枝）
        Arrays.sort(candidates);
        
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                         int[] candidates, int remain, int start) {
        // 找到一个有效组合
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 尝试每个可能的数字
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字已经大于剩余值，后面的数字更大，直接跳出
            if (candidates[i] > remain) {
                break;
            }
            
            // 选择当前数字
            current.add(candidates[i]);
            
            // 递归，注意这里传入i而不是i+1，因为可以重复使用
            backtrack(result, current, candidates, remain - candidates[i], i);
            
            // 撤销选择
            current.remove(current.size() - 1);
        }
    }
}
```

