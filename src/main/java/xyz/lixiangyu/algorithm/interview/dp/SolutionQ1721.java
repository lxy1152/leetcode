package xyz.lixiangyu.algorithm.interview.dp;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/volume-of-histogram-lcci/">面试题 17.21. 直方图的水量</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个直方图(也称柱状图), 假设有人从上面源源不断地倒水, 最后直方图能存多少水量? 直方图的宽度为{@code 1}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]}<br>
 * 输出: {@code 6}
 * </p>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1721 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 存水量
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return trap((int[]) obj);
        }
        return null;
    }

    /**
     * 计算直方图的存水量
     *
     * <p>
     * 思路:<br>
     * 每个位置放水的量取决于两侧的最高高度, 通过动态规划计算最大高度再减去自身高度就是最终的结果
     * </p>
     *
     * @param height 一个数组
     * @return 存水量
     */
    public int trap(int[] height) {
        // 数组高度
        int n = height.length;

        // 题目没有限制数量一定大于0, 如果数量为0, 需要返回0
        if (n == 0) {
            return 0;
        }

        // 表示i位置的左侧最大高度
        int[] leftHeightMax = new int[n];
        // 表示i位置的右侧最大高度
        int[] rightHeightMax = new int[n];

        // 0位置的左侧最大高度是自身
        leftHeightMax[0] = height[0];
        // n-1位置的右侧最大高度是自身
        rightHeightMax[n - 1] = height[n - 1];

        // dp计算最大高度
        for (int i = 1; i < n; i++) {
            leftHeightMax[i] = Math.max(leftHeightMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightHeightMax[i] = Math.max(rightHeightMax[i + 1], height[i]);
        }

        // 保存结果
        int result = 0;
        // 两侧高度的最小值-自身高度就是可以防水的量
        for (int i = 0; i < n; i++) {
            result += Math.min(leftHeightMax[i], rightHeightMax[i]) - height[i];
        }

        return result;
    }
}
