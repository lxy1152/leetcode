package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">938. 二叉搜索树的范围和</a>
 *
 * <p>
 * 描述:<br>
 * 给定二叉搜索树的根结点{@code root}, 返回值位于范围{@code [low, high]}之间的所有结点的值的和
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code root = [10, 5, 15, 3, 7, null, 18], low = 7, high = 15}<br>
 * 输出: {@code 32}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code root = [10, 5, 15, 3, 7, 13, 18, 1, null, 6], low = 6, high = 10}<br>
 * 输出: {@code 23}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>树中节点数目在范围 [1, 2 * 10^4] 内</li>
 *     <li>1 <= Node.val <= 10^5</li>
 *     <li>1 <= low <= high <= 10^5</li>
 *     <li>所有 Node.val 互不相同</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ938 extends AbstractSolution {
    /**
     * 保存结果
     */
    private int sum = 0;

    /**
     * {@inheritDoc}
     *
     * @param objects 树的头节点和一个范围
     * @return 在这个范围内的数值和
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof TreeNode && objects[1] instanceof Integer && objects[2] instanceof Integer) {
            return rangeSumBST((TreeNode) objects[0], (int) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 计算范围内的数值和
     *
     * <p>
     * 思路:<br>
     * 中序遍历, 把符合条件的数字加上
     * </p>
     *
     * @param root 树的根节点
     * @param low  最小值
     * @param high 最大值
     * @return 数值和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    /**
     * 对树做中序遍历
     *
     * @param node 树中的某个节点
     * @param low  最小值
     * @param high 最大值
     */
    public void inorder(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        inorder(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        inorder(node.right, low, high);
    }
}
