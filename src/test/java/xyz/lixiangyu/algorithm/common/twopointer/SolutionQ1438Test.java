package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1438}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1438Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1438();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[]{8, 2, 4, 7}, 4));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(4, solution.solve(new int[]{10, 1, 2, 4, 7, 2}, 5));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(3, solution.solve(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }
}
