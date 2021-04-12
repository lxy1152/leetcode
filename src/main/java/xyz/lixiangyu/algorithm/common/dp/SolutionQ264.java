package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/ugly-number-ii/">264. 丑数 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数{@code n}, 请你找出并返回第{@code n}个丑数<br>
 * 丑数就是只包含质因数{@code 2, 3, 5}的正整数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code n = 10}<br>
 * 输出: {@code 12}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code n = 1}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= n <= 1690</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ264 extends AbstractSolution {
    /**
     * 取丑数列中的第{@code n}个丑数
     *
     * @param obj 索引
     * @return 该索引位置的丑数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return nthUglyNumber((int) obj);
        }
        return null;
    }

    /**
     * 取丑数列中的第{@code n}个丑数
     *
     * <p>
     * 思路:
     * 动态规划计算丑数列
     * </p>
     *
     * @param n 索引
     * @return 该索引位置的丑数
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
