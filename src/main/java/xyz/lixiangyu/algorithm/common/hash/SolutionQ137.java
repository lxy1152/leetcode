package xyz.lixiangyu.algorithm.common.hash;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/single-number-ii/">137. 只出现一次的数字 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}, 除某个元素仅出现一次外, 其余每个元素都恰出现三次, 请你找出并返回那个只出现了一次的元素
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [2, 2, 3, 2]}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [0, 1, 0, 1, 0, 1, 99]}<br>
 * 输出: {@code 99}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 3 * 10^4</b></li>
 *     <li><b>-2^{31} <= nums[i] <= 2^{31} - 1</b></li>
 *     <li><b>nums中, 除某个元素仅出现一次外, 其余每个元素都恰出现三次</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ137 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 恰好只出现一次的那个数字
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return singleNumber((int[]) obj);
        }
        return null;
    }

    /**
     * 获取恰好只出现一次的那个数字
     *
     * <p>
     * 思路:<br>
     * 通过哈希表存储每个数字的出现次数
     * </p>
     *
     * @param nums 一个数组
     * @return 恰好只出现一次的那个数字
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 3) {
                map.remove(num);
            }
        }
        return map.entrySet().stream().findFirst().get().getKey();
    }
}
