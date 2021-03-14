package xyz.lixiangyu.algorithm.common.string;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/">331. 验证二叉树的前序序列化</a>
 *
 * <p>
 * 描述:<br>
 * 序列化二叉树的一种方法是使用前序遍历, 当我们遇到一个非空节点时, 我们可以记录下这个节点的值<br>
 * 如果它是一个空节点, 我们可以使用一个标记值记录, 例如: {@code #}, 下面展示的就是一种可能的二叉树结构,
 * 它可以被序列化为字符串{@code "9,3,4,#,#,1,#,#,2,#,6,#,#"}
 *
 * <pre>
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * </pre>
 *
 * 给定一串以逗号分隔的序列, 验证它是否是正确的二叉树的前序序列化, 编写一个在不重构树的条件下的可行算法<br>
 * 每个以逗号分隔的字符是一个整数或者是一个表示空的{@code #}<br>
 * 你可以认为输入格式总是有效的, 例如它永远不会包含两个连续的逗号, 比如: {@code "1,,3"}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code "9,3,4,#,#,1,#,#,2,#,6,#,#"}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code "1,#"}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code "9,#,#,1"}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ331 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个描述二叉树结构的前序序列
     * @return 是否是正确的描述序列
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof String) {
            return isValidSerialization((String) obj);
        }
        return null;
    }

    /**
     * 是否是正确的描述二叉树结构的前序序列
     *
     * <p>
     * 思路:<br>
     * 二叉树的前序序列中, {@code #}的数量应该比数字的数量多一个, 并且当
     * 序列没有结束时, {@code #}的数量不应该比数字的数量多
     * </p>
     *
     * @param preorder 一个描述二叉树结构的前序序列
     * @return 是否是正确的描述序列
     */
    public boolean isValidSerialization(String preorder) {
        // 把序列转为char型数组
        char[] chars = preorder.toCharArray();
        // 数组长度
        int n = chars.length;

        // 保存#的数量
        int hashMarkCount = 0;
        // 保存数字的数量
        int numCount = 0;

        // 循环变量
        int i = 0;

        while (i < n) {
            // 当前位置的字符
            char c = chars[i];
            // 把循环变量+1
            i++;

            // 数字会有多位的情况, 所以如果碰到数字需要一直移动循环变量直至这个数字结束
            if (Character.isDigit(c)) {
                while (i < n && Character.isDigit(chars[i])) {
                    i++;
                }
                numCount++;
            } else if (c == '#') {
                hashMarkCount++;
            }

            // 在序列未结束时, 不应该出现#比数字多的情况
            if (i < n - 1 && hashMarkCount >= numCount + 1) {
                return false;
            }
        }

        // 最后#的数量应该比数字数量多一个
        return hashMarkCount == numCount + 1;
    }
}
