package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/fruit-into-baskets/">904. 水果成篮</a>
 *
 * <p>
 * 描述:<br>
 * 在一排树中, 第{@code i}棵树产生{@code tree[i]}型的水果<br>
 * 你可以从你选择的任何树开始, 然后重复执行以下步骤:<br>
 * 1. 把这棵树上的水果放进你的篮子里, 如果你做不到, 就停下来<br>
 * 2. 移动到当前树右侧的下一棵树, 如果右边没有树, 就停下来<br>
 * 请注意, 在选择一颗树后, 你没有任何选择：<br>
 * 你必须执行步骤1, 然后执行步骤2, 然后返回步骤1, 然后执行步骤2, 依此类推, 直至停止<br>
 * 你有两个篮子, 每个篮子可以携带任何数量的水果, 但你希望每个篮子只携带一种类型的水果<br>
 * 用这个程序你能收集的水果树的最大总量是多少?
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code [1, 2, 1]}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code [0, 1, 2, 2]}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code [1, 2, 3, 2, 2]}<br>
 * 输出: {@code 4}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code [3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4]}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= tree.length <= 40000</b></li>
 *     <li><b>0 <= tree[i] < tree.length</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ904 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一排水果树
     * @return 计算能收集的水果树的最大总量
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return totalFruit((int[]) obj);
        }
        return null;
    }

    /**
     * 计算能收集的水果树的最大总量
     *
     * <p>
     * 思路:<br>
     * 双指针遍历
     * </p>
     *
     * @param tree 一排水果树
     * @return 计算能收集的水果树的最大总量
     */
    public int totalFruit(int[] tree) {
        // 统计当前出现了几个不相同的数字
        int num = 0;
        // 统计每个数字出现的次数
        int[] count = new int[40001];
        // 左指针
        int left = 0;
        // 保存最后的结果
        int result = 0;
        // 右指针右移
        for (int i = 0; i < tree.length; i++) {
            //  如果次数为0, 说明是第一次出现, 个数需要+1
            if (count[tree[i]] == 0) {
                num++;
            }
            // 次数+1
            count[tree[i]]++;
            // 如果不同的数字的个数大于2(两个篮子), 左指针左移, 次数和个数都要减
            while (num > 2) {
                count[tree[left]]--;
                if (count[tree[left]] == 0) {
                    num--;
                }
                left++;
            }
            // 左右指针间的长度作为结果
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
