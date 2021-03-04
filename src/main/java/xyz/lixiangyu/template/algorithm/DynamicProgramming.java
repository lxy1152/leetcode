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
}
