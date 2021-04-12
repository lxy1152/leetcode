package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/largest-number/">179. 最大数</a>
 *
 * <p>
 * 描述:<br>
 * 给定一组非负整数{@code nums}, 重新排列每个数的顺序(每个数不可拆分)使之组成一个最大的整数<br>
 * 输出结果可能非常大, 所以你需要返回一个字符串而不是整数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [10, 2]}<br>
 * 输出: {@code "210"}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [3, 30, 34, 5, 9]}<br>
 * 输出: {@code "9534330"}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code nums = [1]}<br>
 * 输出: {@code "1"}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code nums = [10]}<br>
 * 输出: {@code "10"}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>1 <= nums.length <= 100</li>
 *     <li>0 <= nums[i] <= 10^9</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ179 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 能组成的最大整数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return largestNumber((int[]) obj);
        }
        return null;
    }

    /**
     * 计算能组成的最大整数
     *
     * <p>
     * 思路:<br>
     * 为了避免溢出, 先将{@code int}型数组转为字符串数组, 通过{@code (a, b) -> (b + a).compareTo(a + b)}
     * 做排序即可<br>
     * 注意需要考虑"00"这种情况
     * </p>
     *
     * @param nums 一个数组
     * @return 能组成的最大整数
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 把数字转为字符串
        String[] numsToWord = new String[n];
        for (int i = 0; i < n; i++) {
            numsToWord[i] = String.valueOf(nums[i]);
        }
        // ["120", "110", "300", "1"]排序后变为["300", "120", "1", "110"]
        Arrays.sort(numsToWord, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(numsToWord[i]);
        }
        String result = stringBuilder.toString();
        // 有"00"的情况
        return result.charAt(0) == '0' ? "0" : result;
    }
}
