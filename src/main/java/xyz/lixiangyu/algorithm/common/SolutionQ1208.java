package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/get-equal-substrings-within-budget/">1208. 尽可能使字符串相等</a>
 *
 * <p>
 * 描述:<br>
 * 给你两个长度相同的字符串, {@code s}和{@code t}<br>
 * 将{@code s}中的第{@code i}个字符变到{@code t}中的第{@code i}个字符需要{@code |s[i] - t[i]|}的开销(开销可能为0),
 * 也就是两个字符的 ASCII 码值的差的绝对值<br>
 * 用于变更字符串的最大预算是{@code maxCost}, 在转化字符串时, 总开销应当小于等于该预算, 这也意味着字符串的转化可能是不完全的<br>
 * 如果你可以将{@code s}的子字符串转化为它在{@code t}中对应的子字符串, 则返回可以转化的最大长度<br>
 * 如果{@code s}中没有子字符串可以转化成{@code t}中对应的子字符串，则返回0
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "abcd", t = "bcdf", cost = 3}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "abcd", t = "cdef", cost = 3}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code s = "abcd", t = "acde", cost = 0}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length, t.length <= 10^5</b></li>
 *     <li><b>0 <= maxCost <= 10^6</b></li>
 *     <li><b>{@code s}和{@code t}都只含小写英文字母</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1208 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects s, t数组和转化总花销
     * @return 最大重复字符串长度
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof String && objects[1] instanceof String && objects[2] instanceof Integer) {
            return equalSubstring((String) objects[0], (String) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 两字符串在最大允许花销的前提下, 可以得到的最大重复字符串长度
     *
     * <p>
     * 思路:<br>
     * 使用双指针
     * </p>
     *
     * <ul>注意:
     *     <li><b>使用{@link String#charAt}和使用{@link String#toCharArray}相比, 慢了4ms</b></li>
     * </ul>
     *
     * @param s       s字符串
     * @param t       t字符串
     * @param maxCost 允许的最大花销
     * @return 最大重复字符串长度
     */
    public int equalSubstringUseTwoPointer(String s, String t, int maxCost) {
        // 如果两个字符串相等, 则直接返回任意一个的长度
        if (s.equals(t)) {
            return s.length();
        }
        // 如果总花销小于等于0, 返回总长度为1
        if (maxCost <= 0) {
            return 1;
        }
        // 左右指针
        int left = 0;
        int right = 0;
        // 保存当前用于转化字符的总花销
        int sumCost = 0;
        // 保存最后的结果
        int maxCount = 0;
        // 保存两个字符串的charArray
        char[] charArrayOfS = s.toCharArray();
        char[] charArrayOfT = t.toCharArray();
        // 右指针不断右移
        while (right < s.length()) {
            // 计算总花销
            sumCost += Math.abs(charArrayOfS[right] - charArrayOfT[right]);
            // 右指针右移
            right++;
            // 如果当前的总花销比允许的总花销还要大
            // 那么左指针需要右移, 并减去左指针
            if (sumCost > maxCost) {
                sumCost -= Math.abs(charArrayOfS[left] - charArrayOfT[left]);
                left++;
            }
            maxCount = Math.max(maxCount, right - left);
        }
        return maxCount;
    }

    /**
     * 两字符串在最大允许花销的前提下, 可以得到的最大重复字符串长度
     *
     * <p>
     * 思路:<br>
     * 对上面的写法可以进行优化, 实际上右指针是肯定会右移的, 所以不需要额外使用变量, 直接{@code fori}循环就可以了<br>
     * 左指针是有条件右移的, 但是左指针右移时, 因为右指针已经右移了, 所以右指针和左指针之间的距离是不变的<br>
     * 因此右指针和左指针之间的距离是不会减小的, 会相等或者增加<br>
     * 所以也就不需要另外一个变量{@code maxCount}来保存历史最大长度了, 最后只要返回{@code s.length() - left}即可
     * </p>
     *
     * <ul>
     *     <li><b>优化思路是没问题的, 但是执行的时间和空间使用和上面的写法是一样的</b></li>
     *     <li><b>使用{@link String#charAt}和使用{@link String#toCharArray}相比, 慢了4ms</b></li>
     * </ul>
     *
     * @param s       s字符串
     * @param t       t字符串
     * @param maxCost 允许的最大花销
     * @return 最大重复字符串长度
     */
    public int equalSubstring(String s, String t, int maxCost) {
        // 如果两个字符串相等, 则直接返回任意一个的长度
        if (s.equals(t)) {
            return s.length();
        }
        // 如果总花销小于等于0, 返回总长度为1
        if (maxCost <= 0) {
            return 1;
        }
        // 左指针
        int left = 0;
        // 保存当前用于转化字符的总花销
        int sumCost = 0;
        char[] charArrayOfS = s.toCharArray();
        char[] charArrayOfT = t.toCharArray();
        // 右指针不断右移
        for (int i = 0; i < s.length(); i++) {
            // 计算总花销
            sumCost += Math.abs(charArrayOfS[i] - charArrayOfT[i]);
            // 如果当前的总花销比允许的总花销还要大
            // 那么左指针需要右移, 并减去左指针所在位置用于转化字符所需的花销
            if (sumCost > maxCost) {
                sumCost -= Math.abs(charArrayOfS[left] - charArrayOfT[left]);
                left++;
            }
        }
        return s.length() - left;
    }
}
