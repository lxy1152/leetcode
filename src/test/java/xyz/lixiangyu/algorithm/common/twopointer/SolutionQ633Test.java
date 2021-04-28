package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ633}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ633Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ633();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertTrue((boolean) solution.solve(5));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertFalse((boolean) solution.solve(3));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertTrue((boolean) solution.solve(4));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertTrue((boolean) solution.solve(2));
    }

    @Test
    public void testSolutionCaseFive() {
        Assert.assertTrue((boolean) solution.solve(1));
    }
}
