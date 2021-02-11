package xyz.lixiangyu.algorithm.common.slidingwindow;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.common.heap.SolutionQ480;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-average-subarray-i/">643. 子数组最大平均数 I</a>
 *
 * <p>
 * 描述:<br>
 * 给定{@code n}个整数, 找出平均数最大且长度为{@code k}的连续子数组, 并输出该最大平均数
 * </p>
 *
 * <p>
 * <p>
 * 样例输出:<br>
 * 输入: {@code [1, 12, -5, -6, 50, 3], k = 4}<br>
 * 输出: {@code 12.75}<br>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= k <= n <= 30,000</b></li>
 *     <li><b>所给数据范围[-10,000，10,000]</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ643 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 窗口大小
     * @return 平均值
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return findMaxAverage((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算子数组最大平均数
     *
     * <p>
     * 思路:<br>
     * 使用滑动窗口, 没有必要每次都计算平均值, 只要保证和最大那么平均值肯定就是最大的<br>
     * 这道题限制了数的范围是{@code [-10,000，10,000]}<br>
     * 如果没有限制, 用来保存求和后的值的变量的类型需要给{@code long}, 否则会因为超过
     * {@code int}型最大长度导致计算结果不对<br>
     * 这个是{@link SolutionQ480}中的坑, 见{@link SolutionQ480}的测试类中的用例
     * {@code SolutionQ480Test#testSolutionCaseTwo}
     * </p>
     *
     * @param nums 一个数组
     * @param k    窗口大小
     * @return 平均值
     */
    public double findMaxAverage(int[] nums, int k) {
        // 保存历史出现的和的最大值
        long maxSum = 0;
        // 计算第一个窗口的和
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        // 保存当前某窗口的和
        long currentSum = maxSum;
        // 窗口移动
        for (int i = k; i < nums.length; i++) {
            // 加上新移进窗口的数
            currentSum += nums[i];
            // 减去移出窗口的数
            currentSum -= nums[i - k];
            // 当前窗口的和和历史窗口的和的最大值作为结果并保存
            maxSum = Math.max(maxSum, currentSum);
        }
        // 计算平均值并返回
        return (double) maxSum / k;
    }
}
