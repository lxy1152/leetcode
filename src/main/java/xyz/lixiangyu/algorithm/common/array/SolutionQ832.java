package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/flipping-an-image/">832. 翻转图像</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个二进制矩阵{@code A}, 我们想先水平翻转图像, 然后反转图像并返回结果<br>
 * 水平翻转图片就是将图片的每一行都进行翻转, 即逆序. 例如, 水平翻转{@code [1, 1, 0]}的结果是{@code [0, 1, 1]}<br>
 * 反转图片的意思是图片中的{@code 0}全部被{@code 1}替换, {@code 1}全部被{@code 0}替换,
 * 例如, 反转{@code [0, 1, 1]}的结果是{@code [1, 0, 0]}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [[1, 1, 0], [1, 0, 1], [0, 0, 0]]}<br>
 * 输出: {@code [[1, 0, 0], [0, 1, 0], [1, 1, 1]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]]}<br>
 * 输出: {@code [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= A.length = A[0].length <= 20</b></li>
 *     <li><b>0 <= A[i][j] <= 1</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ832 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个二维数组
     * @return 翻转后的数组
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[][]) {
            return flipAndInvertImage((int[][]) obj);
        }
        return null;
    }

    /**
     * 翻转后的数组
     *
     * <p>
     * 思路:<br>
     * 遍历数组, 将数字取反并调换
     * </p>
     *
     * @param a 一个二维数组
     * @return 翻转后的数组
     */
    public int[][] flipAndInvertImage(int[][] a) {
        // 数组长度
        int m = a.length;
        int n = a[0].length - 1;
        // 行遍历
        for (int i = 0; i < m; i++) {
            // 列只需要遍历一半就够了
            for (int j = 0; j <= n / 2; j++) {
                // 将当前位置的数字和对应位置的数字替换
                // 需要通过异或取反
                int temp = a[i][j] ^ 1;
                a[i][j] = a[i][n - j] ^ 1;
                a[i][n - j] = temp;
            }
        }
        return a;
    }
}
