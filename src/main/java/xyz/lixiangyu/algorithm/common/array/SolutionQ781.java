package xyz.lixiangyu.algorithm.common.array;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/rabbits-in-forest/">781. 森林中的兔子</a>
 *
 * <p>
 * 描述:<br>
 * 森林中每个兔子都有颜色, 其中一些兔子(可能是全部)告诉你还有多少其他的兔子和自己有相同的颜色, 我们将这些回答放在{@code answers}数组里<br>
 * 返回森林中兔子的最少数量
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code answers = [1, 1, 2]}<br>
 * 输出: {@code 5}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code answers = [10, 10, 10]}<br>
 * 输出: {@code 11}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code answers = []}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>{@code answers}的长度最大为1000</li>
 *     <li>{@code answers[i]}是在 [0, 999] 范围内的整数</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ781 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 森林中兔子的最少数量
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return numRabbits((int[]) obj);
        }
        return null;
    }

    /**
     * 计算森林中兔子的最少数量
     *
     * @param answers 一个数组
     * @return 森林中兔子的最少数量
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            // (key + value) / (key + 1) 与 Math.ceil 是等价的, 表示上取整, 代表这些数量相同兔子的颜色有多少种
            // 因为每种颜色的兔子有 key + 1 只, 所以再乘上 key + 1
            result += (key + value) / (key + 1) * (key + 1);
        }
        return result;
    }
}
