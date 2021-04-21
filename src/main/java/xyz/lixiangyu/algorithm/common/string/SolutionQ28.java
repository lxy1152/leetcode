package xyz.lixiangyu.algorithm.common.string;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">28. 实现 strStr()</a>
 *
 * <p>
 * 描述:<br>
 * 实现{@code strStr()}函数。
 *
 * 给你两个字符串{@code haystack}和{@code needle}, 请你在{@code haystack}字符串中找出{@code needle}字符串出现的第一个位置
 * (下标从{@code 0}开始), 如果不存在则返回{@code -1}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code haystack = "hello", needle = "ll"}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code haystack = "aaaaa", needle = "bba"}<br>
 * 输出: {@code -1}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code haystack = "", needle = ""}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>0 <= haystack.length, needle.length <= 5 * 10^4</li>
 *     <li>haystack 和 needle 仅由小写英文字符组成</li>
 *     <li>如示例输出3所示, 当needle为空时, 应该返回0</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ28 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  haystack
     * @param obj1 needle
     * @return needle出现的第一个未知
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof String) {
            return strStr((String) obj, (String) obj1);
        }
        return null;
    }

    /**
     * 找出{@code needle}字符串在{@code haystack}中出现的第一个位置
     *
     * @param haystack 一个字符串
     * @param needle   一个字符串
     * @return needle在haystack中出现的第一个位置
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
