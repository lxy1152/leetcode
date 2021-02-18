package xyz.lixiangyu.algorithm.common.slidingwindow;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/">995. K 连续位的最小翻转次数</a>
 *
 * <p>
 * 描述:<br>
 * 在仅包含{@code 0}和{@code 1}的数组{@code A}中, 一次{@code K}位翻转包括选择一个长度为{@code K}的(连续)子数组,
 * 同时将子数组中的每个{@code 0}更改为{@code 1}, 而每个{@code 1}更改为{@code 0}<br>
 * 返回所需的{@code K}位翻转的最小次数, 以便数组没有值为{@code 0}的元素, 如果不可能, 返回{@code -1}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code A = [0, 1, 0], K = 1}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code A = [1, 1, 0], K = 2}<br>
 * 输出: {@code -1}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code A = [0, 0, 0, 1, 0, 1, 1, 0], K = 3}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 30000</b></li>
 *     <li><b>1 <= K <= A.length</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ995 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 一次翻转需要的个数
     * @return
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return minKBitFlips((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算最少翻转次数
     *
     * <p>
     * 思路:<br>
     * 滑动窗口, 判断区间是否需要翻转仅需判断端点位置
     * </p>
     *
     * @param a 一个数组
     * @param k 一次翻转需要的个数
     * @return 最少翻转次数
     */
    public int minKBitFlips(int[] a, int k) {
        // 数组长度
        int n = a.length;
        // 保存最后的结果
        int result = 0;
        // 下一个区间的左端点值
        int nextLeftValue = 0;
        // 数组遍历
        for (int i = 0; i < n; i++) {
            // 如果当前的位置是区间右端点, 并且区间被标记为是需要翻转的
            // 那么认为这个区间结束了, 需要取下一个区间
            if (i >= k && a[i - k] > 1) {
                nextLeftValue ^= 1;
            }
            // 如果当前的位置是区间左端点
            if (a[i] == nextLeftValue) {
                // 判断区间长度是否合适, 如果不合适直接返回-1
                if (i + k > n) {
                    return -1;
                }
                // 认定这个区间是需要翻转的
                result++;
                // 取下一个左端点值
                // 比如从0开始, 那么就应该以1结束
                nextLeftValue ^= 1;
                // 给当前位置赋一个不属于数组的值
                // 标记这个数组是要翻转的
                a[i] += 2;
            }
        }
        // 将原数组还原, 本题其实不需要
        for (int i = 0; i < n; i++) {
            if (a[i] > 1) {
                a[i] -= 2;
            }
        }
        return result;
    }
}
