package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">897. 递增顺序搜索树</a>
 *
 * <p>
 * 描述:<br>
 * 给你一棵二叉搜索树, 请你按中序遍历将其重新排列为一棵递增顺序搜索树, 使树中最左边的节点成为树的根节, 并且每个节点没有左子节点, 只有一个右子节点
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code root = [5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9]}<br>
 * 输出: {@code [1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code root = [5, 1, 7]}<br>
 * 输出: {@code [1, null, 5, null, 7]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>树中节点数的取值范围是 [1, 100]</li>
 *     <li>0 <= Node.val <= 1000</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ897 extends AbstractSolution {
    /**
     * 头部哑节点, 最后请返回{@code dummyNode.next}
     */
    TreeNode dummyNode = new TreeNode(-1);

    /**
     * 指向当前节点
     */
    TreeNode current = dummyNode;

    /**
     * {@inheritDoc}
     *
     * @param obj 树的根节点
     * @return 一个顺序搜索树
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof TreeNode) {
            return increasingBST((TreeNode) obj);
        }
        return null;
    }

    /**
     * 根据给定的二叉树头节点生成一个新的顺序搜索树
     *
     * <p>
     * 思路:<br>
     * 一边中序遍历一边生成新的树
     * </p>
     *
     * @param root 树的根节点
     * @return 新生成的树的根节点
     */
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummyNode.right;
    }

    /**
     * 对树做中序遍历
     *
     * @param node 树的某一个节点
     */
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        current.right = new TreeNode(node.val);
        current = current.right;
        inorder(node.right);
    }
}
