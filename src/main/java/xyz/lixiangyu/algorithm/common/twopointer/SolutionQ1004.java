package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/max-consecutive-ones-iii/">1004. 最大连续1的个数 III</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个由若干{@code 0}和{@code 1}组成的数组{@code A}, 我们最多可以将{@code K}个值从{@code 0}变成{@code 1}<br>
 * 返回仅包含{@code 1}的最长(连续)子数组的长度
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code A = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], K = 2}<br>
 * 输出: {@code 6}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code A = [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], K = 3}<br>
 * 输出: {@code 10}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 20000</b></li>
 *     <li><b>0 <= K <= A.length</b></li>
 *     <li><b>A[i]为0或1</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1004 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 最大替换次数
     * @return 最大子数组长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return longestOnes((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算最大子数组长度
     *
     * <p>
     * 思路:<br>
     * 双指针遍历
     * </p>
     *
     * @param a 一个数组
     * @param k 最大替换次数
     * @return 最大子数组长度
     */
    public int longestOnes(int[] a, int k) {
        // 数组长度
        int n = a.length;
        // 保存最后的结果
        int result = 0;
        // 左右指针
        int left = 0;
        int right = 0;
        // 被替换的0的个数
        int countOfReplacedZero = 0;
        // 右指针右移
        while (right < n) {
            // 统计0的个数
            if (a[right] == 0) {
                countOfReplacedZero++;
            }
            // 如果替换的次数多于k次, 需要把左指针右移
            while (countOfReplacedZero > k) {
                if (a[left++] == 0) {
                    countOfReplacedZero--;
                }
            }
            right++;
            // 保存当前窗口的长度
            result = Math.max(result, right - left);
        }
        return result;
    }
}
