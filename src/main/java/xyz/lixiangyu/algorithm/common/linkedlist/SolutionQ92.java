package xyz.lixiangyu.algorithm.common.linkedlist;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 *
 * <p>
 * 描述:<br>
 * 给你单链表的头节点{@code head}和两个整数{@code left}和{@code right}, 其中{@code left <= right}<br>
 * 请你反转从位置{@code left}到位置{@code right}的链表节点, 返回反转后的链表
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code head = [1, 2, 3, 4, 5], left = 2, right = 4}<br>
 * 输出: {@code [1, 4, 3, 2, 5]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code head = [5], left = 1, right = 1}<br>
 * 输出: {@code [5]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>链表中节点数目为 n</li>
 *     <li>1 <= n <= 500</li>
 *     <li>-500 <= Node.val <= 500</li>
 *     <li><b>1 <= left <= right <= n</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ92 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 要反转的链表和区间
     * @return 反转后的链表
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof ListNode && objects[1] instanceof Integer && objects[2] instanceof Integer) {
            return reverseBetween((ListNode) objects[0], (int) objects[1], (int) objects[2]);
        }
        return null;
    }

    /**
     * 反转部分的链表
     *
     * <p>
     * 思路:<br>
     * 使用头插法反转链表
     * </p>
     *
     * @param head  头节点
     * @param left  区间最左边的位置
     * @param right 区间最右边的位置
     * @return 反转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 在头之前设置一个哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // pre表示待反转区域的第一个节点的前一个节点
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // cur表示当前待反转的节点
        ListNode cur = pre.next;
        // next表示待反转节点的下一个节点
        ListNode next;
        // 对区域内的节点进行反转
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
