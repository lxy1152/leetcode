package xyz.lixiangyu.algorithm.common.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/range-sum-query-2d-immutable/">304. 二维区域和检索 - 矩阵不可变</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个二维矩阵, 计算其子矩形范围内元素的总和, 假设该子矩阵的左上角为{@code (row1, col1)}, 右下角为{@code (row2, col2)}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入矩阵:
 * <pre>
 * 3  0  1  4  2
 * 5  6  3  2  1
 * 1  2  0  1  5
 * 4  1  0  1  7
 * 1  0  3  0  5
 * </pre>
 * 输出:<br>
 * {@code sumRegion(2, 1, 4, 3) -> 8}<br>
 * {@code sumRegion(1, 1, 2, 2) -> 11}<br>
 * {@code sumRegion(1, 2, 2, 4) -> 12}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>你可以假设矩阵不可变</b></li>
 *     <li><b>会多次调用{@link NumMatrix#sumRegion}方法</b></li>
 *     <li><b>你可以假设 row1 <= row2 且 col1 <= col2</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ304 extends AbstractSolution {
    /**
     * 本题使用的数据结构
     */
    private NumMatrix numMatrix;

    /**
     * 默认构造器, 实例化{@link NumMatrix}对象
     *
     * @param matrix 一个数组
     */
    public SolutionQ304(int[][] matrix) {
        this.numMatrix = new NumMatrix(matrix);
    }

    /**
     * {@inheritDoc}
     *
     * @param objects 元素的行列值
     * @return 子矩阵的元素和
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof Integer && objects[1] instanceof Integer && objects[2] instanceof Integer
                && objects[3] instanceof Integer) {
            return numMatrix.sumRegion((int) objects[0], (int) objects[1], (int) objects[2], (int) objects[3]);
        }
        return null;
    }
}

/**
 * 本题使用的数据结构<br>
 * 通过这个数据结构应该能够快速得到矩阵中某子矩阵的元素和
 *
 * @author lixiangyu
 */
class NumMatrix {
    /**
     * 保存前缀和的数组
     */
    private int[][] preSum;

    /**
     * 默认构造器, 在这里需要对矩阵做特殊处理(计算前缀和), 尽量降低查找时的时间复杂度,
     * 最好画图来理解(其实就是计算面积)
     *
     * @param matrix 一个矩阵
     */
    public NumMatrix(int[][] matrix) {
        // 注意题目在这里并没有保证行数一定大于0
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            preSum = new int[m + 1][n + 1];
            // 为了避免在索引0处的特殊处理, 将i, j统一做加1处理
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    /**
     * 得到某子矩阵的元素和
     *
     * <p>
     * 思路:<br>
     * 一维数组还可以暴力破解, 二维矩阵就不太可能了, 类似{@link SolutionQ303}的思路, 计算矩阵中每个子矩阵的前缀和
     * </p>
     *
     * @param row1 第一个元素所在的行
     * @param col1 第一个元素所在的列
     * @param row2 第二个元素所在的行
     * @param col2 第二个元素所在的列
     * @return 这个子矩阵的元素和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.preSum[row2 + 1][col2 + 1] - this.preSum[row1][col2 + 1]
                - this.preSum[row2 + 1][col1] + this.preSum[row1][col1];
    }
}
