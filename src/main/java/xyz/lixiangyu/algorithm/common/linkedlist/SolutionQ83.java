package xyz.lixiangyu.algorithm.common.linkedlist;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">83. 删除排序链表中的重复元素</a>
 *
 * <p>
 * 描述:<br>
 * 存在一个按升序排列的链表, 给你这个链表的头节点{@code head}, 请你删除所有重复的元素, 使每个元素只出现一次,
 * 返回同样按升序排列的结果链表
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code head = [1, 1, 2]}<br>
 * 输出: {@code [1, 2]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code head = [1, 1, 2, 3, 3]}<br>
 * 输出: {@code [1, 2, 3]}
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
public class SolutionQ83 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个升序链表
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
     * 删除链表中的重复元素, 使得链表中每个元素只出现一次
     *
     * <p>
     * 思路:<br>
     * 与{@linkplain SolutionQ82 82题}类似, 可参考82题的实现思路
     * </p>
     *
     * @param head 一个升序链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if (head == null) {
            return null;
        }
        while (node.next != null) {
            if (node.val == node.next.val) {
                int val = node.val;
                while (node.next != null && node.next.val == val) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
