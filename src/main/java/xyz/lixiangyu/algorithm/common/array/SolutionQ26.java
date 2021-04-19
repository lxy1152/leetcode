package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个有序数组{@code nums}, 请你原地删除重复出现的元素, 使每个元素只出现一次, 返回删除后数组的新长度<br>
 * 不要使用额外的数组空间, 你必须在原地修改输入数组并在使用{@code O(1)}额外空间的条件下完成
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 1, 2]}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= nums.length <= 3 * 10^4</b></li>
 *     <li><b>-10^4 <= nums[i] <= 10^4</b></li>
 *     <li><b>nums 已按升序排列</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ26 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个升序数组
     * @return 删除重复元素后的数组长度
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
     * @param nums 一个升序数组
     * @return 删除重复元素后的数组长度
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int cur = 0;
        while (i < n) {
            if (i == n - 1) {
                nums[cur] = nums[n - 1];
                cur++;
                break;
            } else if (nums[i] != nums[i + 1]) {
                nums[cur] = nums[i];
                cur++;
            }
            i++;
        }
        return cur;
    }
}
