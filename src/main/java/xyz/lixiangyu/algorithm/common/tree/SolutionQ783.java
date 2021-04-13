package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">783. 二叉搜索树节点最小距离</a>
 *
 * <p>
 * 描述:<br>
 * 给你一个二叉搜索树的根节点{@code root}, 返回树中任意两不同节点值之间的最小差值
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code root = [4, 2, 6, 1, 3]}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code root = [1, 0, 48, null, null, 12, 49]}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>树中节点数目在范围 [2, 100] 内</li>
 *     <li>0 <= Node.val <= 10^5</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ783 extends AbstractSolution {
    /**
     * 保存前一个节点的值
     */
    private int pre = -1;

    /**
     * 保存结果
     */
    private int result = 0x3f3f3f3f;

    /**
     * {@inheritDoc}
     *
     * @param obj 树的根节点
     * @return 树中任意两不同节点值之间的最小差值
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof TreeNode) {
            return minDiffInBST((TreeNode) obj);
        }
        return null;
    }

    /**
     * 计算树中任意两不同节点值之间的最小差值
     *
     * <p>
     * 思路:<br>
     * 对于二叉搜索树, 中序遍历的结果是一个递增的数组, 最小的差值就是相邻两个元素之差的最小值
     * </p>
     *
     * @param root 树的根节点
     * @return 树中任意两不同节点值之间的最小差值
     */
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return result;
    }

    /**
     * 对树做中序遍历
     *
     * @param node 某个节点
     */
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        // 对于第一个节点, 因为还没有前一个节点的值, 所以这个时候不要取小值
        if (pre != -1) {
            result = Math.min(result, node.val - pre);
        }
        pre = node.val;
        inorder(node.right);
    }
}
