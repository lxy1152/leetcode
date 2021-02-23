package xyz.lixiangyu.algorithm.common.slidingwindow;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/grumpy-bookstore-owner/">1052. 爱生气的书店老板</a>
 *
 * <p>
 * 描述:<br>
 * 今天, 书店老板有一家店打算试营业{@code customers.length}分钟, 每分钟都有一些顾客({@code customers[i]})会进入书店,
 * 所有这些顾客都会在那一分钟结束后离开<br>
 * 在某些时候, 书店老板会生气, 如果书店老板在第{@code i}分钟生气, 那么{@code grumpy[i] = 1}, 否则{@code grumpy[i] = 0},
 * 当书店老板生气时, 那一分钟的顾客就会不满意, 不生气则他们是满意的<br>
 * 书店老板知道一个秘密技巧, 能抑制自己的情绪, 可以让自己连续{@code X}分钟不生气, 但却只能使用一次<br>
 * 请你返回这一天营业下来, 最多有多少客户能够感到满意的数量
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code customers = [1, 0, 1, 2, 1, 1, 7, 5], grumpy = [0, 1, 0, 1, 0, 1, 0, 1], X = 3}<br>
 * 输出: {@code 16}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= X <= customers.length == grumpy.length <= 20000</b></li>
 *     <li><b>0 <= customers[i] <= 1000</b></li>
 *     <li><b>0 <= grumpy[i] <= 1</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1052 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 1. 一个数组(表示每分钟的顾客数量)  2. 一个数组(表示每分钟老板是否处于生气的状态)  3. 使用秘密技巧的最大时间
     * @return 顾客满意数量的最大值
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof int[] && objects[1] instanceof int[] && objects[2] instanceof Integer) {
            return maxSatisfied((int[]) objects[0], (int[]) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 计算顾客满意数量的最大值
     *
     * <p>
     * 思路:<br>
     * 先统计已经满意的顾客数量, 再以{@code x}作为窗口大小遍历数组统计使用秘密技巧后顾客满意数量的最大值,
     * 两者相加就是最后所求的结果
     * </p>
     *
     * @param customers 一个数组, 表示每分钟的顾客数量
     * @param grumpy    一个数组, 表示每分钟老板是否处于生气的状态
     * @param x         使用秘密技巧的最大时间
     * @return 顾客满意数量的最大值
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        // 数组长度
        int n = grumpy.length;
        // 统计一开始就满意的顾客数量
        int satisfaction = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfaction += customers[i];
            }
        }
        // 统计第一个窗口中使用秘密技巧后使顾客满意的数量
        int satisfactionIncrement = 0;
        for (int i = 0; i < x; i++) {
            if (grumpy[i] == 1) {
                satisfactionIncrement += customers[i];
            }
        }
        // 滑动窗口, 计算使用秘密技巧后顾客满意数量的最大值
        int maxOfSatisfactionIncrement = satisfactionIncrement;
        for (int i = x; i < n; i++) {
            // 窗口新移入的如果是不满意的, 那么要加上这些顾客的数量
            if (grumpy[i] == 1) {
                satisfactionIncrement += customers[i];
            }
            // 窗口移出的如果是不满意的, 那么要减去这些顾客的数量
            if (grumpy[i - x] == 1) {
                satisfactionIncrement -= customers[i - x];
            }
            // 保存最大数量
            maxOfSatisfactionIncrement = Math.max(maxOfSatisfactionIncrement, satisfactionIncrement);
        }
        // 返回本来就满意的顾客数量以及使用秘密技巧后顾客满意数量的最大值
        return satisfaction + maxOfSatisfactionIncrement;
    }
}
