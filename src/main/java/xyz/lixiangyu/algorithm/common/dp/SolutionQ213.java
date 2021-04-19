package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/">213. 打家劫舍 II</a>
 *
 * <p>
 * 描述:<br>
 * 你是一个专业的小偷, 计划偷窃沿街的房屋, 每间房内都藏有一定的现金<br>
 * 这个地方所有的房屋都围成一圈, 这意味着第一个房屋和最后一个房屋是紧挨着的<br>
 * 同时相邻的房屋装有相互连通的防盗系统, 如果两间相邻的房屋在同一晚上被小偷闯入, 系统会自动报警<br>
 * 给定一个代表每个房屋存放金额的非负整数数组, 计算你在不触动警报装置的情况下, 今晚能够偷窃到的最高金额
 * <b>与198题的区别在于首位相连</b>
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [2, 3, 2]}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [1, 2, 3, 1]}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code [0]}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 100</b></li>
 *     <li><b>0 <= nums[i] <= 1000</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ213 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 每个房屋中可盗窃的金额数量
     * @return 最大盗窃金额
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return rob((int[]) obj);
        }
        return null;
    }

    /**
     * 由于首尾相连, 所以第一个房子和最后一个房子不能同时进行偷窃,
     * 所以可以分为两种情况, 最后的结果是这两个值中的最大值:
     * 1. 偷取第一间房子到倒数第二间房子
     * 2. 偷取第二间房子到最后一间房子
     *
     * @param nums 每个房屋中可盗窃的金额数量
     * @return 最大盗窃金额
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    /**
     * 对一定范围内的房子进行偷窃
     *
     * @param nums  每个房屋中可盗窃的金额数量
     * @param start 起始位置
     * @param end   结束位置
     * @return 最大盗窃金额
     */
    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
