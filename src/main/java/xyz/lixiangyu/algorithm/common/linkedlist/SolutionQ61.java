package xyz.lixiangyu.algorithm.common.linkedlist;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/rotate-list/">61. 旋转链表</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个链表, 你需要根据给定的{@code k}来旋转链表, 将链表每个节点向右移动{@code k}个位置, 其中{@code k}是非负数
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code 1->2->3->4->5->NULL, k = 2}<br>
 * 输出: {@code 4->5->1->2->3->NULL}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code 0->1->2->NULL, k = 4}<br>
 * 输出: {@code 2->0->1->NULL}
 * </p>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ61 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  链表头节点
     * @param obj1 进行旋转的次数
     * @return 旋转后链表的头节点
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof ListNode && obj1 instanceof Integer) {
            return rotateRight((ListNode) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 旋转链表
     *
     * <p>
     * 对链表进行多次旋转后的结果实际上与{@code k % n}的结果是一样的({@code n}是链表长度), 因此可以求出链表长度
     * 再根据对应的{@code k}找到要对链表进行拆分的位置, 将链表一分为二<br>
     * 注意: 需要将最后一个节点重新指向头节点
     * </p>
     *
     * @param head 链表头节点
     * @param k    进行旋转的次数
     * @return 旋转后链表的头节点
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 如果链表为空或者只有头节点或者k是0, 直接返回头节点
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表的长度
        ListNode node = head;
        int n = 0;
        while (node != null) {
            node = node.next;
            n++;
        }

        // 如果操作旋转的次数正好是链表长度的整数倍, 那么直接返回头节点
        int num = k % n;
        if (num == 0) {
            return head;
        }

        // 否则移动到对应的节点的位置
        node = head;
        int offset = n - num - 1;
        for (int i = 0; i < offset; i++) {
            node = node.next;
        }
        // 把链表从node节点的位置拆成两半
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = node.next;

        // 修改最后一个节点指向头节点
        ListNode node1 = node;
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = head;

        // 把node节点的下一节点设置为最后一个节点
        node.next = null;

        return dummyNode.next;
    }
}
