package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/counting-bits/">354. 俄罗斯套娃信封问题</a>
 *
 * <p>
 * 描述:<br>
 * 给定一些标记了宽度和高度的信封, 宽度和高度以整数对形式{@code (w, h)}出现<br>
 * 当另一个信封的宽度和高度都比这个信封大的时候, 这个信封就可以放进另一个信封里, 如同俄罗斯套娃一样
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>不允许旋转信封</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ354 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 信封
     * @return 可最大套娃的信封个数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            return maxEnvelopes((int[][]) obj);
        }
        return null;
    }

    /**
     * 求最大可套娃的信封个数
     *
     * <p>
     * 思路:<br>
     * 对"宽"做升序排列, 如果"宽"相同再对"高"做降序排列, 对"高"求LIS即可<br>
     * 对"高"做降序排列是因为
     * </p>
     *
     * @param envelopes 信封
     * @return 可最大套娃的信封个数
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 信封个数
        int n = envelopes.length;
        // 将信封根据"宽高"重新排序
        // "宽"是升序排列, 如果"宽"相同, "高"为降序排序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // 对"高"求LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return DynamicProgramming.longestIncreasingSubsequenceUseDp(height);
    }
}
