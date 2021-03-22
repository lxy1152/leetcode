package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-1-bits/">191. 位1的个数</a>
 *
 * <p>
 * 描述:<br>
 * 编写一个函数, 输入是一个无符号整数(以二进制串的形式), 返回其二进制表达式中数字{@code 1}的个数(也被称为汉明重量)
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code 00000000000000000000000000001011}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code 00000000000000000000000010000000}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code 11111111111111111111111111111101}<br>
 * 输出: {@code 31}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>输入必须是长度为 32 的 二进制串</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ191 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个32位的二进制数字
     * @return 这个二进制数字中1的个数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return hammingWeight((int) obj);
        }
        return null;
    }

    /**
     * 计算一个二进制数字中1的个数
     *
     * <p>
     * 思路:<br>
     * {@code n & (n - 1)}表示去掉{@code n}的最低位的{@code 1}, 统计一下这个操作的次数就是二进制数中{@code 1}的个数
     * </p>
     *
     * @param n 一个32位的二进制数字
     * @return 这个二进制数字中1的个数
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= (n - 1);
            result++;
        }
        return result;
    }
}
