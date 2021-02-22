package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/toeplitz-matrix/">766. 托普利茨矩阵</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个{@code m × n}的矩阵{@code matrix}, 如果这个矩阵是托普利茨矩阵, 返回{@code true}, 否则返回{@code false}<br>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同, 那么这个矩阵是托普利茨矩阵
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 2, 3, 4],[5, 1, 2, 3],[9, 5, 1, 2]]}<br>
 * 输出: {@code true}<br>
 *
 * 矩阵如下:
 * <pre>
 * 1    2    3    4
 * 5    1    2    3
 * 9    5    1    2
 * </pre>
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[1, 2],[2, 2]]}<br>
 * 输出: {@code false}<br>
 *
 * 矩阵如下:
 * <pre>
 * 1    2
 * 2    2
 * </pre>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>m == matrix.length</b></li>
 *     <li><b>n == matrix[i].length</b></li>
 *     <li><b>1 <= m, n <= 20</b></li>
 *     <li><b>0 <= matrix[i][j] <= 99</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ766 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个矩阵
     * @return 是否是托普利茨矩阵
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            return isToeplitzMatrix((int[][]) obj);
        }
        return null;
    }

    /**
     * 判断是否是托普利茨矩阵
     *
     * <p>
     * 思路:<br>
     * 遍历矩阵, 判断当前元素和右下角的元素是否相等
     * </p>
     *
     * @param matrix 一个矩阵
     * @return 是否是托普利茨矩阵
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
