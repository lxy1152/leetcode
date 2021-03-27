package xyz.lixiangyu.algorithm.common.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * {@link SolutionQ61}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ61Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ61();
    }

    @Override
    public void testSolutionCaseOne() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals("4->5->1->2->3->null", solution.solve(head, 2).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        Assert.assertEquals("2->0->1->null", solution.solve(head, 4).toString());
    }
}
