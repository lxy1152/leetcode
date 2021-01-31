package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1Test extends AbstractTest {
    /**
     * {@inheritDoc}
     */
    @Before
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1();
    }

    @Test
    public void testSolutionCaseOne() {
        Assert.assertArrayEquals(new Integer[]{0, 1}, (Integer[]) solution.solve(new Integer[]{2, 7, 11, 5}, 9));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertArrayEquals(new Integer[]{1, 2}, (Integer[]) solution.solve(new Integer[]{3, 2, 4}, 6));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertArrayEquals(new Integer[]{0, 1}, (Integer[]) solution.solve(new Integer[]{3, 3}, 6));
    }
}
