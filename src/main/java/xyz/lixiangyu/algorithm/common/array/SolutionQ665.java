package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-average-subarray-i/">643. 子数组最大平均数 I</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个长度为{@code n}的整数数组, 请你判断在最多改变{@code 1}个元素的情况下, 该数组能否变成一个非递减数列<br>
 * 我们是这样定义一个非递减数列的: 对于数组中所有的{@code i(0 <= i <= n-2)}, 总满足{@code nums[i] <= nums[i + 1]}。
 * </p>
 *
 * <p>
 * <p>
 * 样例输出1:<br>
 * 输入: {@code nums = [4, 2, 3]}<br>
 * 输出: {@code true}<br>
 * </p>
 *
 * <p>
 * 样例输出2:<br>
 * 输入: {@code nums = [4, 2, 1]}<br>
 * 输出: {@code false}<br>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b> 1 <= n <= 10^4 </b></li>
 *     <li><b> -10^5 <= nums[i] <= 10^5 </b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ665 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个整型数组
     * @return 是否可以在修改一次的情况下修改为非递减数据
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return checkPossibility((int[]) obj);
        }
        return null;
    }

    /**
     * 检查一个给定的数组是否可以在修改一次的情况下修改为非递减数据
     *
     * <p>
     * 思路:<br>
     * 遍历数组, 统计出现非递减数字的次数
     * </p>
     *
     * @param nums 一个整型数组
     * @return 是否可以在修改一次的情况下修改为非递减数据
     */
    public boolean checkPossibility(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 统计出现次数
        int count = 0;
        // 数组遍历, 注意这里取n - 1
        for (int i = 0; i < n - 1; ++i) {
            // 如果出现了非递减的情况
            if (nums[i] > nums[i + 1]) {
                // 统计次数+1
                count++;
                // 如果出现的次数多于两次直接返回
                if (count > 1) {
                    return false;
                }
                // 用i位置的元素替换i+1位置的元素
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
