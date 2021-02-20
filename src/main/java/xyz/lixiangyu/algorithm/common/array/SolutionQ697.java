package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/degree-of-an-array/">697. 数组的度</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个非空且只包含非负数的整数数组{@code nums}, 数组的度的定义是指数组里任一元素出现频数的最大值<br>
 * 你的任务是在{@code nums}中找到与{@code nums}拥有相同大小的度的最短连续子数组, 返回其长度
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 2, 2, 3, 1]}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [1, 2, 2, 3, 1, 4, 2]}<br>
 * 输出: {@code 6}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>nums.length在1到50,000区间范围内</b></li>
 *     <li><b>nums[i]是一个在0到 49,999范围内的整数</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ697 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 最短连续子数组
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return findShortestSubArray((int[]) obj);
        }
        return null;
    }

    /**
     * 最短连续子数组
     *
     * <p>
     * 思路:<br>
     * 通过哈希表保存每个数出现的次数和第一次、最后一次出现的位置,
     * 遍历哈希表, 计算出现次数最多数字所在区间的长度
     * </p>
     *
     * @param nums 一个数组
     * @return 最短连续子数组
     */
    public int findShortestSubArray(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 储存每个数字出现的次数以及出现的位置
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        // 出现次数相同取最大数字
        // 长度取最小值
        int maxNum = 0;
        int len = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] array = entry.getValue();
            if (maxNum < array[0]) {
                maxNum = array[0];
                len = array[2] - array[1] + 1;
            } else if (maxNum == array[0]) {
                if (len > array[2] - array[1] + 1) {
                    len = array[2] - array[1] + 1;
                }
            }
        }
        return len;
    }
}
