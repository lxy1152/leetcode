package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ561}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ561Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ561();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(4, solution.solve(new int[]{1, 4, 3, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(9, solution.solve(new int[]{6, 2, 6, 5, 1, 2}));
    }
}
