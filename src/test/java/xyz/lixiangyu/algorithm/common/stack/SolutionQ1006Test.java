package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1006}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1006Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1006();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(7, solution.solve(4));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(12, solution.solve(10));
    }
}
