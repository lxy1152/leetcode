package xyz.lixiangyu.algorithm.common.slidingwindow;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ995}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ995Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ995();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[]{0, 1, 0}, 1));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(-1, solution.solve(new int[]{1, 1, 0}, 2));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(3, solution.solve(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }
}
