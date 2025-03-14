# [208_实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/)

难度：中等

## 问题描述：

**[Trie](https://baike.baidu.com/item/字典树/9825209?fr=aladdin)**（发音类似 "try"）或者说 **前缀树** 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。

请你实现 Trie 类：

- `Trie()` 初始化前缀树对象。
- `void insert(String word)` 向前缀树中插入字符串 `word` 。
- `boolean search(String word)` 如果字符串 `word` 在前缀树中，返回 `true`（即，在检索之前已经插入）；否则，返回 `false` 。
- `boolean startsWith(String prefix)` 如果之前已经插入的字符串 `word` 的前缀之一为 `prefix` ，返回 `true` ；否则，返回 `false` 。

**示例：**

```java
输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
```

## 解题思路：



## Java代码：

```java
class Trie {
    // 定义TrieNode类表示Trie树的节点
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        
        public TrieNode() {
            // 假设只处理小写英文字母，所以每个节点最多有26个子节点
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode root;
    
    /** 初始化前缀树对象 */
    public Trie() {
        root = new TrieNode();
    }
    
    /** 向前缀树中插入字符串 word */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            // 如果该字符对应的子节点不存在，则创建
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            
            // 移动到子节点
            node = node.children[index];
        }
        
        // 标记单词结束
        node.isEnd = true;
    }
    
    /** 查找字符串 word 是否在前缀树中 */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // 找到了匹配的前缀，且该节点被标记为单词结束
        return node != null && node.isEnd;
    }
    
    /** 查找是否有以 prefix 为前缀的单词 */
    public boolean startsWith(String prefix) {
        // 只要找到匹配的前缀即可，不关心是否是完整单词
        return searchPrefix(prefix) != null;
    }
    
    // 辅助方法：查找给定前缀的最后一个字符对应的节点
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            
            // 如果该字符对应的子节点不存在，说明没有该前缀
            if (node.children[index] == null) {
                return null;
            }
            
            // 移动到子节点
            node = node.children[index];
        }
        
        return node;
    }
}

// 测试代码
public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 True
        System.out.println(trie.search("app"));    // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 True
    }
}
```

