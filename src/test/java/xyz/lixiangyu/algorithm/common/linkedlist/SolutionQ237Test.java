package xyz.lixiangyu.algorithm.common.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * @author lixiangyu
 */
public class SolutionQ237Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ237();
    }

    @Override
    public void testSolutionCaseOne() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        solution.solve(listNode.next);
        Assert.assertEquals(
                "ListNode{val=4, next=ListNode{val=1, next=ListNode{val=9, next=null}}}",
                listNode.toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        solution.solve(listNode.next.next);
        Assert.assertEquals(
                "ListNode{val=4, next=ListNode{val=5, next=ListNode{val=9, next=null}}}",
                listNode.toString());
    }
}
