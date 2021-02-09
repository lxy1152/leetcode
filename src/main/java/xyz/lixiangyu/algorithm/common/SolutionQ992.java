package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/subarrays-with-k-different-integers/">992. K 个不同整数的子数组</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个正整数数组{@code A}, 如果{@code A}的某个子数组中不同整数的个数恰好为{@code K},
 * 则称{@code A}的这个连续, 不一定独立的子数组为好子数组<br>
 * (例如: {@code [1, 2, 3, 1, 2]}中有{@code 3}个不同的整数, {@code 1, 2, 3})<br>
 * 返回{@code A}中好子数组的数目
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code A = [1, 2, 1, 2, 3], K = 2}<br>
 * 输出: {@code 7}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code A = [1, 2, 1, 3, 4], K = 3}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 20000</b></li>
 *     <li><b>1 <= A[i] <= A.length</b></li>
 *     <li><b>1 <= K <= A.length</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ992 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 限制的个数
     * @return 好子数组的个数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return subArraysWithKDistinct((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算好子数组的个数
     *
     * <p>
     * 思路:<br>
     * 常规的双指针解法一般用来解决"最大", "最小"等问题, 见
     * {@linkplain SolutionQ424 424. 替换后的最长重复字符}, {@linkplain SolutionQ978 978. 最长湍流子数组},
     * {@linkplain SolutionQ1208 1208. 尽可能使字符串相等}<br>
     * 而本题所说的是"恰好"有{@code k}个数, 所以不能直接使用双指针来解决, 所以需要将题目由求"恰好"转变为求"最大"<br>
     * 而"恰好"有{@code k}个数="最多"有{@code k}个数-"最多"有{@code k - 1}个数, 这样就可以使用双指针了
     * </p>
     *
     * <p>
     * 时间复杂度: {@code O(n)}<br>
     * 空间复杂度: {@code O(n)}
     * </p>
     *
     * @param a 一个数组
     * @param k 限制的个数
     * @return 好子数组的个数
     */
    public int subArraysWithKDistinct(int[] a, int k) {
        return countOfSubArrayWithKSize(a, k) - countOfSubArrayWithKSize(a, k - 1);
    }

    /**
     * 计算最多有{@code k}个数的好子数组的个数
     *
     * @param a 一个数组
     * @param k 限制的个数
     * @return 好子数组的个数
     */
    private int countOfSubArrayWithKSize(int[] a, int k) {
        // 左右指针
        int left = 0;
        int right = 0;
        // 保存每个数出现的次数
        int[] frequency = new int[a.length + 1];
        // 保存当前区间内不相同数的个数
        int count = 0;
        // 保存最后的结果
        int result = 0;
        // 右指针右移
        while (right < a.length) {
            // 如果出现次数是0, 则数量+1
            if (frequency[a[right]] == 0) {
                count++;
            }
            // 出现次数+1
            frequency[a[right]]++;
            // 指针右移
            right++;
            // 保证区间大小不会超过k
            while (count > k) {
                // 移出左指针位置的数
                frequency[a[left]]--;
                // 如果出现次数为0, 则数量-1
                if (frequency[a[left]] == 0) {
                    count--;
                }
                // 左指针右移
                left++;
            }
            /*
             * 由于统计的是个数不超过k的子数组数量
             * 所以这里需要加上区间长度
             * 比如: a = [1, 2, 3, 1], k = 3
             * 区间长度为1 + 2 + 3 = 6
             * 对应[1], [1, 2], [2, 3], [3, 1], [1, 2, 3], [2, 3, 1]
             */
            result += right - left;
        }
        return result;
    }
}
