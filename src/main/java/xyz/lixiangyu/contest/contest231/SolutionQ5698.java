package xyz.lixiangyu.contest.contest231;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum/">
 * 5698. 构成特定和需要添加的最少元素
 * </a>
 *
 * <p>
 * 描述:<br>
 * 给你一个整数数组{@code nums}和两个整数{@code limit}和{@code goal}<br>
 * 数组{@code nums}有一条重要属性: {@code abs(nums[i]) <= limit}<br>
 * 返回使数组元素总和等于{@code goal}所需要向数组中添加的最少元素数量, 新添加元素不应改变数组中
 * {@code abs(nums[i]) <= limit}这一属性
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [1, -1, 1], limit = 3, goal = -4}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [1, -10, 9, 1], limit = 100, goal = 0}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= nums.length <= 10^5</b></li>
 *     <li><b>1 <= limit <= 10^6</b></li>
 *     <li><b>-limit <= nums[i] <= limit</b></li>
 *     <li><b>-10^9 <= goal <= 10^9</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ5698 extends AbstractSolution {
    /**
     * 计算要添加的最少元素个数
     *
     * @param objects 一个数组, 一个数量限制以及最终的目标
     * @return 最少元素个数
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof int[] && objects[1] instanceof Integer && objects[2] instanceof Integer) {
            return minElements((int[]) objects[0], (int) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 计算要添加的最少元素个数
     *
     * <p>
     * 思路:<br>
     * 由于{@code limit}是这个数组中能出现的最大数字, 所以计算最少元素个数就是计算
     * 要添加的{@code limit}的最多个数<br>
     * 不能用{@code limit}填充的部分, 肯定是小于{@code limit}的, 在个数上面加{@code 1}即可
     * </p>
     *
     * @param nums  一个数组
     * @param limit 一个数量限制
     * @param goal  最终的目标
     * @return 最少元素个数
     */
    public int minElements(int[] nums, int limit, int goal) {
        long diff = Math.abs(Arrays.stream(nums).asLongStream().sum() - goal);
        int result = (int) (diff / limit);
        if (diff % limit != 0) {
            result++;
        }
        return result;
    }
}
