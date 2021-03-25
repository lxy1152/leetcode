package xyz.lixiangyu.algorithm.common.linkedlist;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 *
 * <p>
 * 描述:<br>
 * 存在一个按升序排列的链表, 给你这个链表的头节点{@code head}, 请你删除链表中所有存在数字重复情况的节点, 只保留原始链表中没有重复出现的数字,
 * 返回同样按升序排列的结果链表
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code head = [1, 2, 3, 3, 4, 4, 5]}<br>
 * 输出: {@code [1, 2, 5]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code head = [1, 1, 1, 2, 3]}<br>
 * 输出: {@code [2, 3]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>链表中节点数目在范围 [0, 300] 内</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>题目数据保证链表已经按升序排列</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ82 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 链表的头节点
     * @return 删除重复元素后的链表
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof ListNode) {
            return deleteDuplicates((ListNode) obj);
        }
        return null;
    }

    /**
     * 删除链表中的重复元素
     *
     * <p>
     * 思路:<br>
     * 如果有两个相邻节点的值相同就表示有重复元素, 然后根据这个值循环删除节点
     * </p>
     *
     * @param head 链表的头节点
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode node = dummyNode;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int val = node.next.val;
                while (node.next != null && node.next.val == val) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        return dummyNode.next;
    }
}
