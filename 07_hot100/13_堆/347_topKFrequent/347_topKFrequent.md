# [347_前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)

难度：中等

## 问题描述：

给你一个整数数组 `nums` 和一个整数 `k` ，请你返回其中出现频率前 `k` 高的元素。你可以按 **任意顺序** 返回答案。

**示例 1:**

```java
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```

**示例 2:**

```java
输入: nums = [1], k = 1
输出: [1]
```

**提示：**

- `k` 的取值范围是 `[1, 数组中不相同的元素的个数]`
- 题目数据保证答案唯一，换句话说，数组中前 `k` 个高频元素的集合是唯一的

## 解题思路：



## Java代码：

```java
import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 创建小顶堆，按频率排序
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> 
            frequencyMap.get(a) - frequencyMap.get(b)
        );
        
        // 遍历频率表，维护大小为k的小顶堆
        for (int num : frequencyMap.keySet()) {
            heap.offer(num);
            // 如果堆的大小超过k，则移除堆顶元素（频率最小的元素）
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        // 构建结果数组
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        
        return result;
    }
}
```

