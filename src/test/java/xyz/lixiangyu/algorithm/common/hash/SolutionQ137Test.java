package xyz.lixiangyu.algorithm.common.hash;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ137}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ137Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ137();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve(new int[]{2, 2, 3, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(99, solution.solve(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
