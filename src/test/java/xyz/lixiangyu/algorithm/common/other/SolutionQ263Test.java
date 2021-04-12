package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ263}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ263Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ263();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertTrue((boolean) solution.solve(6));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertTrue((boolean) solution.solve(8));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertFalse((boolean) solution.solve(14));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertTrue((boolean) solution.solve(1));
    }
}
