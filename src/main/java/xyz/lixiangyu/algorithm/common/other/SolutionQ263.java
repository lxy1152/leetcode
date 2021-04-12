package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/ugly-number/">263. 丑数</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数{@code n}, 请你判断{@code n}是否为丑数, 如果是则返回{@code true}, 否则返回{@code false}<br>
 * 丑数就是只包含质因数{@code 2, 3, 5}的正整数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code n = 6}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code n = 8}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code n = 14}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code n = 1}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>-2^31 <= n <= 2^31 - 1</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ263 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数
     * @return 这个数是否是丑数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return isUgly((int) obj);
        }
        return null;
    }

    /**
     * 判断一个数是否是丑数
     *
     * <p>
     * 思路:<br>
     * 由于因数只包含{@code 2, 3, 5}, 所以可以循环除掉因数, 通过判断商是否为{@code 1}, 就可以得到这个数是不是丑数
     * </p>
     *
     * @param n 一个数
     * @return 这个数是否是丑数
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
