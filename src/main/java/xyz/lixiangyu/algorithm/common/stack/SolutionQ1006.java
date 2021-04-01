package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/clumsy-factorial/">1006. 笨阶乘</a>
 *
 * <p>
 * 描述:<br>
 * 通常, 正整数{@code n}的阶乘是所有小于或等于{@code n}的正整数的乘积, 例如 {@code factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1}<br>
 * 相反, 我们设计了一个笨阶乘{@code clumsy}:<br>
 * 在整数的递减序列中, 我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符, 操作符的顺序为: 乘法(*), 除法(/), 加法(+), 减法(-).
 * 例如, {@code clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1 = 12}<br>
 * 这些运算仍然使用通常的算术运算顺序: 即按照从左到右, 先乘除后加减的顺序<br>
 * 另外, 我们使用的除法是地板除法(floor division), 所以{@code 10 * 9 / 8}等于{@code 11}, 这保证结果是一个整数<br>
 * 实现上面定义的笨函数, 根据给定的一个整数{@code n}, 返回{@code n}的笨阶乘
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code 4}<br>
 * 输出: {@code 7}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code 10}<br>
 * 输出: {@code 12}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= N <= 10000</b></li>
 *     <li><b>-2^31 <= answer <= 2^31 - 1(答案保证符合32位整数)</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1006 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个整数n
     * @return 这个数的笨阶乘
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof Integer) {
            return clumsy((int) obj);
        }
        return null;
    }

    /**
     * 计算某个数的笨阶乘
     *
     * <p>
     * 思路:<br>
     * 使用栈模拟操作
     * </p>
     *
     * @param n 一个整数n
     * @return 这个数的笨阶乘
     */
    public int clumsy(int n) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(n);

        char[] op = new char[]{'*', '/', '+', '-'};
        int opIndex = 0;

        for (int i = n - 1; i > 0; i--) {
            char c = op[opIndex];
            switch (c) {
                case '+':
                    stack.push(i);
                    break;
                case '-':
                    stack.push(-i);
                    break;
                case '*':
                    stack.push(stack.pop() * i);
                    break;
                case '/':
                    stack.push(stack.pop() / i);
                    break;
            }
            opIndex = (opIndex + 1) % 4;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
