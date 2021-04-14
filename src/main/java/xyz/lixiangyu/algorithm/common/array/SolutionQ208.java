package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">208. 实现 Trie (前缀树)</a>
 *
 * <p>
 * 描述:<br>
 * Trie(发音类似 "try")或者说前缀树是一种树形数据结构, 用于高效地存储和检索字符串数据集中的键<br>
 * 这一数据结构有相当多的应用情景, 例如自动补完和拼写检查
 *
 * 请你实现{@link Trie}类:<br>
 * 1. {@link Trie#Trie()}用于初始化前缀树对象<br>
 * 2. {@link Trie#insert(String)}向前缀树中插入字符串{@code word}<br>
 * 3. {@link Trie#search(String)}如果字符串{@code word}在前缀树中, 返回{@code true}(表示在检索之前已经插入), 否则返回{@code false}<br>
 * 4. {@link Trie#startsWith(String)}如果之前已经插入的字符串{@code word}的前缀之一为{@code prefix}, 返回{@code true}, 否则返回{@code false}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入:
 * {@code
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]}<br>
 * 输出: {@code [null, null, true, false, true, null, true]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>1 <= word.length, prefix.length <= 2000</li>
 *     <li>word 和 prefix 仅由小写英文字母组成</li>
 *     <li>insert, search 和 startsWith 调用次数总计不超过 3 * 10^4 次</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ208 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @return 返回一个字典树
     */
    @Override
    public Object solve() {
        return new Trie();
    }
}

/**
 * 本题所使用的数据结构
 */
class Trie {
    /**
     * 保存子节点
     */
    private Trie[] children;

    /**
     * 表示一个单词是否结束
     */
    private boolean isEnd;

    /**
     * 默认构造器
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 向字典树中插入一个字符串
     *
     * @param word 一个字符串
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * 在字典树中查找某个字符串
     *
     * @param word 要查找的字符串
     * @return 这个字符串是否存在
     */
    public boolean search(String word) {
        return search(word, false);
    }

    /**
     * 在字典树中查找某个字符串前缀
     *
     * @param prefix 要查找的前缀
     * @return 这个前缀是否存在
     */
    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }

    /**
     * 在字典树中查找某个字符串, 根据参数{@code isPrefix}可以判断是否是前缀
     *
     * @param word     要查找的字符串
     * @param isPrefix 是否是前缀查询
     * @return 是否查找到这个字符串
     */
    private boolean search(String word, boolean isPrefix) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return isPrefix || node.isEnd;
    }
}