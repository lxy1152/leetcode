package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/sum-of-square-numbers/">633. 平方数之和</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个非负整数{@code c}, 你要判断是否存在两个整数{@code a}和{@code b}, 使得{@code a^2 + b^2 = c}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code c = 5}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code c = 3}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code c = 4}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code c = 2}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出5:<br>
 * 输入: {@code c = 1}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= c <= 2^{31} - 1</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ633 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个整数
     * @return 是否能表示为另外两个数的平方和
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return judgeSquareSum((int) obj);
        }
        return null;
    }

    /**
     * 判断一个数是否能表示为另外两个数的平方和
     *
     * @param c 一个整数
     * @return 是否能表示为另两个数的平方和
     */
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
