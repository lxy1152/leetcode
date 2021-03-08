package xyz.lixiangyu.template.algorithm;

import java.util.Arrays;

/**
 * 动态规划问题代码模板
 *
 * @author lixiangyu
 */
public class DynamicProgramming {
    /**
     * 私有化构造器
     */
    private DynamicProgramming() {

    }

    /**
     * 使用动态规划解决最长递增子序列(LIS)问题
     *
     * <p>
     * 思路:<br>
     * {@code dp}数组保存以{@code nums[i]}结尾的LIS长度, 对于子序列问题, {@code dp}数组都可以这么定义<br>
     * 可以得到, 对于任意的{@code dp[i]}, 其LIS长度都可以由另一个{@code dp[j]}计算表示,
     * 其中{@code j}取所有{@code nums[i] > nums[k]}中{@code k}的最大值, 在它的基础上加{@code 1}即可<br>
     * 比如, 对于数组{@code 1 4 3 2 6}, {@code dp[4] = dp[1] + 1}<br>
     * 这种方案的时间复杂度为{@code O(n^2)}
     * </p>
     *
     * @param nums 一个数组
     * @return 最长递增子序列的长度
     */
    public static int longestIncreasingSubsequenceUseDp(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 创建dp数组, 默认全部给1, 因为子序列长度最少为1
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 保存最后的结果
        int result = 0;
        // 根据已计算出的值计算后面的值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 使用二分排序解决最长递增子序列(LIS)问题
     *
     * <p>
     * 思路:
     * 上面的方案时间复杂度是{@code O(n^2)}, 可以使用二分查找将时间复杂度将为{@code O(nlogn)}
     * </p>
     *
     * @param nums 一个数组
     * @return 最长递增子序列的长度
     */
    public static int longestIncreasingSubsequenceUseBinarySort(int[] nums) {
        // TODO: 待补充具体实现
        return 0;
    }

    /**
     * 0-1 背包问题代码模板
     *
     * <p>
     * 思路:<br>
     * 使用{@code dp[n][w]}数组表示前{@code n}个物品在背包容量{@code w}下的最大价值<br>
     * 对于任意的背包{@code i, j}, 其价值和之前的背包的关系是:
     * <ul>
     *     <li>如果当前背包的容量{@code j}装不下第{@code i}个物品, 那么其价值和第{@code [i - 1, j]}个背包的价值是相同的</li>
     *     <li>
     *         如果能装下第{@code i}个物品, 需要用第{@code [i - 1, j - wt[i]]}个背包来装这个物品, 在它的基础上加上新物品的价值<br>
     *         但问题是, 装上新物品的背包价值并不一定就比前一背包的价值高, 因为{@code j - wt[i]}的运算会忽略掉一部分的物品<br>
     *         所以需要取最大值作为当前背包的结果
     *     </li>
     * </ul>
     * 完成以上计算后, 将{@code dp[n][w]}的结果返回即是答案
     * </p>
     *
     * @param w   背包的承重上限
     * @param n   物品数量
     * @param wt  每个物品的重量
     * @param val 每个物品的价值
     * @return 背包的最大价值
     */
    public static int knapsack(int w, int n, int[] wt, int[] val) {
        // 由于下标从1开始, 所以数组大小需要加1
        int[][] dp = new int[n + 1][w + 1];

        // 注意: 由于下标从1开始, 所以wt和val数组对应的下标需要减1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // 如果当前的背包容量装不下重量为wt[i - 1]的物品, 那么其价值和之前的背包是相同的
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 如果能装下这个物品, 需要比较装下物品后的价值是否比前一背包大
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[n][w];
    }
}
