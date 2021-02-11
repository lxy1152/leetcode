package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ992}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ992Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ992();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(7, solution.solve(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
