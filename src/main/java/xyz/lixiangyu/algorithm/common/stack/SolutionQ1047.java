package xyz.lixiangyu.algorithm.common.stack;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/">
 * 1047. 删除字符串中的所有相邻重复项
 * </a>
 *
 * <p>
 * 描述:<br>
 * 给出由小写字母组成的字符串{@code S}, 重复项删除操作会选择两个相邻且相同的字母, 并删除它们<br>
 * 在{@code S}上反复执行重复项删除操作, 直到无法继续删除<br>
 * 在完成所有重复项删除操作后返回最终的字符串, 答案保证唯一
 * </p>
 *
 * <p>
 * <p>
 * 样例输出:<br>
 * 输入: {@code "abbaca"}<br>
 * 输出: {@code "ca"}<br>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= S.length <= 20000</b></li>
 *     <li><b>S仅由小写英文字母组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1047 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个字符串
     * @return 删除相邻重复项后的字符串
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return removeDuplicates((String) obj);
        }
        return null;
    }

    /**
     * 删除字符串中的所有相邻重复项
     *
     * <p>
     * 思路:<br>
     * 消消乐就完事了, 需要注意的是不用真的创建一个栈, {@link StringBuilder}可以模拟栈的操作,
     * 在时间上快了接近40ms
     * </p>
     *
     * @param s 一个字符串
     * @return 删除相邻重复项后的字符串
     */
    public String removeDuplicates(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int top = -1;
        for (char c : chars) {
            if (top >= 0 && stringBuilder.charAt(top) == c) {
                stringBuilder.deleteCharAt(top);
                top--;
            } else {
                stringBuilder.append(c);
                top++;
            }
        }
        return stringBuilder.toString();
    }
}
