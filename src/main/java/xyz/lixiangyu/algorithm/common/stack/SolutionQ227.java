package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/basic-calculator-ii/">227. 基本计算器 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个字符串表达式{@code s}, 请你实现一个基本计算器来计算并返回它的值, 整数除法仅保留整数部分
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "3+2*2"}<br>
 * 输出: {@code 7}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = " 3/2 "}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code s = " 3+5 / 2 "}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 3 * 10^5</b></li>
 *     <li><b>s由整数和算符('+', '-', '*', '/')组成, 中间由一些空格隔开</b></li>
 *     <li><b>s表示一个有效表达式</b></li>
 *     <li><b>表达式中的所有整数都是非负整数, 且在范围[0, 2^{31} - 1]内</b></li>
 *     <li><b>题目数据保证答案是一个 32-bit 整数</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ227 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个算式
     * @return 算式的运算结果
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return calculate((String) obj);
        }
        return null;
    }

    /**
     * 计算某算式的运算结果
     *
     * <p>
     * 思路:<br>
     * 因为含有乘除运算, 所以用一个栈来保存计算过乘除法部分后的计算式, 最后遍历栈就可以得到答案了<br>
     * 为了方便后面的计算, 可以将负数取相反数保存在栈里
     * </p>
     *
     * @param s 一个算式
     * @return 算式的运算结果
     */
    public int calculate(String s) {
        // 保存去除乘除后的数字的栈
        Deque<Integer> stack = new LinkedList<>();
        // 保存前一个数字
        int num = 0;
        // 保存前一个操作符
        char op = '+';
        // 去除空格
        s = s.replace(" ", "");
        // 去除空格后的字符串长度
        int n = s.length();

        // 遍历算式
        for (int i = 0; i < n; i++) {
            // 需要判断当前的字符是不是数字
            char c = s.charAt(i);
            boolean isNumber = Character.isDigit(c);

            // 考虑有多位数字的情况
            if (isNumber) {
                num = num * 10 + c - '0';
            }

            // 这里要注意需要考虑 i == n - 1 的情况
            // 另外如果是负数把它转为正数再保存
            if (!isNumber || i == n - 1) {
                if (op == '+') {
                    stack.addLast(num);
                } else if (op == '-') {
                    stack.addLast(-num);
                } else if (op == '*') {
                    stack.addLast(stack.removeLast() * num);
                } else if (op == '/') {
                    stack.addLast(stack.removeLast() / num);
                }
                op = c;
                num = 0;
            }
        }

        // 重新遍历栈, 将所有数字求和并返回
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.removeLast();
        }
        return result;
    }
}
