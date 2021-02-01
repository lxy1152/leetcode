package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.constants.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/fair-candy-swap/">888. 公平的糖果棒交换</a>
 *
 * <p>
 * 描述:<br>
 * Alice和Bob有不同大小的糖果棒：{@code A[i]}是Alice拥有的第{@code i}根糖果棒的大小,
 * {@code B[j]}是Bob拥有的第{@code j}根糖果棒的大小.<br>
 * 因为他们是朋友, 所以他们想交换一根糖果棒, 这样交换后, 他们都有相同的糖果总量(一个人拥有的糖果总量是他们拥有的糖果棒大小的总和)<br>
 * 返回一个整数数组{@code ans}, 其中{@code ans[0]}是Alice必须交换的糖果棒的大小, {@code ans[1]}是Bob必须交换的糖果棒的大小.<br>
 * 如果有多个答案, 你可以返回其中任何一个. 保证答案存在.
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code A = [1, 1], B = [2, 2]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code A = [1, 2], B = [2, 3]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code A = [2], B = [1, 3]}<br>
 * 输出: {@code [2, 3]}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code A = [1, 2, 5], B = [2, 4]}<br>
 * 输出: {@code [5, 4]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 10000</b></li>
 *     <li><b>1 <= B.length <= 10000</b></li>
 *     <li><b>1 <= A[i] <= 100000</b></li>
 *     <li><b>1 <= B[i] <= 100000</b></li>
 *     <li><b>保证Alice与Bob的糖果总量不同</b></li>
 *     <li><b>答案肯定存在</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ888 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  Alice的糖果
     * @param obj1 Bob的糖果
     * @return 需要交换的糖果
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof int[]) {
            return fairCandySwap((int[]) obj, (int[]) obj1);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param objects Alice的糖果, Bob的糖果, 需要调用的解决方案
     * @return 需要交换的糖果
     */
    @Override
    public Object solve(Object... objects) {
        if (objects.length == 3
                && objects[0] instanceof int[]
                && objects[1] instanceof int[]
                && objects[2] instanceof String) {
            if (Constants.FAST_SOLUTION.equals(objects[2])) {
                return fairCandySwapUserStableArray((int[]) objects[0], (int[]) objects[1]);
            }
            return fairCandySwap((int[]) objects[0], (int[]) objects[1]);
        }
        return null;
    }

    /**
     * 交换糖果
     *
     * <p>
     * 思路:<br>
     * 假设Alice的糖果总量为{@code SumA}, Alice要交换的糖果质量为{@code x}<br>
     * Bob的糖果总量为{@code SumB}, Bob要交换的糖果质量为{@code y}<br>
     * 那么{@code SumA - x + y = SumB - y + x}, 可以推出{@code x = y - (SumB - SumA) / 2}<br>
     * 也就是说, 如果根据Bob手中的糖果大小可以找到一个Alice手中的糖果大小与之对应, 即为答案
     * </p>
     *
     * <p>在代码的实现上采用了哈希和流的结合</p>
     *
     * @param a Alice的糖果
     * @param b Bob的糖果
     * @return 双方需要交换的糖果
     */
    public int[] fairCandySwap(int[] a, int[] b) {
        // 用来保存结果的数组
        int[] result = new int[2];

        // 计算总和
        // 注意这里别写反了, 是b - a
        int sum = Arrays.stream(b).sum() - Arrays.stream(a).sum();
        sum = sum / 2;

        // 将Alice的每个糖果大小保存在HashMap中
        Set<Integer> set = new HashSet<>(a.length);
        for (int weight : a) {
            set.add(weight);
        }

        // 遍历Bob的糖果, 找到答案
        for (int weight : b) {
            if (set.contains(weight - sum)) {
                result[0] = weight - sum;
                result[1] = weight;
                break;
            }
        }
        return result;
    }

    /**
     * 上面的方法使用哈希和流, 速度太慢了<br>
     * 因为本题对数字有规模限制, 所以可以直接使用规模固定的数组用于判断
     *
     * @param a Alice的糖果
     * @param b Bob的糖果
     * @return 要交换的糖果
     */
    public int[] fairCandySwapUserStableArray(int[] a, int[] b) {
        // 因为数字的最大值是100000, 所以建一个固定大小的数组来记录a中的数是否出现过
        boolean[] flag = new boolean[100001];
        // 对b数组求和
        int sum = Arrays.stream(b).sum();
        // 遍历a数组, 计算b - a, 同时在flag数组中记录
        for (int num : a) {
            sum -= num;
            flag[num] = true;
        }
        // 计算(b - a) / 2
        sum = sum / 2;
        // 用于保存结果
        int[] result = new int[2];
        // 遍历b数组, 查找答案
        for (int num : b) {
            int t = num - sum;
            if (flag[t]) {
                result[0] = t;
                result[1] = num;
                break;
            }
        }
        return result;
    }
}
