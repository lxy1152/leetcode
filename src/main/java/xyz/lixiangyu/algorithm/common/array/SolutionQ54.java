package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/spiral-matrix/">54. 螺旋矩阵</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个{@code m}行{@code n}列的矩阵{@code matrix}, 请按照顺时针螺旋顺序, 返回矩阵中的所有元素
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]}<br>
 * 输出: {@code [1, 2, 3, 6, 9, 8, 7, 4, 5]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]}<br>
 * 输出: {@code [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>m == matrix.length</b></li>
 *     <li><b>n == matrix[i].length</b></li>
 *     <li><b>1 <= m, n <= 10</b></li>
 *     <li><b>-100 <= matrix[i][j] <= 100</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ54 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个矩阵
     * @return 按照顺时针螺旋的顺序返回矩阵中的所有元素
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            return spiralOrder((int[][]) obj);
        }
        return null;
    }

    /**
     * 按照顺时针螺旋的顺序返回矩阵中的所有元素
     *
     * <p>
     * 思路:<br>
     * 按照顺时针顺序模拟遍历矩阵
     * </p>
     *
     * @param matrix 一个矩阵
     * @return 按照顺时针螺旋的顺序返回矩阵中的所有元素
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 保存结果
        List<Integer> result = new ArrayList<>();

        // 矩阵的行列数
        int rows = matrix.length;
        int columns = matrix[0].length;

        // 判断矩阵的某个格是否访问过了
        boolean[][] visited = new boolean[rows][columns];

        // 定义遍历的方向, 对于右、下、左、上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 当前的行列
        int row = 0;
        int column = 0;

        int directionIndex = 0;

        // 遍历矩阵
        for (int i = 0; i < rows * columns; i++) {
            // 把当前格放入结果中
            result.add(matrix[row][column]);
            // 设置为已访问
            visited[row][column] = true;

            // 先试一试下一个格的可能位置
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            // 如果触碰边缘了, 需要改变方向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            // 计算真正的下一个格的位置
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return result;
    }
}
