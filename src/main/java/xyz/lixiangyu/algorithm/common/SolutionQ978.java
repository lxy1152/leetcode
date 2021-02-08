package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/longest-turbulent-subarray/">978. 最长湍流子数组</a>
 *
 * <p>
 * 描述:<br>
 * 当{@code A}的子数组{@code  A[i], A[i+1], ..., A[j]}满足下列条件时, 我们称其为湍流子数组<br>
 * 若{@code i <= k < j}, 当{@code k}为奇数时, {@code A[k] > A[k+1]}, 且当{@code k}为偶数时, {@code A[k] < A[k+1]}<br>
 * 或若{@code i <= k < j}, 当{@code k}为偶数时, {@code A[k] > A[k+1]}, 且当{@code k}为奇数时, {@code A[k] < A[k+1]}<br>
 * 也就是说, 如果比较符号在子数组中的每个相邻元素对之间翻转, 则该子数组是湍流子数组<br>
 * 返回 A 的最大湍流子数组的长度。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [9, 4, 2, 10, 7, 8, 8, 1, 9]}<br>
 * 输出 {@code 5}:
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [4, 8, 12, 16]}<br>
 * 输出 {@code 2}:
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code [100]}<br>
 * 输出 {@code 1}:
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 40000</b></li>
 *     <li><b>0 <= A[i] <= 10^9</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ978 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 最大湍流子数组的长度
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return maxTurbulenceSize((int[]) obj);
        }
        return null;
    }

    /**
     * 计算最大湍流子数组的长度
     *
     * <p>
     * 思路:<br>
     * 双指针遍历
     * </p>
     *
     * @param arr 一个数组
     * @return 最大湍流子数组的长度
     */
    public int maxTurbulenceSize(int[] arr) {
        // 数组长度
        int n = arr.length;
        // 保存最后的结果
        int result = 1;
        // 左右指针
        int left = 0;
        int right = 0;
        // 右指针右移
        while (right < n - 1) {
            // 跳过相同的数
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                // 如果前后数字能构成湍流数组, 则右指针右移, 否则左指针应该
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            // 取最大窗口作为结果
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
