package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.algorithm.constants.Constants;

/**
 * {@link SolutionQ416}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ416Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ416();
        solutionType = Constants.FAST_SOLUTION;
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve(new int[]{1, 5, 11, 5}, solutionType));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve(new int[]{1, 2, 3, 5}, solutionType));
    }
}
