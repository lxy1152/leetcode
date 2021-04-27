package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ377}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ377Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ377();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(7, solution.solve(new int[]{1, 2, 3}, 4));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(0, solution.solve(new int[]{9}, 3));
    }
}
