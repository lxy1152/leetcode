package xyz.lixiangyu.algorithm.common.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.ListNode;

public class SolutionQ82Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ82();
    }

    @Override
    public void testSolutionCaseOne() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        String expected = "ListNode{val=1, next=ListNode{val=2, next=ListNode{val=5, next=null}}}";
        Assert.assertEquals(expected, solution.solve(head).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        String expected = "ListNode{val=2, next=ListNode{val=3, next=null}}";
        Assert.assertEquals(expected, solution.solve(head).toString());
    }

    @Test
    public void testSolutionCaseThree() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        System.out.println(solution.solve(head));
    }
}
