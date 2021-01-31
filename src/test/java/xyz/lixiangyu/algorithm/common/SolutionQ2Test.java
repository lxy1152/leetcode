package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ2}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ2Test extends AbstractTest {
    /**
     * {@inheritDoc}
     */
    @Before
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ2();
    }

    @Test
    public void testSolutionCaseOne() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode result = new ListNode(7);
        result.next = new ListNode(0);
        result.next.next = new ListNode(8);
        Assert.assertEquals(result.toString(), solution.solve(listNode1, listNode2).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode listNode1 = new ListNode(0);

        ListNode listNode2 = new ListNode(0);

        ListNode result = new ListNode(0);
        Assert.assertEquals(result.toString(), solution.solve(listNode1, listNode2).toString());
    }

    @Test
    public void testSolutionCaseThree() {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);

        ListNode result = new ListNode(8);
        result.next = new ListNode(9);
        result.next.next = new ListNode(9);
        result.next.next.next = new ListNode(9);
        result.next.next.next.next = new ListNode(0);
        result.next.next.next.next.next = new ListNode(0);
        result.next.next.next.next.next.next = new ListNode(0);
        result.next.next.next.next.next.next.next = new ListNode(1);
        Assert.assertEquals(result.toString(), solution.solve(listNode1, listNode2).toString());
    }
}
