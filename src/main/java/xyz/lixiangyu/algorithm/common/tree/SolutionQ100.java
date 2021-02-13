package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/same-tree/">100. 相同的树</a>
 *
 * <p>
 * 描述:<br>
 * 给你两棵二叉树的根节点{@code p}和{@code q}, 编写一个函数来检验这两棵树是否相同<br>
 * 如果两个树在结构上相同, 并且节点具有相同的值, 则认为它们是相同的
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code p = [1, 2, 3], q = [1, 2, 3]}<br>
 * 输出: {@code true}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code p = [1, 2], q = [1, null, 2]}<br>
 * 输出: {@code false}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code p = [1, 2, 1], q = [1, 1, 2]}<br>
 * 输出: {@code false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>两棵树上的节点数目都在范围{@code [0, 100]}内</b></li>
 *     <li><b>-10^4 <= Node.val <= 10^4</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ100 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个树的根节点
     * @param obj1 另一个树的根节点
     * @return 两个树是否相同
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof TreeNode && obj1 instanceof TreeNode) {
            return isSameTree((TreeNode) obj, (TreeNode) obj1);
        }
        return null;
    }

    /**
     * 判断两个树是否相等
     *
     * @param p 一个树的根节点
     * @param q 另一个树的根节点
     * @return 两个树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个节点都是空, 返回true
        // 如果两个都不是空并且值还相等需要递归判断左子树和右子树
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
