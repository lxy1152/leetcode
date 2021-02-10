package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.constants.Constants;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/ransom-note/">383. 赎金信</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个赎金信({@code ransom})字符串和一个杂志({@code magazine})字符串,
 * 判断第一个字符串{@code ransom}能不能由第二个字符串{@code magazine}里面的字符构成<br>
 * 如果可以构成, 返回{@code true}, 否则返回{@code false}<br><br>
 * 为了不暴露赎金信字迹, 要从杂志上搜索各个需要的字母, 组成单词来表达意思<br>
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code ransom = "a", magazine = "b"}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code ransom = "aa", magazine = "ab"}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出3<br>
 * 输入: {@code ransom = "aa", magazine = "aab"}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>你可以假设两个字符串均只含有小写字母</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ383 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 赎金信字符串, 杂志字符串, 需要调用的解决方案
     * @return 能否从杂志字符串中拼出赎金信字符串
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof String
                && objects[1] instanceof String
                && objects[2] instanceof String) {
            if (Constants.FAST_SOLUTION.equals(objects[2])) {
                return canConstructCountRansom((String) objects[0], (String) objects[1]);
            }
            return canConstructCountMagazine((String) objects[0], (String) objects[1]);
        }
        return null;
    }

    /**
     * 能否从杂志字符串中拼出赎金信字符串
     *
     * <p>
     * 思路:<br>
     * 统计赎金信字符串中各字符出现次数, 再比较杂志字符串中个数是否满足条件<br>
     * 但这种写法不好, 请使用{@link #canConstructCountMagazine}
     * </p>
     *
     * @param ransomNote 赎金信字符串
     * @param magazine   杂志字符串
     * @return 能否从杂志字符串中拼出赎金信字符串
     */
    public boolean canConstructCountRansom(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) {
            return true;
        }
        int[] count = new int[26];
        int[] empty = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            int number = c - 'a';
            if (count[number] > 0) {
                count[number]--;
            }
            if (Arrays.equals(count, empty)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 能否从杂志字符串中拼出赎金信字符串
     *
     * <p>
     * 思路:<br>
     * 统计杂志字符串中各字符出现次数, 再比较赎金信字符串中个数是否满足条件
     * </p>
     *
     * @param ransomNote 赎金信字符串
     * @param magazine   杂志字符串
     * @return 能否从杂志字符串中拼出赎金信字符串
     */
    public boolean canConstructCountMagazine(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
