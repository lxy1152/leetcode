package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/">1423. 可获得的最大点数</a>
 *
 * <p>
 * 描述:<br>
 * 几张卡牌排成一行, 每张卡牌都有一个对应的点数, 点数由整数数组{@code cardPoints}给出<br>
 * 每次行动, 你可以从行的开头或者末尾拿一张卡牌, 最终你必须正好拿{@code k}张卡牌<br>
 * 你的点数就是你拿到手中的所有卡牌的点数之和<br>
 * 给你一个整数数组{@code cardPoints}和整数{@code k}, 请你返回可以获得的最大点数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code cardPoints = [1, 2, 3, 4, 5, 6, 1], k = 3}<br>
 * 输出: {@code 12}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code cardPoints = [2, 2, 2], k = 2}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code cardPoints = [9, 7, 7, 9, 7, 7, 9], k = 7}<br>
 * 输出: {@code 55}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code cardPoints = [1, 1000, 1], k = 1}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出5:<br>
 * 输入: {@code cardPoints = [1, 79, 80, 1, 1, 1, 200, 1], k = 3}<br>
 * 输出: {@code 202}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= cardPoints.length <= 10^5</b></li>
 *     <li><b>1 <= cardPoints[i] <= 10^4</b></li>
 *     <li><b>1 <= k <= cardPoints.length</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1423 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个储存卡牌点数的数组
     * @param obj1 最多能拿的卡牌数量
     * @return 能拿到的最大点数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return maxScore((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算可以获得最大点数
     *
     * <p>
     * 思路:<br>
     * 使用滑动窗口<br>
     * 逆向思考: <br>
     * 返回的结果是能够取得的最大点数, 那么就意味着{@code cardPoints.length - k}个连续元素要取最小值
     * </p>
     *
     * @param cardPoints 一个储存卡牌点数的数组
     * @param k          最多能拿的卡牌数量
     * @return 能拿到的最大点数
     */
    public int maxScore(int[] cardPoints, int k) {
        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        if (k == cardPoints.length) {
            return Arrays.stream(cardPoints).sum();
        }
        // 点数数组的长度
        int n = cardPoints.length;
        // 滑动窗口的大小
        int size = n - k;
        // 当前窗口的点数大小
        int sum = 0;
        // 取第一个窗口的数据作为初始值
        for (int i = 0; i < size; i++) {
            sum += cardPoints[i];
        }
        // 保存历史窗口中的点数和的最小值
        int minSum = sum;
        // 窗口右移
        for (int i = size; i < cardPoints.length; i++) {
            // 加上新移入窗口的点数
            sum += cardPoints[i];
            // 减去移出窗口的点数
            sum -= cardPoints[i - size];
            // 取最小值
            minSum = Math.min(minSum, sum);
        }
        // 返回的结果是数组中所有点数的和减去历史窗口中的点数最小值
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
