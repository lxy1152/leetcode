package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ896}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ896Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ896();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve(new int[]{1, 2, 2, 3}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(true, solution.solve(new int[]{6, 5, 4, 4}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(false, solution.solve(new int[]{1, 3, 2}));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(true, solution.solve(new int[]{1, 2, 4, 5}));
    }

    @Test
    public void testSolutionCaseFive() {
        Assert.assertEquals(true, solution.solve(new int[]{1, 1, 1}));
    }
}
