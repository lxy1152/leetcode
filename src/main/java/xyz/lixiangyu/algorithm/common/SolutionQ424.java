package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">424. 替换后的最长重复字符</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个仅由大写英文字母组成的字符串, 你可以将任意位置上的字符替换成另外的字符, 总共可最多替换{@code k}次<br>
 * 在执行上述操作后, 找到包含重复字母的最长子串的长度
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "ABAB", k = 2}<br>
 * 输出:{@code 4}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "AABABBA", k = 1}<br>
 * 输出:{@code 4}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <b>字符串长度和{@code k}不会超过10^4</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ424 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个仅由大写英文字母组成的字符串
     * @param obj1 最大可替换次数
     * @return 替换后的最大重复字串长度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof Integer) {
            return characterReplacement((String) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算替换后的最大重复字串长度
     *
     * <p>
     * 思路<br>
     * 使用双指针做滑动窗口, 见下方的代码注释说明
     * </p>
     *
     * @param s 一个仅由大写英文字母组成的字符串
     * @param k 最大可替换次数
     * @return 替换后的最大重复字串长度
     */
    public int characterReplacement(String s, int k) {
        // 如果长度是0或1就直接返回
        int length = s.length();
        if (length < 2) {
            return length;
        }

        // 将字符串转为char型数组
        char[] charArray = s.toCharArray();

        // 左右指针
        int left = 0;
        int right = 0;

        // 记录历史某个窗口中某字母出现的最大次数
        int maxCount = 0;

        // 统计每个字母出现的次数
        int[] frequency = new int[26];

        // 保存最后的结果
        int result = 0;

        // 如果右指针没有右移到边界
        while (right < length) {
            // 取右指针所在位置的字符
            char current = charArray[right];
            // 出现次数+1
            frequency[current - 'A']++;
            // 因为保存的是历史值, 最后的结果又是最大值, 所以不必要做减法
            // 如果有其他更优解, 会替代当前的maxCount作为最优解, 相应的总长度也会增加
            maxCount = Math.max(maxCount, frequency[current - 'A']);
            // 右指针向右移动
            right++;
            // 如果当前窗口的长度比 字符出现最大次数 + 可替换次数 还要大
            // 那么说明当前窗口不合适, 左指针要右移
            if (right - left > maxCount + k) {
                frequency[charArray[left] - 'A']--;
                left++;
            }
            // 取窗口长度作为结果
            result = Math.max(result, right - left);
        }
        return result;
    }
}
