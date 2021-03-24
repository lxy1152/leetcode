package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/132-pattern/">456. 132 模式</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}, 数组中共有{@code n}个整数, {@code 132}模式的子序列由三个整数{@code nums[i]}, {@code nums[j]}和
 * {@code nums[k]}组成, 并同时满足：{@code i < j < k}和{@code nums[i] < nums[k] < nums[j]}<br>
 * 如果{@code nums}中存在{@code 132}模式的子序列, 返回{@code true}, 否则返回{@code false}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, 2, 3, 4]}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [3, 1, 4, 2]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code nums = [-1, 3, 2, 0]}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>n == nums.length</b></li>
 *     <li><b>1 <= n <= 10^4</b></li>
 *     <li><b>-10^9 <= nums[i] <= 10^9</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ456 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 是否存在"132"模式的单调栈
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return find132pattern((int[]) obj);
        }
        return null;
    }

    /**
     * 找到满足"132"模式的单调栈
     *
     * <p>
     * 思路:<br>
     * 不断枚举3位置的数字, 对于1和2位置的数字, 有如下要求:<br>
     * 1. 1位置的数字要尽可能小: 先遍历一边数组求最小值<br>
     * 2. 2位置的数字要尽可能大, 但因为它比3位置的数字小, 所以应该取比3位置数字小的最大整数: 使用单调栈<br>
     * </p>
     *
     * @param nums 一个数组
     * @return 是否存在"132"模式的单调栈
     */
    public boolean find132pattern(int[] nums) {
        // 数组长度
        int n = nums.length;

        // 保存某个位置的数字的左边的最小数字作为1
        int[] leftMinNums = new int[n];
        // 因为求最小值, 所以初值需要给最大值, 量级在10^9, 使用0x3f3f3f3f足够
        Arrays.fill(leftMinNums, 0x3f3f3f3f);
        // 计算最小值
        for (int i = 1; i < n; i++) {
            leftMinNums[i] = Math.min(leftMinNums[i - 1], nums[i - 1]);
        }

        // 新建一个单调栈
        Deque<Integer> stack = new LinkedList<>();
        // 从右到左枚举3的可能取值
        for (int i = n - 1; i >= 0; i--) {
            int num = -0x3f3f3f3f;
            // 计算一下2的可能取值
            // 这里2应该取比3小的最大值
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                num = stack.pop();
            }
            // 如果有一对满足题意就退出循环
            if (leftMinNums[i] < num) {
                return true;
            }
            // 否则把当前的数字放进栈中
            stack.push(nums[i]);
        }

        return false;
    }
}
