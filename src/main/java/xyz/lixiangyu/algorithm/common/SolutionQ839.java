package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.DisjointSet;

/**
 * <a href="https://leetcode-cn.com/problems/similar-string-groups/">839. 相似字符串组</a>
 *
 * <p>
 * 描述:<br>
 * 如果交换字符串{@code X}中的两个不同位置的字母, 使得它和字符串{@code Y}相等, 那么称{@code X}和{@code Y}两个字符串相似.
 * 如果这两个字符串本身是相等的, 那它们也是相似的. <br>
 *
 * 例如, {@code "tars"}和{@code "rats"}是相似的(交换0与2的位置); {@code "rats"}和{@code "arts"}也是相似的,
 * 但是{@code "star"}不与{@code "tars"}, {@code "rats"}, 或{@code "arts"}相似. <br>
 *
 * 总之, 它们通过相似性形成了两个关联组：{@code {"tars", "rats", "arts"}}和{@code {"star"}}.
 * 注意, {@code "tars"}和{@code "arts"}是在同一组中, 即使它们并不相似.
 * 形式上, 对每个组而言, 要确定一个单词在组中, 只需要这个词和该组中至少一个单词相似.<br>
 *
 * 给你一个字符串列表{@code strs}. 列表中的每个字符串都是{@code strs}中其它所有字符串的一个字母异位词.
 * 请问{@code strs}中有多少个相似字符串组?
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code strs = ["tars","rats","arts","star"]}<br>
 * 输出: {@code 2}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code strs = ["omv","ovm"]}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>{@code 1 <= strs.length <= 100}</b></li>
 *     <li><b>{@code 1 <=strs[i].length<= 1000}</b></li>
 *     <li><b>{@code sum(strs[i].length) <= 2 * 10^4}</b></li>
 *     <li><b>{@code strs[i]}只包含小写字母</b></li>
 *     <li><b>{@code strs}中的所有单词都具有相同的长度，且是彼此的字母异位词</b></li>
 *     <li><b>字母异位词(anagram): 一种把某个字符串的字母的位置(顺序)加以改换所形成的新词</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ839 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个包含多个字母异位词的字符串数组
     * @return 相似字符串数组的个数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String[]) {
            return numSimilarGroups((String[]) obj);
        }
        return null;
    }

    /**
     * <p>
     * 思路:
     * <ol>
     *     <li>使用{@linkplain DisjointSet 并查集}</li>
     *     <li>如果两字符串相似
     *         <ul>
     *             <li>那么字符不同的位置应该只有两处, 比如: {@code abc}和{@code cba}</li>
     *             <li>两个字符串完全相同</li>
     *         </ul>
     *     </li>
     * </ol>
     * </p>
     *
     * <p>注: 因为题目对输入的字符串加了很多限制, 所以很多判断是不需要的, 但是这些小细节是值得关注的</p>
     *
     * @param strs 一个包含多个字母异位词的字符串数组
     * @return 相似字符串数组的个数
     * @see DisjointSet
     */
    public int numSimilarGroups(String[] strs) {
        int size = strs.length;
        // 新建一个并查集
        DisjointSet disjointSet = new DisjointSet(size);
        // 比较第i个元素和第i+1个以后的元素是否相似
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                // 如果相似, 则在并查集中合并
                if (isSimilar(strs[i], strs[j])) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.getSize();
    }

    /**
     * 判断两个字符串是否相似
     *
     * @param source 原字符串
     * @param target 目标字符串
     * @return 是否相似
     */
    public boolean isSimilar(String source, String target) {
        // 字符串长度必须相同才有可能是相似的
        // 因为题目中加了字符串长度都相同的限制, 所以这个判断可以不加
        if (source.length() != target.length()) {
            return false;
        }

        // 字母转小写, 因为题目限制字母都是小写, 所以这个转换可以不加
        source = source.toLowerCase();
        target = target.toLowerCase();

        // 题目限制字母只能交换一次, 那么如果是相似字符串
        // 则必须完全相同或者有两处不一样
        // 实际上这里应该加上判断: 上一处的字母在下一处出现了, 否则会有abc, cbd这种情况出现
        // 但是因为题目限制字符串为字母异位词, 所以这个判断也可以不加
        boolean isMatch = true;
        int count = 0;
        char sourcePre = 0;
        char targetPre = 0;
        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);
            if (s != t) {
                count++;
                if (count == 1) {
                    // 储存第一处不一样的字符
                    sourcePre = s;
                    targetPre = t;
                } else if (count == 2) {
                    // 如果与前一处不一样的地方不匹配, 置isMatch为false
                    if (s != targetPre && t != sourcePre) {
                        isMatch = false;
                    }
                } else {
                    // 如果不一样的地方已经多于两处了, 那肯定不是相似的了, 直接跳出循环
                    break;
                }
            }
        }
        return (count == 2 || count == 0) && isMatch;
    }
}
