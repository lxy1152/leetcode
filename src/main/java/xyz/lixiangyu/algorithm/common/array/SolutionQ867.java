package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/transpose-matrix/">867. 转置矩阵</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个二维整数数组{@code matrix}, 返回{@code matrix}的转置矩阵<br>
 * 矩阵的转置是指将矩阵的主对角线翻转, 交换矩阵的行索引与列索引
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]}<br>
 * 输出: {@code [[1, 4, 7], [2, 5, 8], [3, 6, 9]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[1, 2, 3], [4, 5, 6]]}<br>
 * 输出: {@code [[1, 4], [2, 5], [3, 6]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>m == matrix.length</b></li>
 *     <li><b>n == matrix[i].length</b></li>
 *     <li><b>1 <= m, n <= 1000</b></li>
 *     <li><b>1 <= m * n <= 10^5</b></li>
 *     <li><b>-10^9 <= matrix[i][j] <= 10^9</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ867 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个矩阵
     * @return 转置后的矩阵
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            return transpose((int[][]) obj);
        }
        return null;
    }

    /**
     * 获得转置矩阵
     *
     * <p>
     * 思路:<br>
     * 遍历数组, 交换对角线元素<br>
     * 由于转置矩阵和原矩阵的行列数不一定相同, 所以不能直接修改原矩阵
     * </p>
     *
     * @param matrix 一个矩阵
     * @return 转置后的矩阵
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // result是转置后的, 所以索引应该是[j, i]
                // [j, i]所对应的对角线位置是[i, j]
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
