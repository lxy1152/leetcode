package xyz.lixiangyu.algorithm.common.backtrack;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/subsets/">78. 子集</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}, 数组中的元素互不相同, 返回该数组所有可能的子集(幂集)<br>
 * 解集不能包含重复的子集, 你可以按任意顺序返回解集
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 2, 3]}<br>
 * 输出: {@code [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]}
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
 *     <li><b>nums中的所有元素互不相同</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ78 extends AbstractSolution {
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
     * @param obj 一个数组
     * @return 这个数组的所有子集
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return subsets((int[]) obj);
        }
        return null;
    }

    /**
     * 求某个数组的所有子集
     *
     * <p>
     * 思路:<br>
     * 直接套用回溯模板, 不同点在于移除元素后需要在递归一次
     * </p>
     *
     * @param nums 一个数组
     * @return 这个数组的所有子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        backtrack(nums, 0);
        return result;
    }

    /**
     * 计算数组的子集
     *
     * @param nums  数组
     * @param count 当前遍历过的元素个数
     */
    public void backtrack(int[] nums, int count) {
        if (count == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[count]);
        backtrack(nums, count + 1);
        path.remove(path.size() - 1);
        backtrack(nums, count + 1);
    }
}
