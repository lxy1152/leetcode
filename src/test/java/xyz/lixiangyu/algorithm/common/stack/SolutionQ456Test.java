package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ456}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ456Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ456();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(false, solution.solve(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(true, solution.solve(new int[]{3, 1, 4, 2}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(true, solution.solve(new int[]{-1, 3, 2, 0}));
    }
}
