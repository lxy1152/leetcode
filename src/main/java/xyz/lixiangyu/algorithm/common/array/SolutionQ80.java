package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">80. 删除有序数组中的重复项 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个有序数组{@code nums}, 请你原地删除重复出现的元素, 使每个元素最多出现两次, 返回删除后数组的新长度<br>
 * 不要使用额外的数组空间, 你必须在原地修改输入数组并在使用{@code O(1)}额外空间的条件下完成
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 1, 1, 2, 2, 3]}<br>
 * 输出: {@code 5, nums = [1, 1, 2, 2, 3]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [0, 0, 1, 1, 1, 1, 2, 3, 3]}<br>
 * 输出: {@code 7, nums = [0, 0, 1, 1, 2, 3, 3]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>{@code 0 <= nums.length <= 3 * 10^4}</b></li>
 *     <li><b>{@code -10^4 <= nums[i] <= 10^4}</b></li>
 *     <li><b>{@code nums}已按升序排列</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ80 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个包含重复元素的数组
     * @return 删除重复元素后的数组的长度
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return removeDuplicates((int[]) obj);
        }
        return null;
    }

    /**
     * 删除数组中的重复元素
     *
     * <p>
     * 思路:<br>
     * 使用双指针
     * </p>
     *
     * @param nums 一个包含重复元素的数组
     * @return 删除重复元素后的数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // 如果数组长度小于等于2, 则直接返回
        if (n <= 2) {
            return n;
        }
        // 快慢指针
        int left = 2;
        int right = 2;
        // 如果right位置的数和left - 2位置的数不相同就需要不断地搬运
        while (right < n) {
            if (nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
