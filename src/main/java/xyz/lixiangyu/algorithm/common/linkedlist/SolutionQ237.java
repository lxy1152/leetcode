package xyz.lixiangyu.algorithm.common.linkedlist;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">237. 删除链表中的节点</a>
 *
 * <p>
 * 描述:<br>
 * 请编写一个函数, 使其可以删除某个链表中给定的(非末尾)节点, 传入函数的唯一参数为要被删除的节点<br>
 * 现有一个链表: 4 -> 5 -> 1 -> 9, 即下方示例中的{@code head}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code head = [4, 5, 1, 9], node = 5}<br>
 * 输出: {@code [4, 1, 9]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code head = [4, 5, 1, 9], node = 1}<br>
 * 输出: {@code [4, 5, 9]}
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
public class SolutionQ237 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 链表中的某个节点
     * @return 不需要返回
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof ListNode) {
            deleteNode((ListNode) obj);
        }
        return null;
    }

    /**
     * 在没有传入头节点的情况下删除某个节点
     *
     * <p>
     * 思路:<br>
     * 只需要让当前节点取下一个节点的{@code val}和{@code next}就可以了
     * </p>
     *
     * @param node 链表中的某个节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
