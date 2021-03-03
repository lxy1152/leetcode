package xyz.lixiangyu.algorithm.common.queue;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ232}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ232Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ232();
    }

    @Override
    public void testSolutionCaseOne() {
        MyQueue queue = (MyQueue) solution.solve();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.peek());
        Assert.assertEquals(1, queue.pop());
        Assert.assertFalse(queue.empty());
    }
}
