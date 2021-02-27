package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/monotonic-array/">896. 单调数列</a>
 *
 * <p>
 * 描述:<br>
 * 如果数组是单调递增或单调递减的, 那么它是单调的<br>
 * 如果对于所有{@code i <= j}, {@code A[i] <= A[j]}, 那么数组{@code A}是单调递增的<br>
 * 如果对于所有{@code i <= j}, {@code A[i] >= A[j]}, 那么数组{@code A}是单调递减的<br>
 * 当给定的数组{@code A}是单调数组时返回{@code true}, 否则返回{@code false}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 2, 2, 3]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [6, 5, 4, 4]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code [1, 3, 2]}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code [1, 2, 4, 5]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出5:<br>
 * 输入: {@code [1, 1, 1]}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length <= 50000</b></li>
 *     <li><b>-100000 <= A[i] <= 100000</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ896 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 是否是单调的
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return isMonotonic((int[]) obj);
        }
        return null;
    }

    /**
     * 判断一个数组是否是单调的
     *
     * <p>
     * 思路:<br>
     * 根据头两个不相等元素就可以得到数组的单调性了, 后面每两个不同元素的单调性如果跟这个单调性不相同
     * 就返回{@code false}, 否则返回{@code true}
     * </p>
     *
     * @param a 一个数组
     * @return 是否是单调的
     */
    public boolean isMonotonic(int[] a) {
        // 数组长度
        int n = a.length;
        // 保存头两个不相等元素的比较结果, 因为根据这两个元素的结果就能够确定单调性了
        int pre = 0;
        // 从索引1的位置开始遍历, 如果长度就是1则直接返回true
        for (int i = 1; i < n; i++) {
            // 如果两个数是相等的, 那么对于单调性是没有影响的, 直接跳过
            if (a[i] != a[i - 1]) {
                if (pre == 0) {
                    // 保存头两个元素的比较结果
                    pre = a[i] > a[i - 1] ? 1 : -1;
                } else if ((a[i] > a[i - 1] ? 1 : -1) != pre) {
                    // 如果当前两元素的比较结果和之间的结果不符, 直接返回false
                    return false;
                }
            }
        }
        return true;
    }
}
