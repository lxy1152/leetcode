package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">74. 搜索二维矩阵</a>
 *
 * <p>
 * 描述:<br>
 * 编写一个高效的算法来判断一个{@code m x n}的矩阵中, 是否存在一个目标值, 该矩阵具有如下特性:<br>
 * 1. 每行中的整数从左到右按升序排列<br>
 * 2. 每行的第一个整数大于前一行的最后一个整数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 3}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 13}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>m == matrix.length</b></li>
 *     <li><b>n == matrix[i].length</b></li>
 *     <li><b>1 <= m, n <= 100</b></li>
 *     <li><b>-10^4 <= matrix[i][j], target <= 10^4</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ74 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个二维数组
     * @param obj1 目标值
     * @return 在矩阵中是否存在目标值
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[][] && obj1 instanceof Integer) {
            return searchMatrix((int[][]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 搜索矩阵中是否有目标值
     *
     * <p>
     * 思路:<br>
     * 根据题目中给定的矩阵性质, 这个矩阵扁平化成一维数组后是升序的, 所以可以直接对这个矩阵做二分查找, 相应的{@code low}
     * 和{@code high}需要做映射
     * </p>
     *
     * @param matrix 一个二维数组
     * @param target 目标值
     * @return 在矩阵中是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
