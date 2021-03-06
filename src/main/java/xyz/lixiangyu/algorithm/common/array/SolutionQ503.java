package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/next-greater-element-ii/">503. 下一个更大元素 II</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个循环数组(最后一个元素的下一个元素是数组的第一个元素), 输出每个元素的下一个更大元素<br>
 * 数字{@code x}的下一个更大的元素是: 按数组遍历顺序, 这个数字之后的第一个比它更大的数<br>
 * 这意味着你应该循环地搜索它的下一个更大的数, 如果不存在，则输出{@code -1}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 2, 1]}<br>
 * 输出: {@code [2, -1, 2]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>输入数组的长度不会超过10000</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ503 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个循环数组
     * @return 下一个更大元素
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return nextGreaterElements((int[]) obj);
        }
        return null;
    }

    /**
     * 获得下一个更大元素
     *
     * <p>
     * 思路:<br>
     * 使用单调栈保存单调递减趋于的元素, 它们的下一个最大元素是相同的
     * </p>
     *
     * @param nums 一个循环数组
     * @return 下一个更大元素
     */
    public int[] nextGreaterElements(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 保存结果
        int[] result = new int[n];
        // 初始值全部给-1, 即找不到下一个最大元素
        Arrays.fill(result, -1);
        // 使用单调栈保存元素
        Deque<Integer> stack = new LinkedList<>();
        // 需要遍历两遍, 因为最后一个元素的下一个更大元素需要从大开始查
        // 由于遍历多遍, 所以索引是 i % n
        for (int i = 0; i < (n << 1) - 1; i++) {
            // 如果某一部分元素是单调递减的, 那么它们的下一个最大元素是相同的
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
