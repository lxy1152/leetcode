package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个二叉树的根节点{@code root}, 返回它的中序遍历结果
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code root = [1, null, 2, 3]}<br>
 * 输出: {@code [1, 3, 2]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code root = []}<br>
 * 输出: {@code []}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code root = [1]}<br>
 * 输出: {@code [1]}
 * </p>
 *
 * <p>
 * 示例输出4:<br>
 * 输入: {@code root = [1, 2]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 *
 * <p>
 * 示例输出5:<br>
 * 输入: {@code root = [1, null, 2]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ94 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 树的根节点
     * @return 中序遍历的结果
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof TreeNode || obj == null) {
            return inorderTraversal((TreeNode) obj);
        }
        return null;
    }

    /**
     * 获得树的中序遍历结果
     *
     * <p>
     * 思路:<br>
     * 通过递归实现树的中序遍历
     * </p>
     *
     * @param root 树的根节点
     * @return 中序遍历的结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root, result);
        return result;
    }

    /**
     * 进行树的中序遍历
     *
     * @param node   树的根节点
     * @param result 用于保存结果的列表
     */
    public void doInorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        doInorderTraversal(node.left, result);
        result.add(node.val);
        doInorderTraversal(node.right, result);
    }
}
