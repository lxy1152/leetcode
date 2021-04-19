package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/remove-element/">27. 移除元素</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个数组{@code nums}和一个值{@code val}, 你需要原地移除所有数值等于{@code val}的元素, 并返回移除后数组的新长度<br>
 * 不要使用额外的数组空间, 你必须仅使用{@code O(1)}额外空间并原地修改输入数组<br>
 * 元素的顺序可以改变, 你不需要考虑数组中超出新长度后面的元素
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [3, 2, 2, 3], val = 3}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= nums.length <= 100</b></li>
 *     <li><b>0 <= nums[i] <= 50</b></li>
 *     <li><b>0 <= val <= 100</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ27 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 要移除的元素
     * @return 移除这个元素后的数组的长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return removeElement((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 将数组中的某个元素移除
     *
     * <p>
     * 思路:<br>
     * 使用双指针
     * </p>
     *
     * @param nums 一个数组
     * @param val  要移除的元素
     * @return 移除这个元素后的数组的长度
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
