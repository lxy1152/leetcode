package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">73. 矩阵置零</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个{@code m x n}的矩阵, 如果一个元素为{@code 0}, 则将其所在行和列的所有元素都设为{@code 0}, 请使用原地算法
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]}<br>
 * 输出: {@code [[1, 0, 1], [0, 0, 0], [1, 0, 1]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]}<br>
 * 输出: {@code [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>m == matrix.length</b></li>
 *     <li><b>n == matrix[0].length</b></li>
 *     <li><b>1 <= m, n <= 200</b></li>
 *     <li><b>-2^31 <= matrix[i][j] <= 2^31 - 1</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ73 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个矩阵
     * @return 置零后的矩阵
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            setZeroes((int[][]) obj);
        }
        return obj;
    }

    /**
     * 矩阵置零
     *
     * <p>
     * 思路:<br>
     * 记录出现0的位置, 然后将所在行列置零
     * </p>
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZero.contains(i) || colZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
