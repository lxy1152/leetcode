package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ264}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ264Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ264();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(12, solution.solve(10));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve(1));
    }
}
