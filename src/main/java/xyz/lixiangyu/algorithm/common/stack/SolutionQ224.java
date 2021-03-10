package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/basic-calculator/">224. 基本计算器</a>
 *
 * <p>
 * 描述:<br>
 * 实现一个基本的计算器来计算一个简单的字符串表达式{@code s}的值
 * </p>
 *
 * <p>
 * <p>
 * 样例输出1:<br>
 * 输入: {@code s = "1 + 1"}<br>
 * 输出: {@code 2}<br>
 * </p>
 *
 * <p>
 * 样例输出2:<br>
 * 输入: {@code s = " 2-1 + 2 "}<br>
 * 输出: {@code 3}<br>
 * </p>
 *
 * <p>
 * 样例输出3:<br>
 * 输入: {@code s = "(1+(4+5+2)-3)+(6+8)"}<br>
 * 输出: {@code 23}<br>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 3 * 10^5</b></li>
 *     <li><b>s 由数字, '+', '-', '(', ')', 和 ' ' 组成</b></li>
 *     <li><b>s 表示一个有效的表达式</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ224 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个算式
     * @return 算式的计算结果
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return calculate((String) obj);
        }
        return null;
    }

    /**
     * 计算算式的值
     *
     * <p>
     * 思路:<br>
     * 使用栈保存临时计算结果
     * </p>
     *
     * @param s 一个算式
     * @return 算式的计算结果
     */
    public static int calculate(String s) {
        // 去除空格
        s = s.replace(" ", "");

        // 保存最后的结果
        int res = 0;
        // 保存当前的数字
        int num = 0;
        // 保存当前的符号
        int sign = 1;

        // 保存当前序列的栈
        Deque<Integer> stack = new LinkedList<>();

        // 遍历算式
        for (int i = 0; i < s.length(); i++) {
            // 当前的数字或者符号
            char ch = s.charAt(i);

            // 如果是左括号, 那么需要先保存当前的结果
            // 然后开始计算这个左括号与对应的右括号之间的结果
            if (ch == '(') {
                // 保存当前的计算结果和符号位
                stack.push(res);
                stack.push(sign);

                // 将结果重置为0, 符号位为正
                res = 0;
                sign = 1;
            }
            // 如果碰到右括号, 说明在与之对应的左括号的这一区间内
            else if (ch == ')') {
                // 把右括号前的最后一个数加上或减去
                res += sign * num;
                // 因为这个区间已经计算完了, 将结果重置为0
                num = 0;

                // 把栈中保存的这个区间前的结果拿出来并加上或减去
                res *= stack.pop();
                res += stack.pop();
            }
            // 如果是加减操作
            else if (ch == '+' || ch == '-') {
                // 计算结果并保存, 重置num
                res += sign * num;
                num = 0;
                // 计算符号位
                sign = ch == '+' ? 1 : -1;
            } else {
                // 因为数字可能是多位的, 所以每进来一个新的数字就要
                // 先左移一位再加上当前位的值
                num = 10 * num + ch - '0';
            }
        }
        res += sign * num;
        return res;
    }
}
