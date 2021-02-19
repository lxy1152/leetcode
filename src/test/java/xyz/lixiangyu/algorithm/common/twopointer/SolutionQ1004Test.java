package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1004}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1004Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1004();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(6, solution.solve(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(
                10,
                solution.solve(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
