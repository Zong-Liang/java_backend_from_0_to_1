# [169_多数元素](https://leetcode.cn/problems/majority-element/)

难度：简单

## 问题描述：

给定一个大小为 `n` 的数组 `nums` ，返回其中的多数元素。多数元素是指在数组中出现次数 **大于** `⌊ n/2 ⌋` 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1：**

```java
输入：nums = [3,2,3]
输出：3
```

**示例 2：**

```java
输入：nums = [2,2,1,1,1,2,2]
输出：2
```

**进阶：**尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

## 解题思路：



## Java代码：

```java
class Solution {
    public int majorityElement(int[] nums) {
        // 实现Boyer-Moore投票算法
        int candidate = 0;
        int count = 0;
        
        // 找候选元素
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        // 由于题目保证存在多数元素，所以无需验证候选元素是否真的是多数元素
        // 如果不保证存在，则需要再次遍历数组验证
        return candidate;
    }
    
    // 扩展版本：如果不保证存在多数元素，需要验证
    public int majorityElementWithVerification(int[] nums) {
        int candidate = findCandidate(nums);
        
        // 验证候选元素是否真的是多数元素
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        
        return count > nums.length / 2 ? candidate : -1; // 返回-1表示不存在多数元素
    }
    
    private int findCandidate(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

// 测试代码
public class MajorityElementTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例1: [3,2,3]
        int[] nums1 = {3, 2, 3};
        System.out.println("测试用例1的多数元素: " + solution.majorityElement(nums1));
        
        // 测试用例2: [2,2,1,1,1,2,2]
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("测试用例2的多数元素: " + solution.majorityElement(nums2));
    }
}
```

