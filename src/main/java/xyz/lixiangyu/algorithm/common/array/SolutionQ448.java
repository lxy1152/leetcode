package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">448. 找到所有数组中消失的数字</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个范围在{@code 1 ≤ a[i] ≤ n}({@code n}=数组大小)的整型数, 数组中的元素一些出现了两次, 另一些只出现一次<br>
 * 找到所有在{@code [1, n]}范围之间没有出现在数组中的数字<br>
 * 您能在不使用额外空间且时间复杂度为{@code O(n)}的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code [4, 3, 2, 7, 8, 2, 3, 1]}<br>
 * 输出: {@code [5, 6]}
 * </p>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ448 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 数组中消失的数字
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return findDisappearedNumbers((int[]) obj);
        }
        return null;
    }

    /**
     * 找到所有数组中消失的数字
     *
     * <p>
     * 思路:<br>
     * 难点在于怎么标记数组中没有出现的数字:
     * <ul>
     *     <li>遍历数组, 通过数字的绝对值计算索引, 表示按照顺序排列时, 这个数所在的位置</li>
     *     <li>如果对应索引位置的值 > 0, 则置为负数, 表示这个数已经出现过</li>
     *     <li>将所有大于0的数的索引作为结果返回(因为已经按照顺序排列了, 所以只要返回索引就行了)</li>
     * </ul>
     *
     * <p>
     *     以{@code nums = [4, 5, 2, 1, 2]}, 举例:
     *     <ol>
     *         <li>当{@code num = 4}时, 计算索引为{@code 4 - 1 = 3}, 所以将{@code nums[3]}置为{@code -1}</li>
     *         <li>当{@code num = 5}时, 计算索引为{@code 5 - 1 = 4}, 所以将{@code nums[4]}置为{@code -2}</li>
     *         <li>当{@code num = 2}时, 计算索引为{@code 2 - 1 = 1}, 所以将{@code nums[1]}置为{@code -5}</li>
     *         <li>当{@code num = 1}时, 计算索引为{@code 1 - 1 = 0}, 所以将{@code nums[0]}置为{@code -4}</li>
     *         <li>当{@code num = 2}时, 计算索引为{@code 2 - 1 = 1}, 已经是负数了, 不需要修改</li>
     *         <li>这样只有{@code nums[2]}是正数, 所以将{@code 2 + 1 = 3}作为结果返回</li>
     *     </ol>
     * </p>
     * </p>
     *
     * @param nums 一个数组
     * @return 数组中消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 第一次遍历数组
        // 根据相应的数字去找索引
        // 将相应索引位置的数改成负数
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        // 第二次遍历数组
        // 将所有大于0的数的索引作为结果返回
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
