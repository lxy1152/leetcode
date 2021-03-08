package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-partitioning-ii/">132. 分割回文串 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个字符串{@code s}, 请你将{@code s}分割成一些子串, 使每个子串都是回文, 返回符合这个要求的最少分割次数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "aab"}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "a"}<br>
 * 输出: {@code 0}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code s = "ab"}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 2000</b></li>
 *     <li><b>s仅由小写英文字母组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ132 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个字符串
     * @return 使子串都是回文串的最少分割次数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return minCut((String) obj);
        }
        return null;
    }

    /**
     * 计算最少分割次数
     *
     * <p>
     * 思路:<br>
     * 两次dp:<br>
     * 1. 计算某一部分字串是否是回文的, 参考{@linkplain SolutionQ5 [5. 最长回文子串]}<br>
     * 2. 根据子串的回文性得到状态转移方程
     * </p>
     *
     * @param s 一个字符串
     * @return 使子串都是回文串的最少分割次数
     */
    public int minCut(String s) {
        // 字符串长度
        int n = s.length();

        // 字符串对应的char型数组
        char[] chars = s.toCharArray();

        // 保存从下标i到下标j部分的字串是否是回文串
        boolean[][] isPalindrome = new boolean[n][n];

        // 这一部分的内容见: 5. 最长回文子串
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (chars[i] != chars[j]) {
                    // 如果两头的字符不相等那么一定不是回文串
                    isPalindrome[i][j] = false;
                } else {
                    // 如果两头的字符相等, 需要考虑其中的子串
                    if (j - i < 3) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
            }
        }

        // 状态转移数组, 默认值都给0x3f3f3f3f
        int[] dp = new int[n];
        Arrays.fill(dp, 0x3f3f3f3f);

        // 如果自身就是回文的, 那么分割次数是0
        // 否则需要考虑子串是否是回文的
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
