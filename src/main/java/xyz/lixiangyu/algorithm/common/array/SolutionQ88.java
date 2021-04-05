package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/merge-sorted-array/">88. 合并两个有序数组</a>
 *
 * <p>
 * 描述:<br>
 * 给你两个有序整数数组{@code nums1}和{@code nums2}, 请你将{@code nums2}合并到{@code nums1}中, 使{@code nums1}成为一个有序数组<br>
 * 初始化{@code nums1}和{@code nums2}的元素数量分别为{@code m}和{@code n}, 你可以假设{@code nums1}的空间大小等于{@code m + n},
 * 这样它就有足够的空间保存来自{@code nums2}的元素。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3}<br>
 * 输出: {@code [1, 2, 2, 3, 5, 6]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums1 = [1], m = 1, nums2 = [], n = 0}<br>
 * 输出: {@code [1]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>nums1.length == m + n</li>
 *     <li>nums2.length == n</li>
 *     <li>0 <= m, n <= 200</li>
 *     <li>1 <= m + n <= 200</li>
 *     <li>-10^9 <= nums1[i], nums2[i] <= 10^9</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ88 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 要合并的两个数组
     * @return 合并后的数组
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof int[] && objects[1] instanceof Integer && objects[2] instanceof int[]
                && objects[3] instanceof Integer) {
            merge((int[]) objects[0], (int) objects[1], (int[]) objects[2], (int) objects[3]);
            System.out.println(Arrays.toString((int[]) objects[0]));
            return objects[0];
        }
        return null;
    }

    /**
     * 合并两个数组
     *
     * <p>
     * 思路:<br>
     * 双指针同时遍历
     * </p>
     *
     * @param nums1 数组1
     * @param m     数组1中的数字个数
     * @param nums2 数组2
     * @param n     数组2中的数字个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0;
        int pointer2 = 0;
        int index = 0;
        int[] result = new int[m + n];
        while (pointer1 < m || pointer2 < n) {
            if (pointer1 >= m) {
                result[index++] = nums2[pointer2++];
                continue;
            }
            if (pointer2 >= n) {
                result[index++] = nums1[pointer1++];
                continue;
            }
            if (nums1[pointer1] < nums2[pointer2]) {
                result[index++] = nums1[pointer1++];
            } else {
                result[index++] = nums2[pointer2++];
            }
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }
}
