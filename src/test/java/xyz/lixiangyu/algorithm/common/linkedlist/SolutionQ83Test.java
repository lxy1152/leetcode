package xyz.lixiangyu.algorithm.common.linkedlist;

import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.ListNode;

/**
 * {@link SolutionQ83}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ83Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ83();
    }

    @Override
    public void testSolutionCaseOne() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        System.out.println(solution.solve(head));
    }

    @Test
    public void testSolutionCaseTwo() {
        ListNode head = null;
        System.out.println(solution.solve(head));
    }
}
