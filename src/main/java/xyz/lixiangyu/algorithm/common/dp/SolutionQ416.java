package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.constants.Constants;
import xyz.lixiangyu.template.algorithm.DynamicProgramming;

/**
 * <a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">416. 分割等和子集</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个只包含正整数的非空数组, 是否可以将这个数组分割成两个子集, 使得两个子集的元素和相等
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 5, 11, 5]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [1, 2, 3, 5]}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>每个数组中的元素不会超过100</b></li>
 *     <li><b>数组的大小不会超过200</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ416 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 解决方案类型
     * @return 是否能够进行分割
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof String) {
            if (Constants.COMMON_SOLUTION.equals(obj1)) {
                return canPartition((int[]) obj);
            } else {
                return canPartitionFast((int[]) obj);
            }
        }
        return null;
    }

    /**
     * 使用二维数组进行实现, 思路见{@linkplain DynamicProgramming#knapsackSubset(int[]) 子集背包问题}
     *
     * @param nums 一个数组
     * @return 是否能够进行分割
     */
    boolean canPartition(int[] nums) {
        return DynamicProgramming.knapsackSubset(nums);
    }

    /**
     * 优化后的代码实现,
     * 思路见{@linkplain DynamicProgramming#knapsackSubsetStateCompression(int[])} 子集背包问题-状态压缩}
     *
     * @param nums 一个数组
     * @return 是否能够进行分割
     */
    boolean canPartitionFast(int[] nums) {
        return DynamicProgramming.knapsackSubsetStateCompression(nums);
    }
}
