package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/">303. 区域和检索 - 数组不可变</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个整数数组{@code nums}, 求出数组从索引{@code i}到{@code j}({@code i <= j})范围内元素的总和, 包含{@code i, j}两点<br>
 * 实现{@link NumArray}类:<br>
 * 1. {@link NumArray#NumArray(int[])}使用数组{@code nums}初始化对象<br>
 * 2. {@link NumArray#sumRange(int, int)}返回数组{@code nums}从索引{@code i}到{@code j}({@code i <= j})范围内元素的总和,
 *    包含{@code i, j}两点(也就是{@code sum(nums[i], nums[i + 1], ... , nums[j])})<br>
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入:
 * <pre>
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * </pre>
 * 输出: {@code [null, 1, -1, -3]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= nums.length <= 10^4</b></li>
 *     <li><b>-10^5 <= nums[i] <= 10^5</b></li>
 *     <li><b>0 <= i <= j < nums.length</b></li>
 *     <li><b>最多调用10^4次sumRange方法</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ303 extends AbstractSolution {
    /**
     * 本题使用的数据结构
     */
    private NumArray array;

    /**
     * 默认构造器, 实例化{@link NumArray}对象
     *
     * @param array 一个数组
     */
    public SolutionQ303(int[] array) {
        this.array = new NumArray(array);
    }

    /**
     * {@inheritDoc}
     *
     * @param obj  索引位置i
     * @param obj1 索引位置j
     * @return 两索引之间的元素和
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof Integer && obj1 instanceof Integer) {
            return this.array.sumRange((int) obj, (int) obj1);
        }
        return null;
    }
}

/**
 * 本题使用的数据结构<br>
 * 通过这个数据结构应该能够快速得到索引位置{@code i}和索引位置{@code j}之间的元素和
 *
 * @author lixiangyu
 */
class NumArray {
    /**
     * 保存前缀和的数组
     */
    private int[] preSum;

    /**
     * 默认构造器, 在这里需要对数组做特殊处理, 尽量降低查找时的时间复杂度
     *
     * @param nums 一个数组
     */
    public NumArray(int[] nums) {
        // 数组长度
        int n = nums.length;
        /*
         * 如果最后返回的是: preSum[i, j] = preSum[j] - preSum[i - 1]
         * 在索引0处需要做特殊判断, 为了避免这种情况, 整体向右移一位, 相应的长度需要加1
         */
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    /**
     * 得到索引位置{@code i}和索引位置{@code j}之间的元素和
     *
     * <p>
     * 思路:<br>
     * 最简单的思路是在每次查询的时候遍历数组, 时间复杂度是{@code O(∑)}(∑是两索引间的元素个数),
     * 在反复查询的场景下, 可能会导致超时<br>
     * 所以使用前缀和对数组做预处理, 使计算元素和的时间复杂度将为{@code O(1)}<br>
     * <b>注: 前缀和是指第一个元素到第{@code i}个元素之间的和</b>
     * </p>
     *
     * @param i 一个索引位置
     * @param j 一个索引位置
     * @return 这两个索引之间的元素和
     */
    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}
