package xyz.lixiangyu.contest.contest231;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/">
 * 5697. 检查二进制字符串字段
 * </a>
 *
 * <p>
 * 描述:<br>
 * 给你一个二进制字符串{@code s}, 该字符串不含前导零<br>
 * 如果{@code s}最多包含一个由连续的{@code '1'}组成的字段, 返回{@code true}, 否则返回{@code false}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "1001"}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "110"}<br>
 * 输出: {@code true}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 100</b></li>
 *     <li><b>s[i] 为 '0' 或 '1'</b></li>
 *     <li><b>s[0] 为 '1'</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ5697 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个字符串
     * @return 是否最多包含一个全是1的子串
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return checkOnesSegment((String) obj);
        }
        return null;
    }

    /**
     * 判断某个字符串是否最多包含一个全是{@code 1}的子串
     *
     * <p>
     * 思路:<br>
     * 如果一个字符串包含两个或更多的子串, 它们之间必然会通过{@code 0}来分隔,
     * 所以可以统计出现{@code '01'}的次数, 来判断是否符合题意<br>
     * </p>
     *
     * <b>注意: 题目给定{@code s[0]}一定是{@code 1}</b>
     *
     * @param s 一个字符串
     * @return 是否最多包含一个全是1的子串
     */
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 1; i < n; i++) {
            if (chars[i] == '1' && chars[i - 1] == '0') {
                return false;
            }
        }
        return true;
    }
}
