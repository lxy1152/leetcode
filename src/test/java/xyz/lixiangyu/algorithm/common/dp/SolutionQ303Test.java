package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ303}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ303Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ303(new int[]{-2, 0, 3, -5, 2, -1});
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(1, solution.solve(0, 2));
        Assert.assertEquals(-1, solution.solve(2, 5));
        Assert.assertEquals(-3, solution.solve(0, 5));
    }
}
