package xyz.lixiangyu.algorithm.common.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.ListNode;

public class SolutionQ92Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ92();
    }

    @Override
    public void testSolutionCaseOne() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(
                "ListNode{val=1, next=ListNode{val=4, next=ListNode{val=3, next=ListNode{val=2, next=ListNode{val=5, next=null}}}}}",
                solution.solve(head, 2, 4).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode head = new ListNode(5);
        Assert.assertEquals(
                "ListNode{val=5, next=null}",
                solution.solve(head, 1, 1).toString());
    }
}
