package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/combination-sum-iv/">377. 组合总和 Ⅳ</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个由不同整数组成的数组{@code nums}和一个目标整数{@code target}, 请你从{@code nums}中找出并返回总和为{@code target}的元素组合的个数<br>
 * 题目数据保证答案符合 32 位整数范围。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 2, 3], target = 4}<br>
 * 输出: {@code 7}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [9], target = 3}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 200</b></li>
 *     <li><b>1 <= nums[i] <= 1000</b></li>
 *     <li><b>nums 中的所有元素互不相同</b></li>
 *     <li><b>1 <= target <= 1000</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ377 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 目标值
     * @return 满足目标值的不同组合数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return combinationSum4((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算能组成目标值的不同组合数量
     *
     * @param nums   一个数组
     * @param target 目标值
     * @return 满足目标值的不同组合数
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
