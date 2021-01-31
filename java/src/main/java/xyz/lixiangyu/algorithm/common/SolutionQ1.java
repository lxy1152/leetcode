package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个整数数组{@code nums}和一个整数目标值{@code target}, 请你在该数组中找出和为目标值的那两个整数, 并返回它们的数组下标<br>
 * 你可以假设每种输入只会对应一个答案. 但是, 数组中同一个元素不能使用两遍<br>
 * 你可以按任意顺序返回答案
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [2, 7, 11, 15], target = 9}<br>
 * 输出: {@code [0,1]}<br>
 * 解释: 因为{@code nums[0] + nums[1] == 9}, 所以返回{@code [0, 1]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [3, 2, 4], target = 6}<br>
 * 输出: {@code [1,2]}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code nums = [3,3], target = 6}<br>
 * 输出: {@code [0,1]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>{@code 2 <= nums.length <= 10^3}</b></li>
 *     <li><b>{@code -10^9 <= nums[i] <= 10^9}</b></li>
 *     <li><b>{@code -10^9 <= target <= 10^9}</b></li>
 *     <li><b>只会存在一个有效答案</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个整数数组
     * @param obj1 目标值
     * @return 一个数组, 包含了和为目标值的两个整数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof Integer[] && obj1 instanceof Integer) {
            return twoSum((Integer[]) obj, (Integer) obj1);
        }
        return null;
    }

    /**
     * <p>
     * 思路:<br>
     * 用一个{@code HashMap}来保存当前值以及目标值和当前值的差, 在存数前判断差值是否已经存在, 如果存在则是解
     * </p>
     *
     * @param nums   一个整数数组
     * @param target 目标值
     * @return 一个数组, 包含了和为目标值的两个整数
     */
    public Integer[] twoSum(Integer[] nums, Integer target) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new Integer[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
