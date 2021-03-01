package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/counting-bits/">338. 比特位计数</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个非负整数{@code num}, 对于{@code 0 <= i <= num}范围中的每个数字{@code i},
 * 计算其二进制数中的{@code 1}的数目并将它们作为数组返回
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code 2}<br>
 * 输出: {@code [0, 1, 1]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code 5}<br>
 * 输出: {@code [0, 1, 1, 2, 1, 2]}
 * </p>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ338 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 返回0到这个数字之间所有数字的二进制表示中的1的个数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return countBits((int) obj);
        }
        return null;
    }

    /**
     * 计算{@code 1}的个数
     *
     * <p>
     * 思路:<br>
     * 先列举几个十进制数的二进制表示:
     * <pre>
     * 0:   0
     * 1:  01
     * 2:  10
     * 3:  11
     * 4: 100
     * </pre>
     * 可以发现, 对于偶数: {@code bits[i] = bits[i / 2]}, 对于奇数: {@code bits[i] = bits[i / 2] + 1}
     * </p>
     *
     * @param num 一个数组
     * @return 返回0到这个数字之间所有数字的二进制表示中的1的个数
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
