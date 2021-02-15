package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">485. 最大连续1的个数</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个二进制数组, 计算其中最大连续1的个数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code [1, 1, 0, 1, 1, 1]}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>输入的数组只包含0和1</b></li>
 *     <li><b>输入数组的长度是正整数, 且不超过10,000</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ485 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 最大连续1的个数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return findMaxConsecutiveOnes((int[]) obj);
        }
        return null;
    }

    /**
     * 最大连续1的个数
     *
     * <p>
     * 思路:<br>
     * 双指针
     * </p>
     *
     * @param nums 一个数组
     * @return 最大连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 保存最后的结果
        int result = 0;
        // 左右指针
        int right = 0;
        int left = 0;
        // 右指针右移
        while (right < n) {
            if (nums[right] == 1) {
                right++;
            } else {
                // 如果当前位置是0
                // 需要计算上一个连续1区间的长度
                // 并重置左指针
                result = Math.max(result, right - left);
                right++;
                left = right;
            }
        }
        result = Math.max(result, right - left);
        return result;
    }
}
