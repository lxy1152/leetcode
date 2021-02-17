package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/reshape-the-matrix/submissions/">566. 重塑矩阵</a>
 *
 * <p>
 * 描述:<br>
 * 在MATLAB中, 有一个非常有用的函数{@code reshape}, 它可以将一个矩阵重塑为另一个大小不同的新矩阵并保留其原始数据<br>
 * 给出一个由二维数组表示的矩阵, 以及两个正整数{@code r}和{@code c}, 分别表示想要的重构的矩阵的行数和列数<br>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充<br>
 * 如果具有给定参数的{@code reshape}操作是可行且合理的, 则输出新的重塑矩阵；否则, 输出原始矩阵
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code nums = [[1, 2], [3, 4]], r = 1, c = 4}<br>
 * 输出: {@code [[1, 2, 3, 4]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code nums = [[1, 2], [3, 4]], r = 2, c = 4}<br>
 * 输出: {@code [[1, 2], [3, 4]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>给定矩阵的宽和高范围在[1, 100]</b></li>
 *     <li><b>给定的{@code r}和{@code c}都是正数</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ566 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 一个原始的二维矩阵, 新矩阵的行数, 新矩阵的列数
     * @return 如果可以重塑就返回新矩阵否则返回原矩阵
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof int[][] && objects[1] instanceof Integer && objects[2] instanceof Integer) {
            return matrixReshape((int[][]) objects[0], (int) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 重塑矩阵
     *
     * <p>
     * 思路:<br>
     * 首先将二维矩阵拍成一维矩阵, 再将一维矩阵转为新矩阵<br>
     * 二维矩阵中的某个值{@code (i, j)}与一维矩阵中的某个值{@code x}之间的映射关系为:<br>
     * {@code x = i * n + j}<br>
     * {@code i = x / n}<br>
     * {@code j = x % n}<br>
     * 可以使用另外一个数组作为过渡, 但实际上有了上面的映射关系以后直接根据公式去找更方便
     * </p>
     *
     * @param nums 一个原始的二维矩阵
     * @param r    新矩阵的行数
     * @param c    新矩阵的列数
     * @return 如果可以重塑就返回新矩阵否则返回原矩阵
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        // 如果不能重塑矩阵则返回原矩阵
        if (m * n != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            // 根据上面提到的映射关系去原矩阵和新矩阵中找对应的元素
            result[i / c][i % c] = nums[i / n][i % n];
        }
        return result;
    }
}
