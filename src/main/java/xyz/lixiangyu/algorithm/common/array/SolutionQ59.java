package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">59. 螺旋矩阵 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个正整数{@code n}, 生成一个包含{@code 1}到{@code n^2}所有元素, 且元素按顺时针顺序螺旋排列的{@code n x n}
 * 正方形矩阵{@code matrix}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code n = 3}<br>
 * 输出: {@code [[1, 2, 3], [8, 9, 4], [7, 6, 5]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code n = 1}<br>
 * 输出: {@code [[1]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= n <= 20 </b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ59 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数字
     * @return 按照顺时针顺序排列的矩阵
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return generateMatrix((int) obj);
        }
        return null;
    }

    /**
     * 按照顺时针顺序排列的矩阵
     *
     * <p>
     * 思路:<br>
     * 思路基本同{@linkplain SolutionQ59 54. 螺旋矩阵}, 不过不需要额外的{@code visited}
     * 数组来判断是否访问过了, 由于初值是{@code 0}, 并且填入的数字一定是大于{@code 0}的,
     * 所以根据{@code 0}就可以判断是否访问过了
     * </p>
     *
     * @param n 一个数字
     * @return 按照顺时针顺序排列的矩阵
     */
    public int[][] generateMatrix(int n) {
        // 保存结果
        int[][] result = new int[n][n];

        // 定义遍历的方向
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //  方向数组的索引
        int directionIndex = 0;

        // 当前的行列
        int row = 0;
        int col = 0;

        // 遍历并向数组中填入结果
        for (int i = 1; i <= n * n; i++) {
            result[row][col] = i;

            // 先计算一下沿着当前方向的下一个格的位置
            int tempRow = row + directions[directionIndex][0];
            int tempCol = col + directions[directionIndex][1];

            // 如果这个位置不可行, 需要改变方向
            if (tempRow < 0 || tempRow >= n || tempCol < 0 || tempCol >= n || result[tempRow][tempCol] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }

            // 获得真正的下一个格的位置
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return result;
    }
}
