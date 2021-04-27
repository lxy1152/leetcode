package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * <a href="https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/">363. 矩形区域不超过 K 的最大数值和</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个{@code m x n}的矩阵{@code matrix}和一个整数{@code k}, 找出并返回矩阵内部矩形区域的不超过{@code k}的最大数值和<br>
 * 题目数据保证总会存在一个数值和不超过{@code k}的矩形区域
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 0, 1], [0, -2, 3]], k = 2}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[2, 2, -1]], k = 3}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>m == matrix.length</li>
 *     <li>n == matrix[i].length</li>
 *     <li>1 <= m, n <= 100</li>
 *     <li>-100 <= matrix[i][j] <= 100</li>
 *     <li>-105 <= k <= 105</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ363 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个矩阵
     * @param obj1 目标值
     * @return 不超过目标值的最大区域和
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[][] && obj1 instanceof Integer) {
            return maxSumSubmatrix((int[][]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 找出不超过目标值的最大区域和
     *
     * @param matrix 一个矩阵
     * @param k      目标值
     * @return 不超过目标值的最大区域和
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        boolean isRight = n > m;
        int[] sum = isRight ? new int[n + 1] : new int[m + 1];
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= (isRight ? m : n); i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++) {
                    sum[fixed] += isRight ? matrix[j - 1][fixed - 1] : matrix[fixed - 1][j - 1];
                    a += sum[fixed];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }
}
