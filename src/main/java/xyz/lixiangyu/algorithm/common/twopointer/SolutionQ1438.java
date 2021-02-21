package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

import java.util.TreeMap;

/**
 * <a href="https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">
 * 1438. 绝对差不超过限制的最长连续子数组
 * </a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}, 和一个表示限制的整数{@code limit}, 请你返回最长连续子数组的长度,
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于{@code limit}<br>
 * 如果不存在满足条件的子数组, 则返回{@code 0}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [8, 2, 4, 7], limit = 4}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [10, 1, 2, 4, 7, 2], limit = 5}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code nums = [4, 2, 2, 2, 4, 4, 2, 2], limit = 0}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 10^5</b></li>
 *     <li><b>1 <= nums[i] <= 10^9</b></li>
 *     <li><b>0 <= limit <= 10^9</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1438 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 一个整数限制
     * @return 绝对差不超过限制的最长连续子数组的长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return longestSubarray((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 绝对差不超过限制的最长连续子数组的长度
     *
     * <p>
     * 思路:<br>
     * 将问题转化为区间中的最大值和最小值的差不超过限制{@code limit}<br>
     * 区间中的最大值和最小值可以使用{@link TreeMap}来保存
     * </p>
     *
     * @param nums  一个数组
     * @param limit 一个整数限制
     * @return 绝对差不超过限制的最长连续子数组的长度
     */
    public int longestSubarray(int[] nums, int limit) {
        // 保存当前区间中出现的数以及它们出现的次数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 数组长度
        int n = nums.length;
        // 最后的结果
        int result = 0;
        // 左右指针
        int left = 0;
        int right = 0;
        // 右指针右移
        while (right < n) {
            // 当前出现数字的出现次数+1
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // 如果区间中最大值和最小值的差比限制要大, 左指针右移
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
