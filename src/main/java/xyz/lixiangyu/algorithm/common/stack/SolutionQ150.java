package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">150. 逆波兰表达式求值</a>
 *
 * <p>
 * 描述:<br>
 * 根据逆波兰表示法, 求表达式的值<br>
 * 有效的算符包括{@code +, -, *, /}, 每个运算对象可以是整数, 也可以是另一个逆波兰表达式
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code tokens = ["2", "1", "+", "3", "*"]}<br>
 * 输出: {@code 9}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code tokens = ["4", "13", "5", "/", "+"]}<br>
 * 输出: {@code 6}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]}<br>
 * 输出: {@code 22}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>整数除法只保留整数部分</b></li>
 *     <li><b>给定逆波兰表达式总是有效的, 换句话说, 表达式总会得出有效数值且不存在除数为 0 的情况</b></li>
 *     <li><b>1 <= tokens.length <= 10^4</b></li>
 *     <li><b>tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"）, 要么是一个在范围 [-200, 200] 内的整数</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ150 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个逆波兰表达式
     * @return 计算结果
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String[]) {
            return evalRPN((String[]) obj);
        }
        return null;
    }

    /**
     * 计算逆波兰表达式的值
     *
     * <p>
     * 思路:<br>
     * 逆波兰表达式适合使用栈来计算, 如果遇到运算符就将前两个数做计算, 否则将这个数放入栈中,
     * 最后返回栈顶元素就可以了
     * </p>
     *
     * @param tokens 一个逆波兰表达式
     * @return 计算结果
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        // 注意除法和减法时数的顺序
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 - num1);
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
