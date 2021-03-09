package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.constants.Constants;
import xyz.lixiangyu.template.algorithm.DynamicProgramming;

/**
 * <a href="https://leetcode-cn.com/problems/coin-change-2/">518. 零钱兑换 II</a>
 *
 * <p>
 * 描述:<br>
 * 给定不同面额的硬币和一个总金额, 写出函数来计算可以凑成总金额的硬币组合数, 假设每一种面额的硬币有无限个
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code amount = 5, coins = [1, 2, 5]}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code amount = 3, coins = [2]}<br>
 * 输出: {@code 0}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code amount = 10, coins = [10]}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= amount (总金额) <= 5000</b></li>
 *     <li><b>1 <= coin (硬币面额) <= 5000</b></li>
 *     <li><b>硬币种类不超过 500 种</b></li>
 *     <li><b>结果符合 32 位符号整数</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ518 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 总金额, 硬币种类, 解决方案类型
     * @return 总组合方式的数量
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof Integer && objects[1] instanceof int[] && objects[2] instanceof String) {
            if (Constants.COMMON_SOLUTION.equals(objects[2])) {
                return change((int) objects[0], (int[]) objects[1]);
            } else {
                return changeFast((int) objects[0], (int[]) objects[1]);
            }
        }
        return null;
    }

    /**
     * 不进行状态压缩, 思路见{@link DynamicProgramming#knapsackComplete(int, int[])}
     *
     * @param amount 总金额
     * @param coins 硬币种类
     * @return 解决方案类型
     */
    public int change(int amount, int[] coins) {
        return DynamicProgramming.knapsackComplete(amount, coins);
    }

    /**
     * 使用状态压缩进行优化, 思路见{@link DynamicProgramming#knapsackCompleteStatusCompression(int, int[])}
     *
     * @param amount 总金额
     * @param coins 硬币种类
     * @return 解决方案类型
     */
    public int changeFast(int amount, int[] coins) {
        return DynamicProgramming.knapsackCompleteStatusCompression(amount, coins);
    }
}
