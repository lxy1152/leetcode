package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/">1011. 在 D 天内送达包裹的能力</a>
 *
 * <p>
 * 描述:<br>
 * 传送带上的包裹必须在{@code D}天内从一个港口运送到另一个港口<br>
 * 传送带上的第{@code i}个包裹的重量为{@code weights[i]}, 每一天我们都会按给出重量的顺序往传送带上装载包裹, 我们装载的重量不会超过船的最大运载重量<br>
 * 返回能在{@code D}天内将传送带上的所有包裹送达的船的最低运载能力
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], D = 5}<br>
 * 输出: {@code 15}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code weights = [3, 2, 2, 4, 1, 4], D = 3}<br>
 * 输出: {@code 6}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code weights = [1, 2, 3, 1, 1], D = 4}<br>
 * 输出: {@code 3}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= D <= weights.length <= 50000</b></li>
 *     <li><b>1 <= weights[i] <= 500</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1011 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  每个货物的重量
     * @param obj1 目标天数
     * @return 最低货运量
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return shipWithinDays((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算在{@code d}天内运完所有货物的最低货运量
     *
     * <p>
     * 思路:<br>
     * 如果货物一天就能运完, 那么货运量=所有货物的重量和<br>
     * 如果只保证货物能够运走(不考虑天数), 那么货运量=最重的货物的重量<br>
     * 满足题意的货运量肯定位于这两个值之间, 所以可以使用二分查找来解决
     * </p>
     *
     * @param weights 每个货物的重量
     * @param d       目标天数
     * @return 最低货运量
     */
    public int shipWithinDays(int[] weights, int d) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int l = max;
        int r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, d)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 检查在指定货运量的情况下, {@code d}天内能否将所有货物运送完
     *
     * @param ws 所有货物的重量
     * @param t  货运量
     * @param d  目标天数
     * @return 能否运送
     */
    public boolean check(int[] ws, int t, int d) {
        int n = ws.length;
        int cnt = 1;
        int sum = ws[0];
        for (int i = 1; i < n; cnt++) {
            while (i < n && sum + ws[i] <= t) {
                sum += ws[i];
                i++;
            }
            sum = 0;
        }
        return cnt - 1 <= d;
    }
}
