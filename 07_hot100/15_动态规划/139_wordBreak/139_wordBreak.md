# [139_单词拆分](https://leetcode.cn/problems/word-break/)

难度：中等

## 问题描述：

给你一个字符串 `s` 和一个字符串列表 `wordDict` 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 `s` 则返回 `true`。

**注意：**不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

**示例 1：**

```java
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
```

**示例 2：**

```java
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
```

**示例 3：**

```java
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
```

## 解题思路：



## Java代码：

```java
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转换为HashSet，提高查找效率
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i]表示字符串s的前i个字符是否可以被拆分成字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        
        // 初始化：空字符串可以被拆分
        dp[0] = true;
        
        // 动态规划过程
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果前j个字符可以被拆分，且子串s[j...i-1]在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // 找到一种拆分方式即可
                }
            }
        }
        
        return dp[s.length()];
    }
}
```

