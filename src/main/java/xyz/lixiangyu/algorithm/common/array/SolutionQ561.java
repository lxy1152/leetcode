package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/array-partition-i/">561. 数组拆分 I</a>
 *
 * <p>
 * 描述:<br>
 * 给定长度为{@code 2n}的整数数组{@code nums}, 你的任务是将这些数分成{@code n}对,
 * 例如{@code (a1, b1), (a2, b2), ..., (an, bn)}, 使得从{@code 1}到{@code n}的{@code min(ai, bi)}总和最大<br>
 * 返回该最大总和
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 4, 3, 2]}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [6, 2, 6, 5, 1, 2]}<br>
 * 输出: {@code 9}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= n <= 10^4</b></li>
 *     <li><b>nums.length == 2 * n</b></li>
 *     <li><b>-10^4 <= nums[i] <= 10^4</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ561 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 所有最小值的和的最大值
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return arrayPairSum((int[]) obj);
        }
        return null;
    }

    /**
     * 获得一个数组中所有最小值的和的最大值
     *
     * <p>
     * 思路:<br>
     * 由于必然会取最小值但又要确保总和最大, 所以在做取最小值的操作时,
     * 应该尽量舍弃一个比当前数字大的数字中的最小值<br><br>
     *
     * 以{@code nums = [0, 3, 4, 1]}举例:<br>
     * {@code (0, 3), (1, 4)}的组合显然是不合理的, 因为较大的值{@code 3, 4}都被舍弃了<br>
     * 但{@code (0, 1), (3, 4)}就是符合题意的, 因为每一次的操作只是舍弃了一个大数字中的最小值<br><br>
     *
     * 那么可以得到如下的结论:<br>
     * <b>要组合起来的数字应该是数组排序后相邻的两个数字, 最大值就是奇数位置(索引是偶数)的所有数的和</b><br>
     * 因为这样可以保证每次只舍弃一个相对较大的值, 而真正较大的值会保留下来
     * </p>
     *
     * @param nums 一个数组
     * @return 所有最小值的和的最大值
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
