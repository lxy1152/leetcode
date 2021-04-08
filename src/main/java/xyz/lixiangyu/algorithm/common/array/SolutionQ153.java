package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">153. 寻找旋转排序数组中的最小值</a>
 *
 * <p>
 * 描述:<br>
 * 已知一个长度为{@code n}的数组, 预先按照升序排列, 经由{@code 1}到{@code n}次旋转后, 得到输入数组<br>
 * 例如, 原数组{@code nums = [0, 1, 2, 4, 5, 6, 7]}在变化后可能得到:<br>
 * 若旋转{@code 4}次, 则可以得到{@code [4, 5, 6, 7, 0, 1, 2]}<br>
 * 若旋转{@code 7}次, 则可以得到{@code [0, 1, 2, 4, 5, 6, 7]}<br>
 * 注意, 数组{@code [a[0], a[1], a[2], ..., a[n-1]]}旋转一次的结果为数组{@code [a[n-1], a[0], a[1], a[2], ..., a[n-2]]}<br>
 * 给你一个元素值互不相同的数组{@code nums}, 它原来是一个升序排列的数组, 并按上述情形进行了多次旋转, 请你找出并返回数组中的最小元素
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [3, 4, 5, 1, 2]}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [4, 5, 6, 7, 0, 1, 2]}<br>
 * 输出: {@code 0}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code nums = [11, 13, 15, 17]}<br>
 * 输出: {@code 11}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>n == nums.length</li>
 *     <li>1 <= n <= 5000</li>
 *     <li>-5000 <= nums[i] <= 5000</li>
 *     <li>nums 中的所有整数互不相同</li>
 *     <li>nums 原来是一个升序排序的数组, 并进行了 1 至 n 次旋转</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ153 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个旋转后的数组
     * @return 数组中的最小值
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return findMin((int[]) obj);
        }
        return null;
    }

    /**
     * 从一个旋转后的数组中找出最小值
     *
     * <p>
     * 思路:<br>
     * 二分查找
     * </p>
     *
     * @param nums 一个旋转后的数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
