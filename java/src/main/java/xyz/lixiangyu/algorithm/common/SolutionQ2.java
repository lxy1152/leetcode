package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">2. 两数相加</a>
 *
 * <p>
 * 描述:<br>
 * 给你两个非空的链表, 表示两个非负的整数. 它们每位数字都是按照逆序的方式存储的, 并且每个节点只能存储一位数字.<br>
 * 请你将两个数相加, 并以相同形式返回一个表示和的链表.<br>
 * 你可以假设除了数字0之外, 这两个数都不会以0开头.
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code l1 = [2, 4, 3], l2 = [5, 6, 4]}<br>
 * 输出: {@code [7, 0, 8]}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code l1 = [0], l2 = [0]}<br>
 * 输出: {@code [0]}
 * </p>
 *
 * <p>
 * 示例输出3:<br>
 * 输入: {@code l1 = [9, 9, 9, 9, 9, 9, 9], l2 = [9, 9, 9, 9]}<br>
 * 输出: {@code [8, 9, 9, 9, 0, 0, 0, 1]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>每个链表中的节点数在范围{@code [1, 100]}内</li>
 *     <li>{@code 0 <= Node.val <= 9}</li>
 *     <li>题目数据保证列表表示的数字不含前导零</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ2 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  第一个链表
     * @param obj1 第二个链表
     * @return 相加后的值
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof ListNode && obj1 instanceof ListNode) {
            return addTwoNumbers((ListNode) obj, (ListNode) obj1);
        }
        return null;
    }

    /**
     * <p>
     * 思路:<br>
     * 同时遍历两个链表, 只有在当前节点都为空时才退出循环<br>
     * 如果对应节点为空, 值取0<br>
     * 在相加时(还有最后一次计算)要考虑进位的影响
     * </p>
     *
     * <p>
     * <b>
     * 由于只取0-9之间的整数, 所以计算进位时可以换成:<br>
     * {@code carry = sum > 9 ? 1 : 0;}
     * {@code sum = sum > 9 ? sum - 10 : sum;}
     * </b>
     * </p>
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 相加后的值
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建一个节点用来保存返回结果
        ListNode result = new ListNode(0);
        // 这个节点会不断后移插入新的结果
        ListNode current = result;
        // 储存进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int firstNumber = 0;
            int secondNumber = 0;
            // 如果当前节点不为空, 则取val并获取next
            if (l1 != null) {
                firstNumber = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                secondNumber = l2.val;
                l2 = l2.next;
            }
            // 取两数和, 同时还要加上进位
            int sum = firstNumber + secondNumber + carry;
            // 计算进位
            carry = sum / 10;
            // 和应该排除掉进位
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
        }
        // 如果最后一次计算有进位, 要保留进位
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        // 第一个节点保存的是0, 不需要返回
        return result.next;
    }
}

/**
 * 本题使用的链表的数据结构
 */
class ListNode {
    /**
     * 当前节点保存的数据
     */
    int val;

    /**
     * 指向下一个节点
     */
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 重写toString, 用于junit测试时比较数据是否相同
     *
     * @return string
     */
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
