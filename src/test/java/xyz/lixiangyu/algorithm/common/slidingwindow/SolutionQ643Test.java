package xyz.lixiangyu.algorithm.common.slidingwindow;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ643}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ643Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ643();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(12.75, solution.solve(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
