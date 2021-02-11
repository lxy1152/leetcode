package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ904}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ904Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ904();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve(new int[]{1, 2, 1}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve(new int[]{0, 1, 2, 2}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(4, solution.solve(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(5, solution.solve(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
