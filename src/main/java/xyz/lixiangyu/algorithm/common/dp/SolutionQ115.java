package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/distinct-subsequences/">115. 不同的子序列</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个字符串{@code s}和一个字符串{@code t}, 计算在{@code s}的子序列中{@code t}出现的个数<br>
 * 字符串的一个子序列是指, 通过删除一些(也可以不删除)字符且不干扰剩余字符相对位置所组成的新字符串<br>
 * 例如: {@code "ACE"}是{@code "ABCDE"}的一个子序列, 而{@code "AEC"}<br>
 * 题目数据保证答案符合{@code 32}位带符号整数范围
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "rabbbit", t = "rabbit"}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "babgbag", t = "bag"}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= s.length, t.length <= 1000</b></li>
 *     <li><b>s 和 t 由英文字母组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ115 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  第一个字符串
     * @param obj1 第二个字符串
     * @return 在第一个字符串的子序列中第二个字符串出现的次数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof String) {
            return numDistinct((String) obj, (String) obj1);
        }
        return null;
    }

    /**
     * 在第一个字符串的子序列中第二个字符串出现的次数
     *
     * <p>
     * 思路:<br>
     * 使用一个二维{@code dp}数组表示字符串{@code s}的前{@code i}个字符中, 字符串{@code t}的前{@code j}个字符
     * 出现的次数<br>
     * 如果:<br>
     * 1. {@code s}新添加的字符和{@code t}当前的最后一个字符不相等, 那么{@code dp[i][j] = dp[i - 1][j]}<br>
     * 2. 如果相等, 那么{@code dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]}, {@code dp[i - 1][j - 1]}不难理解,
     *    但是还需要考虑{@code dp[i - 1][j]}是因为可能存在{@code s[i] = s[i - 1]}的情况, 对于子序列来说当然可以采用
     *    {@code s[i - 1]}而不采用{@code s[i]}<br>
     * 下面是一个例子, 上述的过程可以理解为填表, 最后一个格就是上面所说的特殊情况:
     * <pre>
     *       b  a  g
     *    1  0  0  0
     * b  1  1  0  0
     * a  1  1  1  0
     * e  1  1  1  0
     * g  1  1  1  1
     * g  1  1  1  2
     * </pre>
     * </p>
     *
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 在第一个字符串的子序列中第二个字符串出现的次数
     */
    public int numDistinct(String s, String t) {
        // 两字符串的长度
        int m = s.length();
        int n = t.length();

        // 如果s的长度比t的长度短, 是一定不满足题意的, 直接返回0
        if (m < n) {
            return 0;
        }

        // 初始化dp数组
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 开始填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
