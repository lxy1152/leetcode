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
    public static int knapsackBase(int w, int n, int[] wt, int[] val) {
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

    /**
     * 0-1 背包问题代码模板, 使用状态压缩
     *
     * <p>
     * 思路:<br>
     * 类似{@linkplain #knapsackSubsetStateCompression(int[]) 子集背包问题状态压缩}和
     * {@linkplain #knapsackCompleteStatusCompression(int, int[]) 完全背包问题状态压缩}的思路进行状态压缩
     * </p>
     *
     * @param w   背包的承重上限
     * @param n   物品数量
     * @param wt  每个物品的重量
     * @param val 每个物品的价值
     * @return 背包的最大价值
     */
    public static int knapsackBaseStateCompression(int w, int n, int[] wt, int[] val) {
        // 压缩成一维的dp数组
        int[] dp = new int[w + 1];

        // 状态转移
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                if (j - wt[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
                }
            }
        }
        return dp[w];
    }

    /**
     * 子集背包问题, 以{@linkplain xyz.lixiangyu.algorithm.common.dp.SolutionQ416 416. 分割等和子集}
     * 为例
     *
     * <p>
     * 思路:<br>
     * 将子集问题转换为0-1背包问题<br>
     * 比如在此题中, 可以将原题转换为:<br>
     * 给定一个最大承重{@code sum / 2}的背包和{@code n}个物品, 这个背包能否被正好装满?<br>
     * 转换后的问题与上面的{@linkplain #knapsackBase 0-1背包问题}的区别在于, 不是求最大而是恰好满足<br>
     *
     * 在代码实现上, 除了要做一些边界检查外, 可完全参考{@linkplain #knapsackBase 0-1背包问题}来解决<br>
     * 对于本题而言, 使用二维{@code dp}数组耗时较长, 因为很多数据实际上是不需要的,
     * 请见{@linkplain #knapsackSubsetStateCompression(int[]) 优化后的子集背包}代码实现思路
     * </p>
     *
     * @param nums 一个数组
     * @return 是否能够进行分割
     */
    public static boolean knapsackSubset(int[] nums) {
        // 计算数组中数字的总和
        int space = Arrays.stream(nums).sum();

        // 如果总和不是偶数, 那么分成的两部分的数字必然是不等的, 直接返回false
        if ((space & 1) == 1) {
            return false;
        }
        // 对于能分成两部分的情况, 可套用0-1背包问题的代码模板
        else {
            // 数组长度
            int n = nums.length;

            // 因为分成两部分, 所以总空间大小需要除2
            space = space >> 1;

            // 创建dp数组, 由于下标从1开始, 所以容量需要加1
            boolean[][] dp = new boolean[n + 1][space + 1];

            // 当背包容量为0时, 认为背包已经填满了
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            // 注意nums数组的下标
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= space; j++) {
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 这里不需要max了, 需要用逻辑或
                        // 因为只要存在一种情况满足题意就认为是可以的
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }

            return dp[n][space];
        }
    }

    /**
     * 子集背包问题, 以{@linkplain xyz.lixiangyu.algorithm.common.dp.SolutionQ416 416. 分割等和子集}
     * 为例
     *
     * <p>
     * 思路:<br>
     * 在{@link #knapsackSubset(int[])}中已经解决了子集背包问题, 可是{@code dp}数组每次只依赖于上一行和左上方某位置的结果,
     * 并且上方的结果在以后都不再使用了(最后返回的是{@code dp[n][space]}), 所以使用二维数组来保存所有的结果会浪费空间<br>
     * 解决方法是对{@code dp}数组进行压缩, 将原二维数组压成一维即可
     * </p>
     *
     * @param nums 一个数组
     * @return 是否能够进行分割
     */
    public static boolean knapsackSubsetStateCompression(int[] nums) {
        // 计算数组中数字的总和
        int space = Arrays.stream(nums).sum();

        // 如果总和不是偶数, 那么分成的两部分的数字必然是不等的, 直接返回false
        if ((space & 1) == 1) {
            return false;
        } else {
            // 数组长度
            int n = nums.length;

            // 因为分成两部分, 所以总空间大小需要除2
            space = space >> 1;

            // 在上面的代码实现中, dp数组实际上只依赖于上一行的结果, 并且之前的结果都不再使用了
            // 所以对dp数组进行状态压缩, 将原二维dp数组压缩成一维的
            boolean[] dp = new boolean[space + 1];

            // 背包大小是为0时, 认为已经填满了
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                // 此处使用逆序的原因是前项结果会影响后项
                for (int j = space; j >= 0; j--) {
                    if (j - nums[i] >= 0) {
                        dp[j] = dp[j] || dp[j - nums[i]];
                    }
                }
            }

            return dp[space];
        }
    }

    /**
     * 完全背包问题, 以{@linkplain xyz.lixiangyu.algorithm.common.dp.SolutionQ518 518. 零钱兑换 II}为例
     *
     * <p>
     * 思路:<br>
     * 在代码实现上基本和{@linkplain #knapsackBase(int, int, int[], int[]) 0-1背包问题}相似,
     * 区别在于因为数量不做限制, 需要做求和而不是取最值
     * </p>
     *
     * @param amount 总金额
     * @param coins  硬币组合
     * @return 总组合方式的数量
     */
    public static int knapsackComplete(int amount, int[] coins) {
        // 硬币的种类
        int n = coins.length;

        // 二维dp数组
        int[][] dp = new int[n + 1][amount + 1];

        // 对任意数量的硬币, 如果总钱数是0, 那么组合方式只有一种
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 和0-1背包问题的区别在于, 不需要使用Math.max了
        // 因为硬币的数量是无限的, 所以这里要求和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 完全背包问题, 以{@linkplain xyz.lixiangyu.algorithm.common.dp.SolutionQ518 518. 零钱兑换 II}为例
     *
     * <p>
     * 思路:<br>
     * 类似{@linkplain #knapsackSubsetStateCompression(int[]) 子集背包问题}, 在这个问题中同样只涉及{@code dp}数组
     * 的上一行, 所以进行状态压缩优化, 时间上节省了7ms
     * </p>
     *
     * @param amount 总金额
     * @param coins  硬币组合
     * @return 总组合方式的数量
     */
    public static int knapsackCompleteStatusCompression(int amount, int[] coins) {
        // 一维的dp数组
        int[] dp = new int[amount + 1];

        // 如果总金额是0, 那么组合方式只有1种
        dp[0] = 1;

        // 状态转移
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
