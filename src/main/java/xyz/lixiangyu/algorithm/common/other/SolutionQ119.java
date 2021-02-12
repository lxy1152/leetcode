package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.algorithm.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">119. 杨辉三角II</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个非负索引{@code k}, 其中{@code k ≤ 33}, 返回杨辉三角的第{@code k}行。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code 3}<br>
 * 输出: {@code [1, 3, 3, 1]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>能否将空间复杂度优化到{@code O(k)}</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ119 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数值表示杨辉三角的某一行
     * @return 返回该行的所有值
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof Integer && obj1 instanceof String) {
            if (Constants.FAST_SOLUTION.equals(obj1)) {
                return getRowFast((int) obj);
            }
            return getRowCommon((int) obj);
        }
        return null;
    }

    /**
     * 计算杨辉三角某一行的元素
     *
     * <p>
     * 思路:<br>
     * 某行的某一个元素等于上一行的左右两个数字之和, 可以利用这个性质做计算
     * </p>
     *
     * @param rowIndex 一个数值表示杨辉三角的某一行
     * @return 该行的所有元素
     */
    public List<Integer> getRowCommon(int rowIndex) {
        // 保存小于等于rowIndex的所有行的记录
        List<List<Integer>> C = new ArrayList<>();
        // 向List中添加每行的记录
        for (int i = 0; i <= rowIndex; i++) {
            // 储存每行的记录
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 如果是两头的元素, 因为C_n^0 = C_n^n = 1, 所以直接给1
                // 其他情况取上一行的j - 1和j位置的两个元素并求和
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

    /**
     * 快速计算杨辉三角某一行的元素
     *
     * <p>
     * 思路:<br>
     * 通过递推式{@code C_n^m = C_n^{m-1} * (n -  m + 1) / m}
     * 根据上一个元素计算下一个元素的值
     * </p>
     *
     * <p>
     * <b>注意: 索引都是从0开始的</b>
     * </p>
     *
     * @param rowIndex 某行
     * @return 该行的所有元素
     */
    public List<Integer> getRowFast(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // 第一个数是C_n^0, 一定是1
        row.add(1);
        // 根据前一个数计算后一个数
        for (int i = 1; i <= rowIndex; ++i) {
            // 下面两种写法都可以
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            // row.add((int) (row.get(i - 1) * ((double) rowIndex - i + 1) / i));
        }
        return row;
    }
}
