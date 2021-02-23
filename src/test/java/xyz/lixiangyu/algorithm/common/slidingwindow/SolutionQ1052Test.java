package xyz.lixiangyu.algorithm.common.slidingwindow;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1052}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1052Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1052();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                16,
                solution.solve(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(
                24,
                solution.solve(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
    }
}
