package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/permutation-in-string/">567. 字符串的排列</a>
 *
 * <p>
 * 描述:<br>
 * 给定两个字符串{@code s1}和{@code s2}, 写一个函数来判断{@code s2}是否包含{@code s1}的排列<br>
 * 换句话说, 第一个字符串的排列之一是第二个字符串的子串
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s1 = "ab" s2 = "eidbaooo"}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s1= "ab" s2 = "eidboaoo"}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>输入的字符串只包含小写字母</b></li>
 *     <li><b>两个字符串的长度都在[1, 10,000]之间</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ567 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  字符串1
     * @param obj1 字符串2
     * @return 判断s2是否包含s1的排列
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof String) {
            return checkInclusion((String) obj, (String) obj1);
        }
        return null;
    }

    /**
     * 判断{@code s2}是否包含{@code s1}的排列
     *
     * <p>
     * 思路:<br>
     * 滑动窗口
     * </p>
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 判断s2是否包含s1的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        // s1的长度如果比s2还要长, 那肯定不符合题意
        if (s1.length() > s2.length()) {
            return false;
        }
        // 将字符串转为char型数组
        char[] arrayOne = s1.toCharArray();
        char[] arrayTwo = s2.toCharArray();
        // 保存字符串中每个字母出现的次数
        int[] countOne = new int[26];
        int[] countTwo = new int[26];
        // 计算第一个窗口中每个字母出现的次数
        for (int i = 0; i < s1.length(); i++) {
            countOne[arrayOne[i] - 'a']++;
            countTwo[arrayTwo[i] - 'a']++;
        }
        // 如果两个数组相同则直接返回
        if (Arrays.equals(countOne, countTwo)) {
            return true;
        }
        // 窗口右移
        for (int i = s1.length(); i < s2.length(); i++) {
            // 新移入窗口的字母的出现次数+1
            countTwo[arrayTwo[i] - 'a']++;
            // 移出窗口的字母的出现次数-1
            countTwo[arrayTwo[i - s1.length()] - 'a']--;
            // 如果两个数组相同, 则认为符合题意
            if (Arrays.equals(countOne, countTwo)) {
                return true;
            }
        }
        return false;
    }
}
