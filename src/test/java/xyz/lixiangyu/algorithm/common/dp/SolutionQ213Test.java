package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ213}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ213Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ213();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve(new int[]{2, 3, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve(new int[]{1, 2, 1, 1}));
    }
}
