package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ697}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ697Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ697();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[]{1, 2, 2, 3, 1}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(6, solution.solve(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
