package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ368}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ368Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ368();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[2, 1]", solution.solve(new int[]{1, 2, 3}).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[8, 4, 2, 1]", solution.solve(new int[]{1, 2, 4, 8}).toString());
    }
}
