package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ153}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ153Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ153();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(1, solution.solve(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(0, solution.solve(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(11, solution.solve(new int[]{11, 13, 15, 17}));
    }
}
