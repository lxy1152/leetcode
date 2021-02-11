package xyz.lixiangyu.algorithm.common.string;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/add-binary/">67. 二进制求和</a>
 *
 * <p>
 * 描述:<br>
 * 给你两个二进制字符串, 返回它们的和(用二进制表示)。
 * 输入为非空字符串且只包含数字1和0。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code a = "11", b = "1"}<br>
 * 输出: {@code "100"}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code a = "1010", b = "1011"}<br>
 * 输出: {@code "10101"}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>每个字符串仅由字符'0'或'1'组成</li>
 *     <li>{@code 1 <= a.length, b.length <= 10^4}</li>
 *     <li>字符串如果不是"0", 就都不含前导零</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ67 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  第一个二进制数
     * @param obj1 第二个二进制数
     * @return 相加后的和
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String && obj1 instanceof String) {
            return addBinary((String) obj, (String) obj1);
        }
        return null;
    }

    /**
     * 二进制数相加
     *
     * <p>
     * 思路<br>
     * 模仿十进制加法进行求和
     * </p>
     *
     * <p>注: 使用{@link StringBuilder#insert}就不需要反转字符串了</p>
     *
     * @param a 第一个二进制数
     * @param b 第二个二进制数
     * @return 相加后的和
     */
    public String addBinary(String a, String b) {
        // 用来保存最后的结果
        StringBuilder ans = new StringBuilder();

        // 同时遍历a, b两个字符串
        // 挑选最大长度作为遍历次数
        int aLength = a.length();
        int bLength = b.length();
        int n = Math.max(aLength, bLength);
        // 保存进位
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            // 因为是从二进制数的高位开始遍历
            // 所以需要根据当前位置取对应的低位
            // 减'0'是因为需要从char转为int型
            sum += i < a.length() ? (a.charAt(aLength - 1 - i) - '0') : 0;
            sum += i < b.length() ? (b.charAt(bLength - 1 - i) - '0') : 0;
            sum += carry;

            // 十进制是求余10, 二进制需要求余2
            // 加'0'是因为需要从int转为char型
            ans.insert(0, (char) (sum % 2 + '0'));

            // 获取进位, 十进制是除10, 二进制需要除2
            carry = sum / 2;
        }

        // 最后一次计算如果有进位, 需要补一个1
        if (carry > 0) {
            ans.insert(0, '1');
        }

        return ans.toString();
    }
}
