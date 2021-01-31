package xyz.lixiangyu.algorithm.interview;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-permutation-lcci/">面试题 01.04. 回文排列</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个字符串, 编写一个函数判定其是否为某个回文串的排列之一<br>
 * 回文串是指正反两个方向都一样的单词或短语, 排列是指字母的重新排列<br>
 *
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code "tactcoa"}<br>
 * 输出: {@code true}(排列有{@code "tacocat", "atcocta"}等)
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>回文串不一定是字典当中的单词</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class Solution0104 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param s 一个字符串
     * @return 是否是回文串
     */
    @Override
    public Object solve(Object s) {
        if (s instanceof String) {
            return canPermutePalindrome((String) s);
        } else {
            return null;
        }
    }

    /**
     * 判断是否是回文串
     *
     * <p>
     * 思路:<br>
     * 回文串的总长度如果是偶数, 那么其中的字符必定是两两相等; 如果是奇数, 除了最中间的字符以外也是两两相等<br>
     * 那么就可以通过{@link HashSet}来保存字符, 如果有一样的就删除<br>
     * 这样在遍历完一遍后:
     * <ul>
     *     <li>如果长度是偶数并且{@link HashSet}的大小是0, 则是回文串</li>
     *     <li>如果长度是奇数并且{@link HashSet}的大小是1, 则是回文串</li>
     * </ul>
     * </p>
     *
     * @param s 一个字符串
     * @return 是否是回文串
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> characters = new HashSet<>(10);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                characters.remove(c);
            } else {
                characters.add(c);
            }
        }
        return (s.length() % 2 == 0 && characters.size() == 0) || (s.length() % 2 != 0 && characters.size() == 1);
    }
}
