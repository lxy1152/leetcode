package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个字符串{@code s}, 找到{@code s}中最长的回文子串
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "babad"}<br>
 * 输出: {@code "bab"}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "cbbd"}<br>
 * 输出: {@code "bb"}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code s = "a"}<br>
 * 输出: {@code "a"}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code s = "ac"}<br>
 * 输出: {@code "a"}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 1000</b></li>
 *     <li><b>{@code s}仅由数字和英文字母(大写和/或小写)组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ5 extends AbstractSolution {
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return longestPalindrome((String) obj);
        }
        return null;
    }

    /**
     * 计算一个字符串中的最大回文子串
     *
     * <p>
     * 思路:<br>
     * 如果一个字符串只有一个字符, 那么它一定是回文的; 如果一个字符串只有两个字符,
     * 并且这两个相等, 那么它也是回文的<br>
     * 对于长度大于{@code 2}的字符串, 如果头尾两个字符是相等的, 并且排除头尾的字符串是回文的,
     * 那么这个字符串一定是回文的<br>
     * 不妨假设一个区间{@code [i, j]}, {@code dp(i, j)}表示区间{@code [i, j]}上的字符串
     * 是否是回文串, {@code dp}的表达式可以写成:<br>
     * <ol>
     *     <li>长度为1, 一定是回文的: dp(i, i) = true</li>
     *     <li>长度为2, 需要判断两个字符是否相等: dp(i, j) = s.charAt(i) == s.charAt(j)</li>
     *     <li>长度大于2, 并且头尾两字符相等: dp(i, j) = dp(i + 1, j - 1)</li>
     *     <li>其他情况: dp(i, j) = false</li>
     * </ol>
     *
     * 以{@code s = "babad"}字符串为例, 下方代码的逻辑就是填表的过程<br>
     * 注意:
     * <ul>
     *     <li>{@code i}是行, 表示区间左端点; j是列, 表示区间右端点<br></li>
     *     <li>因为{@code i <= j}, 所以只填充一半的区域就可以了</li>
     * </ul>
     *
     * <pre>
     *   i\j  |  0    1    2    3    4
     * ---------------------------------
     *    0   |  T    F    T    F    F
     *    1   |       T    F    T    F
     *    2   |            T    F    F
     *    3   |                 T    F
     *    4   |                      T
     * </pre>
     * </p>
     *
     * @param s 一个字符串
     * @return 最大回文子串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 如果长度是0或者1, 直接返回该字符串
        if (len < 2) {
            return s;
        }
        // 默认给1, 保证在没有取到回文子串的情况下, 返回第一个字符
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i, j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        // 应该以列为单位开始填充, 因为填充时参考的dp[i + 1][j - 1]是左下方的格
        // 如果以行为单位, 左下方的格可能还没有填充
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    // 如果处于对角线上, 因为长度为1, 所以一定是回文的
                    dp[i][j] = true;
                } else if (charArray[i] != charArray[j]) {
                    // 如果两头的字符不相等那么一定不是回文串
                    dp[i][j] = false;
                } else {
                    // 如果两头的字符相等, 需要考虑其中的子串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true成立，就表示子串s[i, j]是回文, 此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
