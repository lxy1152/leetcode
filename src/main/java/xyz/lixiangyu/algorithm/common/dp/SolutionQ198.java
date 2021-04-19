package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber/">198. 打家劫舍</a>
 *
 * <p>
 * 描述:<br>
 * 你是一个专业的小偷, 计划偷窃沿街的房屋, 每间房内都藏有一定的现金, 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统,
 * 如果两间相邻的房屋在同一晚上被小偷闯入, 系统会自动报警<br>
 * 给定一个代表每个房屋存放金额的非负整数数组, 计算在不触动警报装置的情况下, 一夜之内能够偷窃到的最高金额
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 2, 3, 1]}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [2, 7, 9, 3, 1]}<br>
 * 输出: {@code 12}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= nums.length <= 100</b></li>
 *     <li><b>0 <= nums[i] <= 400</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ198 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 每个房屋存放金额的非负整数数组
     * @return 能够盗窃的最大金额
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return rob((int[]) obj);
        }
        return null;
    }

    /**
     * 计算能够盗窃的最大金额
     *
     * <p>
     * 思路:<br>
     * 1. 如果只有一个房屋, 那么最大盗窃金额就是这个房屋的金额<br>
     * 2. 如果有两个房屋, 那么最大盗窃金额是这两个房屋中的较大值<br>
     * 3. 如果房屋数量多于两个, 那么对于每个房屋都存在偷或者不偷两种状态, 结果取决于以后两种情况的最大值<br>
     * 3.1 如果选择偷, 那么金额等于前面第二个房屋的金额加上这个房屋的金额
     * 3.2 如果选择不透, 那么偷到的金额和前一次偷窃的金额是相同的
     * </p>
     *
     * @param nums 每个房屋存放金额的非负整数数组
     * @return 能够盗窃的最大金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[n];
    }
}
