package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.algorithm.constants.Constants;

/**
 * {@link SolutionQ518}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ518Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ518();
        solutionType = Constants.FAST_SOLUTION;
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(4, solution.solve(5, new int[]{1, 2, 5}, solutionType));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(0, solution.solve(3, new int[]{2}, solutionType));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(1, solution.solve(10, new int[]{10}, solutionType));
    }
}
