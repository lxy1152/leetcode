package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ485}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ485Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ485();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
