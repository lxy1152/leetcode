package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ781}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ781Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ781();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(5, solution.solve(new int[]{1, 1, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(11, solution.solve(new int[]{10, 10, 10}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(0, solution.solve(new int[]{}));
    }
}
