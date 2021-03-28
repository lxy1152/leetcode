package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-bits/">190. 颠倒二进制位</a>
 *
 * <p>
 * 描述:<br>
 * 颠倒给定的{@code 32}位无符号整数的二进制位
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code 00000010100101000001111010011100}<br>
 * 输出: {@code 00111001011110000010100101000000}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code 11111111111111111111111111111101}<br>
 * 输出: {@code 10111111111111111111111111111111}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>
 *         请注意, 在某些语言(如Java)中, 没有无符号整数类型. 在这种情况下, 输入和输出都将被指定为有符号整数类型, 并且不应影响您的实现,
 *         因为无论整数是有符号的还是无符号的, 其内部的二进制表示形式都是相同的
 *     </li>
 *     <li>
 *         在Java中, 编译器使用二进制补码记法来表示有符号整数. 因此在上面的示例2中, 输入表示有符号整数{@code -3},
 *         输出表示有符号整数{@code -1073741825}
 *     </li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ190 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个无符号整数
     * @return 颠倒二进制位后的整数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return reverseBits((int) obj);
        }
        return null;
    }

    /**
     * 颠倒给定的{@code 32}位无符号整数的二进制位
     *
     * <p>
     * 思路:<br>
     * 使用位运算
     * </p>
     *
     * @param n 一个无符号整数
     * @return 颠倒二进制位后的整数
     */
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>= 1;
        }

        return result;
    }
}
