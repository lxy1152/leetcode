package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">1143. 最长公共子序列</a>
 *
 * <p>
 * 描述:<br>
 * 给定两个字符串{@code text1}和{@code text2}, 返回这两个字符串的最长公共子序列的长度, 如果不存在公共子序列, 返回{@code 0}<br>
 * 一个字符串的子序列是指这样一个新的字符串: 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符(也可以不删除任何字符)后组成的新字符串<br>
 * 例如, {@code "ace"}是{@code "abcde"}的子序列, 但{@code "aec"}不是{@code "abcde"}的子序列<br>
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code text1 = "abcde", text2 = "ace"}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code text1 = "abc", text2 = "abc"}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code text1 = "abc", text2 = "def"}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= text1.length, text2.length <= 1000</b></li>
 *     <li><b>text1 和 text2 仅由小写英文字符组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1143 extends AbstractSolution {
    /**
     * 计算两个字符串的最大公共子序列
     *
     * @param obj  字符串1
     * @param obj1 字符串2
     * @return 子序列的最大长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof String) {
            return longestCommonSubsequence((String) obj, (String) obj1);
        }
        return null;
    }

    /**
     * 计算两个字符串的最大公共子序列
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 子序列的最大长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
