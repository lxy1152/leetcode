package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/decode-ways/">91. 解码方法</a>
 *
 * <p>
 * 描述:<br>
 * 一条包含字母{@code A-Z}的消息通过以下映射进行了编码:<br>
 * {@code 'A' -> 1}<br>
 * {@code 'B' -> 2}<br>
 * ...<br>
 * {@code 'Z' -> 26}<br>
 *
 * 要解码已编码的消息, 所有数字必须基于上述映射的方法, 反向映射回字母(可能有多种方法), 例如{@code "11106"}可以映射为:<br>
 * 1. {@code "AAJF"}: 将消息分组为(1 1 10 6)<br>
 * 2. {@code "KJF"}: 将消息分组为(11 10 6)<br>
 *
 * 注意, 消息不能分组为{@code (1 11 06)}, 因为{@code "06"}不能映射为{@code "F"}, 这是由于{@code "6"}和{@code "06"}在映射中并不等价<br>
 *
 * 给你一个只含数字的非空字符串{@code s}, 请计算并返回解码方法的总数<br>
 *
 * 题目数据保证答案肯定是一个32位的整数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "12"}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "226"}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code s = "0"}<br>
 * 输出: {@code "0"}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code s = "06"}<br>
 * 输出: {@code "0"}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 100</b></li>
 *     <li><b>s 只包含数字，并且可能包含前导零</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ91 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个编码后的非空字符串
     * @return 编码方式
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return numDecodings((String) obj);
        }
        return null;
    }

    /**
     * 根据给定的编码字符串计算编码方式共有多少种
     *
     * <p>
     * 思路:<br>
     * 动态规划, 取一位的时候看{@code dp[i - 1]}, 取两位的时候看{@code dp[i - 2]}
     * </p>
     *
     * @param s 一个编码后的非空字符串
     * @return 编码方式
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
