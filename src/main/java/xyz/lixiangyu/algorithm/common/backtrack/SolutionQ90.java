package xyz.lixiangyu.algorithm.common.backtrack;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/subsets-ii/">90. 子集 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}, 其中可能包含重复元素, 请你返回该数组所有可能的子集(幂集)<br>
 * 解集不能包含重复的子集, 在返回的解集中子集可以按任意顺序排列
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 2, 2]}<br>
 * 输出: {@code [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [0]}<br>
 * 输出: {@code [[], [0]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 10</b></li>
 *     <li><b>-10 <= nums[i] <= 10</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ90 extends AbstractSolution {
    /**
     * 储存每个子集
     */
    private List<Integer> path;

    /**
     * 最后的结果
     */
    private List<List<Integer>> result;

    /**
     * {@inheritDoc}
     *
     * @param obj 一个带有重复元素的数组
     * @return 这个数组的所有子集
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return subsetsWithDup((int[]) obj);
        }
        return null;
    }

    /**
     * 计算数组子集
     *
     * <p>
     * 思路:<br>
     * 在数组因为有重复元素, 比如: {@code [4, 4, 4, 1, 4]}, 会产生重复的三个{@code [4, 1, 4]}子集,
     * 可以通过{@link List#contains(Object)}来过滤重复元素<br>
     *
     * 使用这种方式的前提是{@code nums}数组有序
     * </p>
     *
     * @param nums 一个带有重复元素的数组
     * @return 这个数组的所有子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    /**
     * 计算数组的子集, 在插入到{@link #result}前判断元素是否存在
     *
     * @param nums  一个带有重复元素的数组
     * @param count 这个数组的所有子集
     */
    public void backtrack(int[] nums, int count) {
        if (count == nums.length) {
            List<Integer> current = new ArrayList<>(path);
            if (!result.contains(current)) {
                result.add(current);
            }
            return;
        }
        path.add(nums[count]);
        backtrack(nums, count + 1);
        path.remove(path.size() - 1);
        backtrack(nums, count + 1);
    }
}
