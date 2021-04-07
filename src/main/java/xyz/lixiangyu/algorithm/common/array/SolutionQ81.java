package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">81. 搜索旋转排序数组 II</a>
 *
 * <p>
 * 描述:<br>
 * 已知存在一个按非降序排列的整数数组{@code nums}, 数组中的值不必互不相同<br>
 * 在传递给函数之前, {@code nums}在预先未知的某个下标{@code k(0 <= k < nums.length)}上进行了旋转, 使数组变为:
 * {@code [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]}(下标从0开始计数)<br>
 * 例如, {@code [0, 1, 2, 4, 4, 4, 5, 6, 6, 7]}在下标{@code 5}处经旋转后可能变为{@code [4, 5, 6, 6, 7, 0, 1, 2, 4, 4]}
 * 给你旋转后的数组{@code nums}和一个整数{@code target}, 请你编写一个函数来判断给定的目标值是否存在于数组中,
 * 如果{@code nums}中存在这个目标值{@code target}, 则返回{@code true}, 否则返回{@code false}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [2, 5, 6, 0, 0, 1, 2], target = 0}<br>
 * 输出: {@code true}<br>
 * 解释: 因为{@code nums[0] + nums[1] == 9}, 所以返回{@code [0, 1]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [2, 5, 6, 0, 0, 1, 2], target = 3}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>{@code 1 <= nums.length <= 5000}</b></li>
 *     <li><b>{@code -10^4 <= nums[i] <= 10^4}</b></li>
 *     <li><b>题目数据保证{@code nums}在预先未知的某个下标上进行了旋转</b></li>
 *     <li><b>{@code -10^4 <= target <= 10^4}</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ81 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个进行了旋转的数组
     * @param obj1 目标值
     * @return 目标值是否在数组中
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return search((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 判断目标值是否在数组中
     *
     * <p>
     * 思路:<br>
     * 使用二分查找
     * </p>
     *
     * @param nums   一个进行了旋转的数组
     * @param target 目标值
     * @return 目标值是否在数组中
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // 看一下前后哪部分是有序的就可以大致定出target所在的区域
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
