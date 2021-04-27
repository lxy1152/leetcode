package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/largest-divisible-subset/">368. 最大整除子集</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个由无重复正整数组成的集合{@code nums}, 请你找出并返回其中最大的整除子集{@code answer},
 * 子集中每一元素对({@code answer[i], answer[j]})都应当满足:<br>
 * 1. {@code answer[i] % answer[j] == 0}<br>
 * 2. {@code answer[j] % answer[i] == 0}<br>
 * 如果存在多个有效解子集, 返回其中任何一个均可
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 2, 3]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [1, 2, 4, 8]}<br>
 * 输出: {@code [1, 2, 4, 8]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 1000</b></li>
 *     <li><b>1 <= nums[i] <= 2 * 10^9</b></li>
 *     <li><b>nums 中的所有整数互不相同</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ368 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 最大整除数组
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return largestDivisibleSubset((int[]) obj);
        }
        return null;
    }

    /**
     * 获取最大整除数组
     *
     * @param nums 一个数组
     * @return 最大整除数组
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxValue = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }

            System.out.println(Arrays.toString(dp));
        }

        List<Integer> result = new ArrayList<>();
        if (maxSize == 1) {
            result.add(nums[0]);
        } else {
            for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                    result.add(nums[i]);
                    maxValue = nums[i];
                    maxSize--;
                }
            }
        }

        return result;
    }
}
