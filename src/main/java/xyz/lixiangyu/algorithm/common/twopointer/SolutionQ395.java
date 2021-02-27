package xyz.lixiangyu.algorithm.common.twopointer;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/">
 * 395. 至少有 K 个重复字符的最长子串
 * </a>
 *
 * <p>
 * 描述:<br>
 * 给你一个字符串{@code s}和一个整数{@code k}, 请你找出{@code s}中的最长子串,
 * 要求该子串中的每一字符出现次数都不少于{@code k}, 返回这一子串的长度
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "aaabb", k = 3}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "ababbc", k = 2}<br>
 * 输出: {@code 5}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 10^4</b></li>
 *     <li><b>s仅由小写英文字母组成</b></li>
 *     <li><b>1 <= k <= 10^5</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ395 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个字符串
     * @param obj1 限制每个字母的出现次数
     * @return 子串的长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof Integer) {
            return longestSubstring((String) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 获得子串长度
     *
     * <p>
     * 思路:<br>
     * 人为限制不同字符的出现次数, 再使用双指针
     * </p>
     *
     * @param s 一个字符串
     * @param k 限制每个字母的出现次数
     * @return 子串的长度
     */
    public int longestSubstring(String s, int k) {
        // 保存最后的结果
        int result = 0;
        // 字符串长度
        int n = s.length();
        // char数组
        char[] chars = s.toCharArray();
        // 确定区间中字符的个数, 再使用双指针
        for (int t = 1; t <= 26; t++) {
            // 左右指针
            int left = 0;
            int right = 0;
            // 统计每个字母出现的次数
            int[] count = new int[26];
            // 统计当前区间出现的不同字符的个数
            int total = 0;
            // 统计出现次数小于k次的字母个数
            int less = 0;
            // 统计在某个"总字符个数"限制条件下的结果
            while (right < n) {
                // 将新移入的字母的出现次数加一
                int current = chars[right] - 'a';
                count[current]++;
                // 如果次数是1, 说明是新加入的, 那么总个数和小于k次的个数要加1
                if (count[current] == 1) {
                    total++;
                    less++;
                }
                // 如果出现k次, 需要把less减1, 这里不需要判断 >= k
                if (count[current] == k) {
                    less--;
                }
                // 如果总不同字符的个数大于限制的个数
                while (total > t) {
                    // 要移出的字符
                    int out = chars[left] - 'a';
                    // 将次数减1
                    count[out]--;
                    // 如果次数小于k, less要加1, 这里不需要判断 < k
                    if (count[out] == k - 1) {
                        less++;
                    }
                    // 如果次数为0, 总次数和less都要减1
                    if (count[out] == 0) {
                        total--;
                        less--;
                    }
                    // 左指针移动
                    left++;
                }
                // 如果所有字母的出现次数都 >= k次, 计算当前的窗口大小
                if (less == 0) {
                    result = Math.max(result, right - left + 1);
                }
                right++;
            }
        }
        return result;
    }
}
