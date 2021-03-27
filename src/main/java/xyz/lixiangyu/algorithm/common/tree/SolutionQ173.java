package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/">173. 二叉搜索树迭代器</a>
 *
 * <p>
 * 描述:<br>
 * 实现一个二叉搜索树迭代器, 你将使用二叉搜索树的根节点初始化迭代器<br>
 * 调用{@link BSTIterator#next()}方法将返回二叉搜索树中的下一个最小的数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: <br>
 * <pre>
 *       7
 *    ↙    ↘
 *  3       15
 *        ↙    ↘
 *      9       20
 * </pre>
 * 输出:<br>
 * {@code BSTIterator iterator = new BSTIterator(root);}<br>
 * {@code iterator.next();    // 返回 3}<br>
 * {@code iterator.next();    // 返回 7}<br>
 * {@code iterator.hasNext(); // 返回 true}<br>
 * {@code iterator.next();    // 返回 9}<br>
 * {@code iterator.hasNext(); // 返回 true}<br>
 * {@code iterator.next();    // 返回 15}<br>
 * {@code iterator.hasNext(); // 返回 true}<br>
 * {@code iterator.next();    // 返回 20}<br>
 * {@code iterator.hasNext(); // 返回 false}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>
 *         {@link BSTIterator#next()}和{@link BSTIterator#hasNext()}操作的时间复杂度是{@code O(1)},
 *         并使用{@code O(h)}内存, 其中{@code h}是树的高度
 *     </li>
 *     <li>
 *         你可以假设{@link BSTIterator#next()}调用总是有效的, 也就是说当调用{@link BSTIterator#next()}时,
 *         BST中至少存在一个下一个最小的数
 *     </li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ173 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 二叉树的头节点
     * @return 该二叉树的迭代器
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof TreeNode) {
            return new BSTIterator((TreeNode) obj);
        }
        return null;
    }
}

/**
 * 本题需要实现的二叉树的迭代器
 */
class BSTIterator {
    /**
     * 保存二叉树值的小顶堆
     */
    private Queue<Integer> heap;

    /**
     * 堆的迭代器
     */
    private Iterator<Integer> iterator;

    /**
     * 默认构造器, 中序遍历使用小顶堆保存数值
     *
     * @param root 二叉树的头节点
     */
    public BSTIterator(TreeNode root) {
        heap = new PriorityQueue<>();
        inorderTraversal(root);
        iterator = heap.iterator();
    }

    /**
     * 获得下一个最小值
     *
     * @return 下一个最小值
     */
    public int next() {
        return iterator.next();
    }

    /**
     * 判断是否存在下一个值
     *
     * @return 是否存在下一个值
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * 中序遍历并保存到堆中
     *
     * @param node 树的节点
     */
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        heap.offer(node.val);
        inorderTraversal(node.right);
    }
}
