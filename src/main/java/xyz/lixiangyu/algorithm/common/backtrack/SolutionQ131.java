package xyz.lixiangyu.algorithm.common.backtrack;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-partitioning/">131. 分割回文串</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个字符串{@code s}, 请你将{@code s}分割成一些子串, 使每个子串都是回文串, 返回{@code s}所有可能的分割方案<br>
 * 回文串是正着读和反着读都一样的字符串
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code s = "aab"}<br>
 * 输出: {@code [["a", "a", "b"], ["aa", "b"]]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code s = "a"}<br>
 * 输出: {@code [["a"]]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= s.length <= 16</b></li>
 *     <li><b>s仅由小写英文字母组成</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ131 extends AbstractSolution {
    /**
     * 保存最后的结果
     */
    private List<List<String>> result;

    /**
     * 保存每次递归中的结果
     */
    private List<String> path;

    /**
     * 字符串长度
     */
    private int length;

    /**
     * 字符串对应的{@code char}型数组
     */
    private char[] chars;

    /**
     * {@inheritDoc}
     *
     * @param obj 一个字符串
     * @return 所有回文子串
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return partition((String) obj);
        }
        return null;
    }

    /**
     * 获取所有回文子串
     *
     * <p>
     * 思路:<br>
     * 回溯获取所有回文子串
     * </p>
     *
     * @param s 一个字符串
     * @return 所有回文子串
     */
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        this.length = s.length();
        this.chars = s.toCharArray();
        backTrack(0, new int[this.length][this.length]);
        return result;
    }

    /**
     * 递归获取回文串, 使用记忆化搜索
     *
     * @param index 本次判断的子串的开始位置
     */
    public void backTrack(int index, int[][] memo) {
        if (index == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < length; i++) {
            if (memo[index][i] == 2) {
                continue;
            }
            if (memo[index][i] == 1 || isPalindrome(index, i, memo)) {
                path.add(new String(chars, index, i - index + 1));
                backTrack(i + 1, memo);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 判断一个字串是否是回文串
     *
     * <p>
     * 根据回文串对应位置的字符相等来判断
     * </p>
     *
     * @param left  开始位置
     * @param right 结束位置
     * @return 是否是回文串
     */
    public boolean isPalindrome(int left, int right, int[][] memo) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                memo[left][right] = 2;
                return false;
            }
            left++;
            right--;
        }
        memo[left][right] = 1;
        return true;
    }
}
