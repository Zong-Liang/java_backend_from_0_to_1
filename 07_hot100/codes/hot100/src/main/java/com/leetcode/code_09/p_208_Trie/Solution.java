package com.leetcode.code_09.p_208_Trie;

/**
 * TrieNode (字典树节点) 类
 * 这是构成 Trie 的基本单元。
 */
class TrieNode {
    // children 数组存储指向子节点的链接。
    // 因为题目说明只包含小写字母，所以数组大小为 26。
    private TrieNode[] children;
    // isEndOfWord 标记表示当前节点是否是一个完整单词的结尾。
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEnd() {
        isEndOfWord = true;
    }

    public boolean isEnd() {
        return isEndOfWord;
    }
}

/**
 * Trie (前缀树) 类
 * 这是本题要求实现的核心数据结构。
 */
class Trie {
    private TrieNode root;

    /** 初始化前缀树对象 */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 向前缀树中插入一个单词
     * 算法思路：
     * 1. 从根节点开始，遍历单词的每一个字符。
     * 2. 对于每个字符，检查当前节点的子节点中是否存在对应的链接。
     * 3. 如果不存在，就创建一个新的 TrieNode 作为子节点。
     * 4. 移动到子节点，继续处理下一个字符。
     * 5. 单词的所有字符都处理完毕后，将最后一个节点的 `isEndOfWord` 标记为 true。
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * 搜索一个单词是否在前缀树中
     * 算法思路：
     * 1. 从根节点开始，遍历单词的每一个字符。
     * 2. 对于每个字符，检查当前节点的子节点中是否存在对应的链接。
     * 3. 如果在任何时候链接不存在，说明单词不在树中，返回 false。
     * 4. 如果单词的所有字符都能在树中找到对应的路径，最后检查最后一个节点的 `isEndOfWord` 标记。
     * 5. 只有当该标记为 true 时，才表示这个确切的单词被插入过。
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    /**
     * 检查是否存在以给定前缀开头的单词
     * 算法思路：
     * 1. 这个过程与 search 方法非常相似。
     * 2. 从根节点开始，遍历前缀的每一个字符。
     * 3. 如果在任何时候链接不存在，说明没有以该前缀开头的单词，返回 false。
     * 4. 如果前缀的所有字符都能在树中找到对应的路径，说明至少有一个单词是以这个前缀开头的，返回 true。
     *    (我们不需要检查最后一个节点的 `isEndOfWord` 标记)。
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}

// 这是为了匹配题目要求的格式而创建的测试类
public class Solution {
    // 算法的核心实现在上面的 Trie 类中。
    // main 方法用于演示 Trie 类的使用，并模拟示例输入/输出。
    public static void main(String[] args) {
        System.out.println("示例:");

        Trie trie = new Trie();
        System.out.println("Trie trie = new Trie();");

        trie.insert("apple");
        System.out.println("trie.insert(\"apple\");");

        boolean search1 = trie.search("apple");
        System.out.println("trie.search(\"apple\");   // 返回 " + search1); // 应返回 True

        boolean search2 = trie.search("app");
        System.out.println("trie.search(\"app\");     // 返回 " + search2); // 应返回 False

        boolean startsWith1 = trie.startsWith("app");
        System.out.println("trie.startsWith(\"app\"); // 返回 " + startsWith1); // 应返回 True

        trie.insert("app");
        System.out.println("trie.insert(\"app\");");

        boolean search3 = trie.search("app");
        System.out.println("trie.search(\"app\");     // 返回 " + search3); // 应返回 True
    }
}
